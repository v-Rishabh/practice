using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;
using System.Data;
using Oracle.ManagedDataAccess.Client;
using log4net;
using ReconService.DBConnectionFactory;

namespace ReconService.Classes
{
    class UnitTestClass
    {
        static ILog log = LogManager.GetLogger(typeof(UnitTestClass));
        string conn = System.Configuration.ConfigurationManager.ConnectionStrings["OracleConnectionStringDimts"].ConnectionString;
        string connETM = System.Configuration.ConfigurationManager.ConnectionStrings["OracleConnectionStringETM"].ConnectionString;

        public DataSet getTestBMSShiftData(string Duty, string Duty_Date, string Conductor_ID)
        {
            string query = "SELECT * FROM BMS_DATA where DUTY_NO='" + Duty+"' AND DUTY_DATE='"+Duty_Date+"' AND CONDUCTOR_ID = '"+Conductor_ID+"'";
            OracleConnection_Class oracle = new OracleConnection_Class();
            DataSet BMSShiftData = oracle.SelectRecordsOleDb(query);

            return BMSShiftData;
        }

        public DataSet getTestAVLData(string Duty, string Duty_Date)
        {
            Duty_Date += " 00:00:00";
            string query = "SELECT * FROM AVL_DATA where DUTY_NAME='" + Duty + "' AND DUTY_DATE='" + Duty_Date + "'";
            OracleConnection_Class oracle = new OracleConnection_Class();
            DataSet AVLDATA = oracle.SelectRecordsOleDb(query);

            return AVLDATA;
        }

        public DataSet getTripDataBMS(string Duty, string Duty_Date, string Conductor_ID)
        {
            Duty_Date += " 00:00:00";
            string query = "SELECT * FROM BMS_TRIP_DATA where DUTY_NO='" + Duty + "' AND DUTY_ALLOCATION_DATE='" + Duty_Date + "' AND CONDUCTOR_ID = '" + Conductor_ID + "'";
            OracleConnection_Class oracle = new OracleConnection_Class();
            DataSet BMSTRIPDATA = oracle.SelectRecordsOleDb(query);

            return BMSTRIPDATA;
        }
    }
}
