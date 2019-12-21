
using System;
using System.Collections.Generic;


namespace Reservations.model
{



    public interface ICrudRepository<ID, E>
    {


        E FindOne(ID id);
        IEnumerable<E> FindAll();
        void Save(E entity);
        //void Delete(ID id);
        //void Update(E entity);


    }
}