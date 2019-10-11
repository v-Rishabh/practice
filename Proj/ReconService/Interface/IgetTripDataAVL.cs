using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Interface
{
    interface IgetTripDataAVL
    {
        DataSet getTripDataFromAVL(string Duty, string Duty_Date);
    }
}
