using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using log4net;
using Oracle.ManagedDataAccess.Client;

namespace ReconService.Classes
{
    class SaveAVLResult
    {
        static ILog log = LogManager.GetLogger(typeof(SaveAVLResult));
        string conn = System.Configuration.ConfigurationManager.ConnectionStrings["OracleConnectionStringDimts"].ConnectionString;

        public void saveAVLData(DataSet TripAVLDetails)
        {
            OracleCommand cmd;
            OracleTransaction otran = null;
            OracleConnection con = new OracleConnection(conn);
            string vQry = string.Empty;
            string trip_seqno = string.Empty;
            string depot_id = string.Empty;
            string duty_date = string.Empty;
            string depot_name = string.Empty;
            string vehicle_no = string.Empty;
            string duty_name = string.Empty;
            string route_name = string.Empty;
            string origin_stop_id = string.Empty;
            string dest_stop_id = string.Empty;
            
            for (int i = 0; i < TripAVLDetails.Tables[0].Rows.Count; i++)
            {
                trip_seqno = TripAVLDetails.Tables[0].Rows[i]["Trip_SeqNo"].ToString();
                depot_id = TripAVLDetails.Tables[0].Rows[i]["Depot_Id"].ToString();
                duty_date = TripAVLDetails.Tables[0].Rows[i]["Duty_Date"].ToString();
                depot_name = TripAVLDetails.Tables[0].Rows[i]["Depot_Name"].ToString();
                vehicle_no = TripAVLDetails.Tables[0].Rows[i]["Vehicle_No"].ToString();
                duty_name = TripAVLDetails.Tables[0].Rows[i]["Duty_Name"].ToString();
                route_name = TripAVLDetails.Tables[0].Rows[i]["Route_Name"].ToString();
                origin_stop_id = TripAVLDetails.Tables[0].Rows[i]["Origin_Stop_ID"].ToString();
                dest_stop_id = TripAVLDetails.Tables[0].Rows[i]["Dest_Stop_ID"].ToString();

                // Inserting Rows
                try
                {
                    if (con.State == ConnectionState.Closed)
                    {
                        con.Open();
                    }
                    otran = con.BeginTransaction();
                    vQry = "Insert into AVL_DATA(Trip_SeqNo,DEPOT_ID,DUTY_DATE,DEPOT_NAME,VEHICLE_NO,DUTY_NAME,ROUTE_NAME,ORIGIN_STOP_ID,DEST_STOP_ID) values('" + trip_seqno + "','" + depot_id + "','" + duty_date + "','" + depot_name + "','" + vehicle_no + "','" + duty_name + "','" + route_name + "','" + origin_stop_id + "','" + dest_stop_id + "')";
                    cmd = new OracleCommand(vQry, con);
                    cmd.ExecuteNonQuery();
                    otran.Commit();
                }
                catch (Exception Ex)
                {
                    otran.Rollback();
                    log.Error(Ex.ToString());
                    log.Error("ERROR: duty_name=" + duty_name + " duty_date=" + duty_date + " route_name=" + route_name);
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
}
