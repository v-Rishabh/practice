using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Interface
{
    interface IgetTripDataBMS
    {
        DataSet getTripDataFromBMS(string Duty, string Duty_Date, string Conductor_ID);
    }
}
