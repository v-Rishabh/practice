using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Interface
{
    interface ISQLConnection_Class
    {
        DataSet getAVLData(string Duty, string Duty_Date);
        DataSet getBMSData(string Duty, string Duty_Date, string Conductor_ID);
        DataSet getVehicleNumber(string Duty, string Duty_Date);
        DataSet procETM_Recon(int id, string Duty, string Duty_Date, string Conductor_ID);
    }
}
