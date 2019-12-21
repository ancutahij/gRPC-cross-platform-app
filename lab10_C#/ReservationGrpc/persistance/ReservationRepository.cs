using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using log4net;
using Reservations.model;

namespace Reservations.repository
{
    public class ReservationRepository: IReservationRepository
    {
        
        
        private static readonly ILog log = LogManager.GetLogger("ReservationsRepo");
        IDictionary<String, string> props;

        public ReservationRepository(IDictionary<String, string> props)
        {
            log.Info("Creating ReservationsRepo ");
            this.props = props;
        }
        
        
        public Reservation FindOne(string id)
        {
            throw new System.NotImplementedException();
        }

        public IEnumerable<Reservation> FindAll()
        {
            throw new System.NotImplementedException();
        }

        public void Save(Reservation entity)
        {
            log.Info("Saving Reservation Entity");
            try
            {
                var con = DBUtils.getConnection(props);

                if (entity.NoTickets > entity.Journey.NoAvailableSeats)
                {
                    log.Error("Not enough available seats for this Journey");
                    throw new RepositoryException("Not enough available seats for this Journey!");
                }

                using (var comm = con.CreateCommand())
                {
                    comm.CommandText =
                        "insert into Reservations  (customerName , phoneNumber, noTickets, journeyId) values (@name, @nr, @noTickets, @id)";

                    var paramName = comm.CreateParameter();
                    paramName.ParameterName = "@name";
                    paramName.Value = entity.CustomerName;
                    comm.Parameters.Add(paramName);

                    var paramNumber = comm.CreateParameter();
                    paramNumber.ParameterName = "@nr";
                    paramNumber.Value = entity.PhoneNumber;
                    comm.Parameters.Add(paramNumber);

                    var paramTickets = comm.CreateParameter();
                    paramTickets.ParameterName = "@noTickets";
                    paramTickets.Value = entity.NoTickets;
                    comm.Parameters.Add(paramTickets);

                    var paramId = comm.CreateParameter();
                    paramId.ParameterName = "@id";
                    paramId.Value = entity.Journey.ID;
                    comm.Parameters.Add(paramId);

                    var result = comm.ExecuteNonQuery();
                    if (result == 0)
                    {
                        log.Error("No Reservation saved");
                        throw new RepositoryException("No reservation added !");
                    }
                }

            }
            catch (SqlException exception)
            {
                log.Error(exception);
                throw  new RepositoryException(exception.ToString());
            }
            log.Info("Reservation entity saved!");
        }
        
    }
}