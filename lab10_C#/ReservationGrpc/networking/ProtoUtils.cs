using Res.Protocol;
using Reservations.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace networking
{
    public class ProtoUtils
    {

        public static  Res.Protocol.Journey getProtoJourney(Reservations.model.Journey journey)
        {
            return new Res.Protocol.Journey
            {
                Id = journey.ID,
                TouristicObjective = journey.TouristicObjective,
                TransportCompany = journey.TransportCompany,
                Price = journey.Price,
                DepartureTime = journey.DepartureTime,
                NoAvailableSeats = journey.NoAvailableSeats

            };
        }


        public static  Reservations.model.Reservation getModelResevation(Res.Protocol.Reservation protoRes)
        {
            return new Reservations.model.Reservation(
                    protoRes.Id,
                    protoRes.CustomerName,
                    protoRes.PhoneNumber,
                    protoRes.NoTickets,
                    getModelJourney(protoRes.Journey)
                );
        }



        public static  Reservations.model.Journey getModelJourney(Res.Protocol.Journey protoJourney)
        {
            return new Reservations.model.Journey(
                protoJourney.Id,
                protoJourney.TouristicObjective,
                protoJourney.TransportCompany,
                123,
                protoJourney.Price,
                protoJourney.NoAvailableSeats);
        }


        public static Reservations.model.AgencyEmployee getModelAgencyEmployee(Res.Protocol.AgencyEmployee agencyEmployee)
        {
            return new Reservations.model.AgencyEmployee(
                    agencyEmployee.Id,
                    agencyEmployee.Username,
                    agencyEmployee.Password
                );
        }

        public static Journeys GetProtoJourneysList(List<Reservations.model.Journey> journeys)
        {
            Journeys protoJourneys = new Res.Protocol.Journeys { };
            foreach (var j in journeys)
            {
                protoJourneys.Journey.Add(ProtoUtils.getProtoJourney(j));
            }
            return protoJourneys;
        }
    }
}
