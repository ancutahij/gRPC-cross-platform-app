using Res.Protocol;

using Reservations.repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Reservations.model;
using Grpc.Core;
using Nito.AsyncEx;
using System.Threading;
using networking;
using System.Diagnostics;

namespace server
{
    class ReservationServerImpl : ReservationService.ReservationServiceBase
    {
        private IAgencyEmployeeRepository agencyEmployeeRepository;
        private IJourneyRepository journeyRepository;
        private IReservationRepository reservationRepository;
        private readonly IDictionary<String, IServerStreamWriter<Notification>> responseStreams;
        //private  HashSet<IServerStreamWriter<ReservationResponse>> responseStreams = new HashSet<IServerStreamWriter<ReservationResponse>>();
        public ReservationServerImpl(IAgencyEmployeeRepository agencyEmployeeRepository, IJourneyRepository journeyRepository, IReservationRepository reservationRepository)
        {
            Console.Write("ReservervationServerImpl constructor -> C#");

            this.agencyEmployeeRepository = agencyEmployeeRepository;
            this.journeyRepository = journeyRepository;
            this.reservationRepository = reservationRepository;
            this.responseStreams = new Dictionary<string, IServerStreamWriter<Notification>>();
        }


        public override Task<global::Res.Protocol.ReservationResponse> login(global::Res.Protocol.ReservationRequest request, ServerCallContext context)
        {
            Reservations.model.AgencyEmployee employee = null;
            Reservations.model.AgencyEmployee modelEmployee = ProtoUtils.getModelAgencyEmployee(request.AgencyEmployee);
            try
            {
                employee = agencyEmployeeRepository.findAgencyEmployee(modelEmployee);
            }
            catch (RepositoryException ex)
            {
                return Task.FromResult(new ReservationResponse(new ReservationResponse {
                    Type = ReservationResponse.Types.Type.Error,
                    ErrorMessage= "Username or password is invalid."

                }));
               
            }

            if (responseStreams.ContainsKey(modelEmployee.username))
                return Task.FromResult(new ReservationResponse(new ReservationResponse
                {
                    Type = ReservationResponse.Types.Type.Error,
                    ErrorMessage = "Client already logged in."

                }));


            ReservationResponse loginResponse = new ReservationResponse
            {
                Type = ReservationResponse.Types.Type.Ok,
            };

            return Task.FromResult(new ReservationResponse(loginResponse));

        }
     

        public override Task subscribe(global::Res.Protocol.ReservationRequest request, 
            IServerStreamWriter<global::Res.Protocol.Notification> responseStream,
            ServerCallContext context)
        {
           // Console.WriteLine("subscribe method");
            Reservations.model.AgencyEmployee modelEmployee = ProtoUtils.getModelAgencyEmployee(request.AgencyEmployee);
            responseStreams[modelEmployee.username] = responseStream;
            var x = Task.Run (() =>
            {
                while (responseStreams.ContainsKey(modelEmployee.username)) { }
            } );
            
            //threads.Add(x);
      
            return x;
            
      
        }
        public override Task<ReservationResponse> getJourneys(ReservationRequest request, ServerCallContext context)
        {

            Journeys protoJourneys = ProtoUtils.GetProtoJourneysList(journeyRepository.FindAll().ToList());
           

            return Task.FromResult(new ReservationResponse
            {
                Journeys = protoJourneys,
                Type = ReservationResponse.Types.Type.Ok
            });

        }
        public override Task<global::Res.Protocol.ReservationResponse> getFilteredJourneys(global::Res.Protocol.ReservationRequest request, ServerCallContext context)
        {

            double startHour = Convert.ToDouble(request.FilteredJourney.StartTime);
            double endHour= Convert.ToDouble(request.FilteredJourney.EndTime);
            Journeys protoJourneys = ProtoUtils.GetProtoJourneysList((List<Reservations.model.Journey>)journeyRepository.filterByNameandTimeTable(request.FilteredJourney.Destination, 
                startHour, endHour));

            return Task.FromResult(new ReservationResponse
            {
                Journeys = protoJourneys,
                Type = ReservationResponse.Types.Type.Ok
            });

        }
        
        public override Task<global::Res.Protocol.ReservationResponse> logout(global::Res.Protocol.ReservationRequest request, ServerCallContext context)
        {
            string username = request.AgencyEmployee.Username;
            if (!responseStreams.ContainsKey(username))
                return Task.FromResult(new ReservationResponse(new ReservationResponse
                {
                    Type = ReservationResponse.Types.Type.Error,
                    ErrorMessage = "This client is already logged out."

                }));


            responseStreams.Remove(username);
          

            return Task.FromResult(new ReservationResponse(new ReservationResponse
            {
                Type = ReservationResponse.Types.Type.Ok

            }));
        }



        public override Task<ReservationResponse> saveReservation(global::Res.Protocol.ReservationRequest request, ServerCallContext context)
        {
            Reservations.model.Reservation modelReservation = ProtoUtils.getModelResevation(request.Reservation);

            try
            {
                reservationRepository.Save(modelReservation);

                Reservations.model.Journey journey = modelReservation.Journey;
                journey.NoAvailableSeats -= modelReservation.NoTickets;
                journeyRepository.Update(journey);
                Console.WriteLine(journey);
                Console.WriteLine(journey.NoAvailableSeats);
                // Create a server notification that wraps the modified journey
                Notification notification = new Res.Protocol.Notification
                {
                    Journey = ProtoUtils.getProtoJourney(journey)

                };

                // Send notification to connected clients
                notifyClients(notification);

                return Task.FromResult(new ReservationResponse
                {
                    Type = ReservationResponse.Types.Type.Ok
                });

            }
            catch(RepositoryException ex)
            {
                return Task.FromResult( new ReservationResponse 
                {
                    Type = ReservationResponse.Types.Type.Error,
                    ErrorMessage = ex.Message

                });
            }

        }

        private async Task notifyClients(Notification notification)
        {
            foreach ( var client in responseStreams.Values)
            {
                await client.WriteAsync(notification);
            }
        }

      
    }
}

