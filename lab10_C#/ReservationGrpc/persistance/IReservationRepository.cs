using Reservations.model;

namespace Reservations.repository
{
    public interface  IReservationRepository: ICrudRepository<string, Reservation>
    {
        
        
    }
}