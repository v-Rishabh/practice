using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Interface
{
    interface ISaveTripRecord
    {
        bool saveTripRecord(DataSet Trips);

        bool savePartialTripRecord(DataSet Trips);
    }
}
