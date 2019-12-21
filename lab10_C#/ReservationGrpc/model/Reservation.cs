using System;
using System.Runtime.CompilerServices;
using System.Security.Policy;

namespace Reservations.model
{
    [Serializable]

    public class Reservation : IHasID<string>
    {
        private string id;
        private string customerName;
        private string phoneNumber;
        private int noTickets;
        private Journey journey;

        public Reservation(string id, string customerName, string phoneNumber, int noTickets, Journey journey)
        {
            this.id = id;
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
            this.noTickets = noTickets;
            this.journey = journey;
        }

        public string ID
        {
            get { return id; }
            set { id = value; }
        }


        public string CustomerName
        {
            get => customerName;
            set => customerName = value;
        }

        public string PhoneNumber
        {
            get => phoneNumber;
            set => phoneNumber = value;
        }

        public int NoTickets
        {
            get => noTickets;
            set => noTickets = value;
        }

        public Journey Journey
        {
            get => journey;
            set => journey = value;
        }


        public override string ToString()
        {
            return string.Format("[Reservations: Id={0}, customerName={1}, phoneNumber={2}, noTickets={3}, journey={4}",
                id, customerName, phoneNumber, journey);
        }
    }
}