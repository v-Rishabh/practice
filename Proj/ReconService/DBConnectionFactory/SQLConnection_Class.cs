using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;
using log4net;
using ReconService.Interface;

namespace ReconService.DBConnectionFactory
{
    [Serializable]
    class SQLConnection_Class : ISQLConnection_Class
    {
        static ILog log = LogManager.GetLogger(typeof(SQLConnection_Class));

        public DataSet procETM_Recon(int id, string Duty, string Duty_Date, string Conductor_ID)
        {
            DataSet dt = new DataSet();
            SqlConnection con = new SqlConnection(Properties.Settings.Default.SQLConnection); ;
            try
            {
                SqlDataReader rdr = null;
                
                using (SqlCommand cmd = new SqlCommand("PRC_ETM_RECON", con))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.Add("@p_Type", SqlDbType.VarChar).Value = id;
                    cmd.Parameters.Add("@p_DutyDate", SqlDbType.VarChar).Value = Duty_Date;
                    cmd.Parameters.Add("@p_DutyNo", SqlDbType.VarChar).Value = Duty;
                    cmd.Parameters.Add("@p_ConductorId", SqlDbType.VarChar).Value = Conductor_ID;

                    con.Open();
                    rdr = cmd.ExecuteReader();
                    dt.Tables.Add("BMSDATA");
                    dt.Tables[0].Load(rdr);
                }
                return dt;
            }
            catch (Exception ex) {
                log.Error(ex.Message.ToString());
                throw new System.InvalidOperationException(ex.ToString());
            }
            finally{
                con.Close();
            }
        }

        public DataSet getAVLData(string Duty, string Duty_Date)
        {
            DataSet dt = new DataSet();
            SqlConnection con = new SqlConnection(Properties.Settings.Default.AVLSQLCONN);
            try
            {
                SqlDataReader rdr = null;

                using (SqlCommand cmd = new SqlCommand("PRC_AVL_TRIP", con))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.Add("@p_Type", SqlDbType.VarChar).Value = 1;
                    cmd.Parameters.Add("@p_DutyDate", SqlDbType.VarChar).Value = Duty_Date;
                    cmd.Parameters.Add("@p_DutyNo", SqlDbType.VarChar).Value = Duty;

                    con.Open();
                    rdr = cmd.ExecuteReader();
                    dt.Tables.Add("AVL_TRIP_DATA");
                    dt.Tables[0].Load(rdr);
                }
                return dt;
            }
            catch (Exception ex)
            {
                log.Error(ex.Message.ToString());
                throw new System.InvalidOperationException(ex.ToString());
            }
            finally
            {
                con.Close();
            }
        }

        public DataSet getVehicleNumber(string Duty, string Duty_Date)
        {
            DataSet dt = new DataSet();
            SqlConnection con = new SqlConnection(Properties.Settings.Default.AVLSQLCONN);
            try
            {
                SqlDataReader rdr = null;

                using (SqlCommand cmd = new SqlCommand("PRC_AVL_TRIP", con))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.Add("@p_Type", SqlDbType.VarChar).Value = 2;
                    cmd.Parameters.Add("@p_DutyDate", SqlDbType.VarChar).Value = Duty_Date;
                    cmd.Parameters.Add("@p_DutyNo", SqlDbType.VarChar).Value = Duty;

                    con.Open();
                    rdr = cmd.ExecuteReader();
                    dt.Tables.Add("VEHICLE_NUMBER");
                    dt.Tables[0].Load(rdr);
                }
                return dt;
            }
            catch (Exception ex)
            {
                log.Error(ex.Message.ToString());
                throw new System.InvalidOperationException(ex.ToString());
            }
            finally
            {
                con.Close();
            }
        }

        public DataSet getBMSData(string Duty, string Duty_Date, string Conductor_ID)
        {
            DataSet dt = new DataSet();
            SqlConnection con = new SqlConnection(Properties.Settings.Default.SQLConnection); ;
            try
            {
                SqlDataReader rdr = null;

                using (SqlCommand cmd = new SqlCommand("PRC_ETM_RECON", con))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.Add("@p_Type", SqlDbType.VarChar).Value = 2;
                    cmd.Parameters.Add("@p_DutyDate", SqlDbType.VarChar).Value = Duty_Date;
                    cmd.Parameters.Add("@p_DutyNo", SqlDbType.VarChar).Value = Duty;
                    cmd.Parameters.Add("@p_ConductorId", SqlDbType.VarChar).Value = Conductor_ID;

                    con.Open();
                    rdr = cmd.ExecuteReader();
                    dt.Tables.Add("BMSDATA");
                    dt.Tables[0].Load(rdr);
                }
                return dt;
            }
            catch (Exception ex)
            {
                log.Error(ex.Message.ToString());
                throw new System.InvalidOperationException(ex.ToString());
            }
            finally
            {
                con.Close();
            }
        }
    }
}
