using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Runtime.CompilerServices;
using log4net;
using Reservations.model;

namespace Reservations.repository
{
    public class JourneyRepository : IJourneyRepository
    {
        public Journey FindOne(string id)
        {
            throw new NotImplementedException();
        }

        private static readonly ILog log = LogManager.GetLogger("JourneyDbRepository");
        IDictionary<String, string> props;

        public JourneyRepository(IDictionary<String, string> props)
        {
            log.Info("Creating JourneyRepo ");
            this.props = props;
        }

        public IEnumerable<Journey> FindAll()
        {

            log.Info("Getting all Journey entities");
            IList<Journey> journeys = new List<Journey>();

            try
            {
                IDbConnection con = DBUtils.getConnection(props);
                using (var comm = con.CreateCommand())
                {
                    comm.CommandText = "select * from Journeys";

                    using (var dataR = comm.ExecuteReader())
                    {
                        while (dataR.Read())
                        {
                            int id = dataR.GetInt32(0);
                            String touristicObjective = dataR.GetString(1);
                            String transportCompany = dataR[2].ToString();
                            Double departureTime = TimeSpan.FromMilliseconds(dataR.GetInt32(3)).TotalHours;
                            double price = dataR.GetDouble(4);
                            int seats = dataR.GetInt32(5);
                            journeys.Add(new Journey(id.ToString(), touristicObjective, transportCompany, departureTime,
                                price, seats));

                        }
                    }
                }
            }
            catch (SqlException exception)
            {
                log.Error(exception);
                throw new RepositoryException(exception.ToString());
            }


            log.Info(" Got all Journey entities");


            return journeys;
        }

        public void Save(Journey entity)
        {
            throw new NotImplementedException();
        }

        public IEnumerable filterByNameandTimeTable(string name, double start, double end)
        {
            log.Info("Getting all Journey entities with the given destination and between the provided timetable");
            IList<Journey> journeys = new List<Journey>();
            double  startMilliseconds = 3600000 * start;
            double endMilliseconds = 3600000 * end;

            try
            {
                IDbConnection con = DBUtils.getConnection(props);
                using (var comm = con.CreateCommand())
                {
                    comm.CommandText =
                        "select * from Journeys where   departureTime >= @start and  departureTime <= @end and touristicObjective = @dest ";

                    var paramDest = comm.CreateParameter();
                    paramDest.ParameterName = "@dest";
                    paramDest.Value = name;
                    comm.Parameters.Add(paramDest);

                    var paramStart = comm.CreateParameter();
                    paramStart.ParameterName = "@start";
                    paramStart.Value = TimeSpan.FromHours(startMilliseconds).TotalMilliseconds;
                    comm.Parameters.Add(paramStart);

                    var paramEnd = comm.CreateParameter();
                    paramEnd.ParameterName = "@end";
                    paramEnd.Value = TimeSpan.FromHours(endMilliseconds).TotalMilliseconds;
                    comm.Parameters.Add(paramEnd);

                    using (var dataR = comm.ExecuteReader())
                    {
                        while (dataR.Read())
                        {
                            int id = dataR.GetInt32(0);
                            String touristicObjective = dataR.GetString(1);
                            String transportCompany = dataR[2].ToString();
                            Double departureTime = TimeSpan.FromMilliseconds(dataR.GetInt32(3)).TotalHours;
                            if (departureTime < 0.01)
                                departureTime = 0.0;
                            double price = dataR.GetDouble(4);
                            int seats = dataR.GetInt32(5);
                            if ( start <= departureTime && end >=departureTime)
                                  journeys.Add(new Journey(id.ToString(), touristicObjective, transportCompany, departureTime,
                                       price, seats));

                        }
                    }
                }


            }
            catch (SqlException exception)
            {
                log.Error(exception);
                throw new RepositoryException(exception.ToString());
            }

            log.Info("Getting all Journey entities with the given destination and between the provided timetable");


            return journeys;
        }

        public void Update(Journey journey)
        {
            log.Info("Updating Journey Entity");
            try
            {
                var con = DBUtils.getConnection(props);



                using (var comm = con.CreateCommand())
                {
                    comm.CommandText =
                        "update Journeys set noAvailableSeats = @nr where id = @id";

                    var paramNr = comm.CreateParameter();
                    paramNr.ParameterName = "@nr";
                    paramNr.Value = journey.NoAvailableSeats;
                    comm.Parameters.Add(paramNr);

                    var paramId = comm.CreateParameter();
                    paramId.ParameterName = "@id";
                    paramId.Value = journey.ID;
                    comm.Parameters.Add(paramId);

                    var result = comm.ExecuteNonQuery();
                    if (result == 0)
                    {
                        log.Error("No Journey updated");
                        throw new RepositoryException("No Journey updated !");
                    }
                }
            }
            catch (SqlException exception)
            {
                log.Error(exception);
                throw new RepositoryException(exception.ToString());
            }
            log.Info("Journey entity updated");
        }
    }
}