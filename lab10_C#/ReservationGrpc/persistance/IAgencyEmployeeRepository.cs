using Reservations.model;

namespace Reservations.repository
{
    public interface IAgencyEmployeeRepository: ICrudRepository<string, AgencyEmployee>
    {

         AgencyEmployee findAgencyEmployee(AgencyEmployee agency);


    }
}