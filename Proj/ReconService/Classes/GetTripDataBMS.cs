using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ReconService.Interface;
using log4net;
using System.Data;
using ReconService.DBConnectionFactory;

namespace ReconService.Classes
{
    class GetTripDataBMS : IgetTripDataBMS
    {
        ILog log = LogManager.GetLogger(typeof(GetTripDataBMS));
        public DataSet getTripDataFromBMS(string Duty, string Duty_Date, string Conductor_ID)
        {
            log.Info("In getTripDataFromBMS");
            DataSet TripData_BMS = new DataSet();

            ISQLConnection_Class sql = new SQLConnection_Class();
            TripData_BMS = sql.getBMSData(Duty, Duty_Date, Conductor_ID);

            log.Info("Exiting getTripDataFromBMS");
            return TripData_BMS;
        }
    }
}
