using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using Reservations.model;
using log4net;

namespace Reservations.repository
{
    public class AgencyEmployeeRepository: IAgencyEmployeeRepository
    {
        private static readonly ILog log = LogManager.GetLogger("AgencyEmployeeDbRepository");
        IDictionary<String, string> props;

        public AgencyEmployeeRepository(IDictionary<String, string> props)
        {
            log.Info("Creating AgencyEmployeeRepo ");
            this.props = props;
        }



     

        public IEnumerable<AgencyEmployee> FindAll()
        {

            log.Info("Getting all entities from AgencyEmployees Table");
            IList<AgencyEmployee> agencyEmployees = new List<AgencyEmployee>();

            try
            {
                IDbConnection con = DBUtils.getConnection(props);
                using (var comm = con.CreateCommand())
                {
                    comm.CommandText = "select * from AgencyEmployees";

                    using (var dataR = comm.ExecuteReader())
                    {
                        while (dataR.Read())
                        {
                            int id = dataR.GetInt32(0);
                            String username = dataR.GetString(1);
                            String password = dataR[2].ToString();
                            agencyEmployees.Add(new AgencyEmployee(id.ToString(), username, password));

                        }
                    }
                }
            }
            catch (SqlException exception)
            {
                log.Error(exception);
                throw  new RepositoryException(exception.ToString());
            }
            

            log.Info("Got all AgencyEmployee entities");

            return agencyEmployees;
        }

        public  void Save(AgencyEmployee entity)
        {
            throw new System.NotImplementedException();
        }

        public AgencyEmployee findAgencyEmployee(AgencyEmployee agency)
        {

            log.Info("Getting entity from AgencyEmployees Table");

            AgencyEmployee agencyEmployee = null ;
            try
            {
                IDbConnection con = DBUtils.getConnection(props);
                using (var comm = con.CreateCommand())
                {
                    comm.CommandText = "select * from AgencyEmployees where username = @n and password = @p";

                    var paramN = comm.CreateParameter();
                    paramN.ParameterName = "@n";
                    paramN.Value = agency.username;
                    comm.Parameters.Add(paramN);

                    var paramP = comm.CreateParameter();
                    paramP.ParameterName = "@p";
                    paramP.Value = agency.password;
                    comm.Parameters.Add(paramP);


                    using (var dataR = comm.ExecuteReader())
                    {
                        while (dataR.Read())
                        {
                            int id = dataR.GetInt32(0);
                            String username = dataR.GetString(1);
                            String password = dataR[2].ToString();
                            
                            agencyEmployee = new AgencyEmployee(id.ToString(), username, password);

                        }
                    }
                }
            }
            catch (SqlException exception)
            {
                log.Error(exception);
                throw new RepositoryException(exception.ToString());
            }
            if (agencyEmployee == null)
            {
                throw new RepositoryException("No Agency Employee Found!!!");

            }



            return agencyEmployee;
        }

        public AgencyEmployee FindOne(string id)
        {
            throw new NotImplementedException();
        }
    }
}