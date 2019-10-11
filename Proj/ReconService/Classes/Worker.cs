using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using log4net;
using ReconService.Interface;
using System.Data;
using ReconService.DBConnectionFactory;

namespace ReconService.Classes
{
    public class Worker : IWorker
    {
        ILog log = LogManager.GetLogger(typeof(Worker));
        public void work()
        {
            log.Info("In Worker Class");
        }

        /* NOTE: Final Method will get duties 10 days prior to current day.*/
        /// <summary>
        /// This method would find data which are marked as "Missing in ETM" and these data would be processed for creating Shift and Trip Records
        /// </summary>
        /// <returns>DataSet containing records marked as "Missing in ETM" for the queried date</returns>
        public DataSet getMissingDuties() {
            log.Info("In getMissingDuties");

            DataSet missingDuties = new DataSet();

            OracleConnection_Class conn = new OracleConnection_Class();
            //string query = "Select * from etm_data_report where BMS_REASON_DESC = 'Missing in ETM' and BMS_DUTY_DATE = (select to_char(to_date(sysdate-11),'DD-MON-YY') FROM DUAL)";
            string query = "Select * from etm_data_report where BMS_REASON_DESC = 'Missing in ETM' and BMS_DUTY_DATE = (select to_char(to_date(sysdate-48),'DD-MON-YY') FROM DUAL)";
            missingDuties = conn.SelectRecordsOleDb(query);


            log.Info("Exiting getMissingDuties");
            return missingDuties;
        }
    }
}
