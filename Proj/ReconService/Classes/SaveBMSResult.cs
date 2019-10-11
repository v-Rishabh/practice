using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using log4net;
using Oracle.ManagedDataAccess.Client;

namespace ReconService.Classes
{
    class SaveBMSResult
    {
        static ILog log = LogManager.GetLogger(typeof(SaveBMSResult));
        string conn = System.Configuration.ConfigurationManager.ConnectionStrings["OracleConnectionStringDimts"].ConnectionString;

        public bool saveBMSData(DataSet DutyDetails) {
            OracleCommand cmd;
            OracleTransaction otran = null;
            OracleConnection con = new OracleConnection(conn);
            string vQry = string.Empty;
            string duty = string.Empty;
            string duty_Date = string.Empty;
            string conductor_ID = string.Empty;
            string total_Trip = string.Empty;
            string etm_Sr_No = string.Empty;
            string etm_Revenue = string.Empty;
            string passenger_Count = string.Empty;
            string dmrc_Amount = string.Empty;
            string dmrc_Passenger_Count = string.Empty;
            string duty_Start_time = string.Empty;
            string duty_End_time = string.Empty;
            string depot_code = string.Empty;
            string waybill_no = string.Empty;

            for (int i = 0; i < DutyDetails.Tables[0].Rows.Count; i++)
            {
                duty = DutyDetails.Tables[0].Rows[i]["DUTY_NO"].ToString();
                duty_Date = DutyDetails.Tables[0].Rows[i]["DUTY_DATE"].ToString();
                conductor_ID = DutyDetails.Tables[0].Rows[i]["CONDUCTOR_ID"].ToString();
                total_Trip = DutyDetails.Tables[0].Rows[i]["TOTAL_TRIP"].ToString();
                etm_Sr_No = DutyDetails.Tables[0].Rows[i]["ETM_SRNO"].ToString();
                etm_Revenue = DutyDetails.Tables[0].Rows[i]["ETM_REVENUE"].ToString();
                passenger_Count = DutyDetails.Tables[0].Rows[i]["PASSENGER_COUNT"].ToString();
                dmrc_Amount = DutyDetails.Tables[0].Rows[i]["DMRC_AMOUNT"].ToString();
                dmrc_Passenger_Count = DutyDetails.Tables[0].Rows[i]["DMRC_PASSANGER_COUNT"].ToString();
                duty_Start_time = DutyDetails.Tables[0].Rows[i]["DUTY_START_TIME"].ToString();
                duty_End_time = DutyDetails.Tables[0].Rows[i]["DUTY_END_TIME"].ToString();
                depot_code = DutyDetails.Tables[0].Rows[i]["ETM_DEPOT_CODE"].ToString();
                waybill_no = DutyDetails.Tables[0].Rows[i]["WAYBILL_NO"].ToString();
            }

            if (String.IsNullOrEmpty(duty) || String.IsNullOrEmpty(duty_Date)) {
                return false;
            }

            try
            {
                if (con.State == ConnectionState.Closed)
                {
                    con.Open();
                }
                otran = con.BeginTransaction();
                vQry = "Insert into BMS_DATA(DUTY_NO,DUTY_DATE,CONDUCTOR_ID,TOTAL_TRIP,ETM_SRNO,ETM_REVENUE,PASSENGER_COUNT,DMRC_AMOUNT,DMRC_PASSANGER_COUNT,DUTY_START_TIME,DUTY_END_TIME,ETM_DEPOT_CODE,WAYBILL_NO) values('" + duty + "','" + duty_Date + "','" + conductor_ID + "','" + total_Trip + "','" + etm_Sr_No + "','" + etm_Revenue + "','" + passenger_Count + "','" + dmrc_Amount + "','" + dmrc_Passenger_Count + "','" + duty_Start_time + "','" + duty_End_time + "','" + depot_code + "','" + waybill_no + "')";
                cmd = new OracleCommand(vQry, con);
                cmd.ExecuteNonQuery();
                otran.Commit();

                return true;
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
    }
}
