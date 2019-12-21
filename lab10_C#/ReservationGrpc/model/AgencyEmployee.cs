namespace Reservations.model
{
    public class AgencyEmployee : IHasID<string>
    {
        private string id;
        public string username { get; set; }
        public string password { get; set; }

        public AgencyEmployee(string id, string username, string password)
        {
            this.id = id;
            this.username = username;
            this.password = password;

        }

        public string ID
        {
            get { return id; }
            set { id = value; }
        }


        public override string ToString()
        {
            return string.Format("[Agency Employee: Id={0}, Username={1}, Password={2}]", id, username, password);
        }
    }
}