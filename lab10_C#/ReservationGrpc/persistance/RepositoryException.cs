using System;

namespace Reservations.model
{
    public class RepositoryException : ApplicationException
    {
        public RepositoryException()
        {
        }

        public RepositoryException(String mess) : base(mess)
        {
        }

        public RepositoryException(String mess, Exception e) : base(mess, e)
        {
        }
    }
}