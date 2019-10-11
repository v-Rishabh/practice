using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using log4net;
using Oracle.ManagedDataAccess.Client;

namespace ReconService.Classes
{
    class SaveBMSTripData
    {
        static ILog log = LogManager.GetLogger(typeof(SaveBMSTripData));
        string conn = System.Configuration.ConfigurationManager.ConnectionStrings["OracleConnectionStringDimts"].ConnectionString;

        public bool saveBMSDataTRIP(DataSet DutyDetails)
        {
            List<bool> result = new List<bool>();

            OracleCommand cmd;
            OracleTransaction otran = null;
            OracleConnection con = new OracleConnection(conn);
            string vQry = string.Empty;
            string duty = string.Empty;
            string duty_Date = string.Empty;
            string conductor_ID = string.Empty;
            string sequenceoftrip = string.Empty;
            string V_TRIP_START_TIME = string.Empty;
            string etm_Revenue = string.Empty;
            string V_TRIP_END_TIME = string.Empty;
            string V_SCHEDULEDKM = string.Empty;
            string V_ETM_DEPOT_CODE = string.Empty;

            for (int i = 0; i < DutyDetails.Tables[0].Rows.Count; i++)
            {
                duty = DutyDetails.Tables[0].Rows[i]["DUTY_NO"].ToString();
                duty_Date = DutyDetails.Tables[0].Rows[i]["DUTY_ALLOCATION_DATE"].ToString();
                conductor_ID = DutyDetails.Tables[0].Rows[i]["CONDUCTOR_ID"].ToString();
                sequenceoftrip = DutyDetails.Tables[0].Rows[i]["SEQUENCEOFTRIP"].ToString();
                etm_Revenue = DutyDetails.Tables[0].Rows[i]["ETM_REVENUE"].ToString();
                V_TRIP_START_TIME = DutyDetails.Tables[0].Rows[i]["TRIP_START_TIME"].ToString();
                V_TRIP_END_TIME = DutyDetails.Tables[0].Rows[i]["TRIP_END_TIME"].ToString();
                V_SCHEDULEDKM = DutyDetails.Tables[0].Rows[i]["SCHEDULEDKM"].ToString();
                V_ETM_DEPOT_CODE = DutyDetails.Tables[0].Rows[i]["ETM_DEPOT_CODE"].ToString();


                if (String.IsNullOrEmpty(duty) || String.IsNullOrEmpty(duty_Date))
                {
                    result.Add(false);
                    break;
                }

                try
                {
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }
                    otran = con.BeginTransaction();
                    vQry = "Insert into BMS_TRIP_DATA(DUTY_NO,DUTY_ALLOCATION_DATE,CONDUCTOR_ID,SEQUENCEOFTRIP,ETM_REVENUE,TRIP_START_TIME,TRIP_END_TIME,SCHEDULEDKM,ETM_DEPOT_CODE) values('" + duty + "','" + duty_Date + "','" + conductor_ID + "','" + sequenceoftrip + "','" + etm_Revenue + "','" + V_TRIP_START_TIME + "','" + V_TRIP_END_TIME + "','" + V_SCHEDULEDKM + "','" + V_ETM_DEPOT_CODE + "')";
                    cmd = new OracleCommand(vQry, con);
                    cmd.ExecuteNonQuery();
                    otran.Commit();

                    result.Add(true);
                }
                catch (Exception Ex)
                {
                    otran.Rollback();
                    log.Error(Ex.ToString());
                    log.Error("ERROR: DUTY_NO=" + duty + " DUTY_DATE=" + duty_Date + " CONDUCTOR_ID=" + conductor_ID);
                    return false;
                }
                finally
                {
                    if (con.State == ConnectionState.Open)
                    {
                        con.Close();
                    }
                }
            }

            foreach (bool val in result) {
                if (!val) {
                    return false;
                }
            }

            return true;
        }
    }
}
