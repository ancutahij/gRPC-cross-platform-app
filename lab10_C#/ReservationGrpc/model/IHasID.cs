using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Reservations.model
{

    public interface IHasID<TID>
    {

        TID ID { get; set; }
    }

}
