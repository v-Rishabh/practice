using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Interface
{
    interface ICreateTripRecords
    {
        DataSet createTrip(Dictionary<string, string> shiftDetails, DataSet TripData_AVL, DataSet tripDataBMS);
    }
}
