using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Interface
{
    interface IWorker
    {
        void work();

        DataSet getMissingDuties();
    }
}
