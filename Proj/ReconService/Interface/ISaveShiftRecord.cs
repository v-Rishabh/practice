using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ReconService.Interface
{
    interface ISaveShiftRecord
    {
        bool saveTripRecord(Dictionary<string, string> shiftRecordsList);
    }
}
