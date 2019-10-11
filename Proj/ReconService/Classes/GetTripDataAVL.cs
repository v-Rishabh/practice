using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ReconService.Interface;
using System.Data;
using log4net;
using ReconService.DBConnectionFactory;

namespace ReconService.Classes
{
    class GetTripDataAVL : IgetTripDataAVL
    {
        ILog log = LogManager.GetLogger(typeof(GetTripDataAVL));

        public DataSet getTripDataFromAVL(string Duty, string Duty_Date) {
            log.Info("In getTripDataFromAVL");
            DataSet TripData_AVL = new DataSet();

            ISQLConnection_Class sql = new SQLConnection_Class();
            TripData_AVL = sql.getAVLData(Duty, Duty_Date);//("108/10", "2016-04-06");

            log.Info("Exiting getTripDataFromAVL");
            return TripData_AVL;
        }
    }
}
