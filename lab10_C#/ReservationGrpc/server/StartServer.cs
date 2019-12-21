using Grpc.Core;
using Res.Protocol;
using Reservations.repository;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace server
{
    class StartServer
    {
        static void Main(string[] args)
        {
            const int Port = 9090;

            IDictionary<String, string> serverProps = new SortedList<String, String>();
            serverProps.Add("ConnectionString", GetConnectionStringByName("reservationDB"));

            IAgencyEmployeeRepository agencyEmployeeRepository = new AgencyEmployeeRepository(serverProps);
            IJourneyRepository journeyRepository = new JourneyRepository(serverProps);
            IReservationRepository reservationRepository = new ReservationRepository(serverProps);


            Server server = new Server
            {
                Services = { ReservationService.BindService(new ReservationServerImpl(agencyEmployeeRepository, journeyRepository, reservationRepository)) },
                Ports = { new ServerPort("localhost", 9090, ServerCredentials.Insecure) }
            };
            server.Start();
            

            


            Console.WriteLine("");
            Console.WriteLine("Reservation server listening on port " + Port);
            Console.WriteLine("Press any key to stop the server...");
            Console.ReadKey();

            server.ShutdownAsync().Wait();
        }
        static string GetConnectionStringByName(string name)
        {
            string returnValue = null;
            ConnectionStringSettings settings = ConfigurationManager.ConnectionStrings[name];
            if (settings != null)
                returnValue = settings.ConnectionString;

            return returnValue;
        }

    }


}
