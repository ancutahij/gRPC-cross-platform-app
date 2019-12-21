using System;
using System.Runtime.CompilerServices;

namespace Reservations.model
{
    [Serializable]

    public class Journey : IHasID<string>
    {
        private string id;
        private string touristicObjective;
        private string transportCompany;
        private string departureTime;
        private double price;
        private int noAvailableSeats;

        public Journey(string id, string touristicObjective, string transportCompany, double departureTime, double price, int noAvailableSeats)
        {
            this.touristicObjective = touristicObjective;
            this.transportCompany = transportCompany;

            this.price = price;
            this.noAvailableSeats = noAvailableSeats;
            ID = id;

            string[] splits = departureTime
                .ToString()
                .Split('.');
            if (splits.Length > 1)
            {
                this.departureTime = splits[0] + ":" + splits[1].Substring(0, 2);

            }
            else
            {
                this.departureTime = splits[0] + ":00";
            }
        }

        public string ID
        {
            get { return id; }
            set { id = value; }
        }

        public string TouristicObjective
        {
            get => touristicObjective;
            set => touristicObjective = value;
        }

        public string TransportCompany
        {
            get => transportCompany;
            set => transportCompany = value;
        }

        public String DepartureTime
        {
            get => departureTime;
            set => departureTime = value;
        }

        public double Price
        {
            get => price;
            set => price = value;
        }

        public int NoAvailableSeats
        {
            get => noAvailableSeats;
            set => noAvailableSeats = value;
        }


        public override string ToString()
        {
            return string.Format("[Journey: Id={0}, touristicObjective={1}, transportCompany={2}, departureTime={3}, price={4}, " +
                                 "noAvailableSeats={5}]", id, touristicObjective, transportCompany, departureTime, price, noAvailableSeats);
        }

    }
}