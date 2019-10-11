using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Interface
{
    interface IgetDutyDetailsBMS
    {
        DataSet getDutyDetailsFromBMS(int id, string Duty, string Duty_Date, string Conductor_ID);
    }
}
