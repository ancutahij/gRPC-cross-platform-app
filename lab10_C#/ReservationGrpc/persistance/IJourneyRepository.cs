using System;
using System.Collections;
using Reservations.model;

namespace Reservations.repository
{
    public interface IJourneyRepository : ICrudRepository<string, Journey>
    {
        IEnumerable filterByNameandTimeTable(string name, double start , double end);

        void Update(Journey journey);
    }
}