using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;
//using Oracle.DataAccess.Client;
using System.Data;
using Oracle.ManagedDataAccess.Client;
using log4net;

namespace ReconService.DBConnectionFactory
{
    [Serializable]
    public class OracleConnection_Class
    {
        static ILog log = LogManager.GetLogger(typeof(OracleConnection_Class));
        string conn = System.Configuration.ConfigurationManager.ConnectionStrings["OracleConnectionStringDimts"].ConnectionString;

        string connETM = System.Configuration.ConfigurationManager.ConnectionStrings["OracleConnectionStringETM"].ConnectionString;

        public DataSet SelectRecordsOleDb(string Query)
        {
            log.Info("Inside SelectRecordsOleDb");
            DataSet ds = new DataSet();
            OracleConnection con = new OracleConnection(conn);

            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd.CommandText = Query;
                cmd.CommandType = CommandType.Text;
                OracleDataAdapter da = new OracleDataAdapter();
                da.SelectCommand = cmd;
                da.Fill(ds);
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting SelectRecordsOleDb");
            }
            return ds;
        }

        public DataSet SelectRecordsETMDB(string Query)
        {
            log.Info("Inside SelectRecordsETMDB");
            DataSet ds = new DataSet();
            OracleConnection con = new OracleConnection(connETM);

            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd.CommandText = Query;
                cmd.CommandType = CommandType.Text;
                OracleDataAdapter da = new OracleDataAdapter();
                da.SelectCommand = cmd;
                da.Fill(ds);
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting SelectRecordsETMDB");
            }
            return ds;
        }

        public string getETMUID(string ETM_SR_NO) {
            log.Info("In getETMUID");
            string etm_uid = string.Empty;
            DataSet ETM_UID_DS = new DataSet();
            OracleConnection con = new OracleConnection(connETM);
            string etmQuery = "Select ETM_UID from ETM_MASTER WHERE ETM_SR_NO='"+ETM_SR_NO+"'";
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd.CommandText = etmQuery;
                cmd.CommandType = CommandType.Text;
                OracleDataAdapter da = new OracleDataAdapter();
                da.SelectCommand = cmd;
                da.Fill(ETM_UID_DS);
                //etm_uid = ETM_UID_DS.Tables[0].Rows[0]["ETM_UID"].ToString();

                if (ETM_UID_DS.Tables[0].Rows.Count > 0)
                {
                    etm_uid = ETM_UID_DS.Tables[0].Rows[0]["ETM_UID"].ToString();
                }
                else
                {
                    etm_uid = "NNNNN";
                }

                return etm_uid;
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting getETMUID");
            }

            return etm_uid;
        }

        public string getRouteType(string Route_ID)
        {
            log.Info("In getRouteType");
            string RouteType = string.Empty;
            DataSet RouteType_DS = new DataSet();
            OracleConnection con = new OracleConnection(connETM);
            string etmQuery = "select Route_Type from Route_Master where ROUTE_ID='" + Route_ID + "'";
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd.CommandText = etmQuery;
                cmd.CommandType = CommandType.Text;
                OracleDataAdapter da = new OracleDataAdapter();
                da.SelectCommand = cmd;
                da.Fill(RouteType_DS);
                RouteType = RouteType_DS.Tables[0].Rows[0]["ROUTE_TYPE"].ToString();

                return RouteType;
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting getRouteType");
            }

            return RouteType;
        }

        public bool saveRecord(string vQry)
        {
            log.Info("In saveRecord");
            bool isSaved = false;
            //DataSet RouteType_DS = new DataSet();
            OracleConnection con = new OracleConnection(connETM);
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd = new OracleCommand(vQry, con);
                int res;
                res = cmd.ExecuteNonQuery();
                if (res == 1) {
                    isSaved = true;
                }
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting saveRecord");
            }
            return isSaved;
        }

        public bool savePartialTrips(string vQry)
        {
            log.Info("In savePartialTrips");
            bool isSaved = false;
            OracleConnection con = new OracleConnection(connETM);
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd = new OracleCommand(vQry, con);
                int res;
                res = cmd.ExecuteNonQuery();
                if (res == 1)
                {
                    isSaved = true;
                }
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting savePartialTrips");
            }
            return isSaved;
        }

        public bool saveException(string vQry)
        {
            log.Info("In saveException");
            bool isSaved = false;
            OracleConnection con = new OracleConnection(conn);
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd = new OracleCommand(vQry, con);
                int res;
                res = cmd.ExecuteNonQuery();
                if (res == 1)
                {
                    isSaved = true;
                }
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting saveException");
            }
            return isSaved;
        }

        public bool deleteRecord(string vQry)
        {
            log.Info("In deleteRecord");
            bool isDeleted = false;
            OracleConnection con = new OracleConnection(connETM);
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.Connection = con;
                cmd.Connection.Open();
                cmd = new OracleCommand(vQry, con);
                int res;
                res = cmd.ExecuteNonQuery();
                if (res == 1)
                {
                    isDeleted = true;
                }
            }
            catch (Exception ex)
            {
                //throw new Exception(ex.Message.ToString());
                log.Error(ex.Message.ToString());
            }
            finally
            {
                cmd.Connection.Close();
                con.Dispose();
                log.Info("Exiting deleteRecord");
            }
            return isDeleted;
        }
    }
}
