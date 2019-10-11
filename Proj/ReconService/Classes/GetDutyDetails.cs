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
    class GetDutyDetails : IgetDutyDetailsBMS 
    {
        ILog log = LogManager.GetLogger(typeof(GetDutyDetails));

        /// <summary>
        /// This method would query the BMS with required parameters and in return would get duty details for queried data.
        /// </summary>
        /// <param name="Duty">Duty as in BMS</param>
        /// <param name="Duty_Date">Date of Duty</param>
        /// <param name="Conductor_ID">Conductor ID of Duty</param>
        /// <returns>Data Set containing details for creating Shift Record, Except ETM Serial number and RouteName.</returns>
        public DataSet getDutyDetailsFromBMS(int id, string Duty, string Duty_Date, string Conductor_ID) {
            log.Info("In getDutyDetailsFromBMS");
            DataSet dutyDetails = new DataSet();

            ISQLConnection_Class sql = new SQLConnection_Class();
            dutyDetails = sql.procETM_Recon(id,Duty,Duty_Date,Conductor_ID);

            log.Info("Exiting getDutyDetailsFromBMS");
            return dutyDetails;
        }
    }
}
