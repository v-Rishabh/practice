using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ReconService.Interface;
using System.Data;
using log4net;
using ReconService.DBConnectionFactory;
using System.Globalization;

namespace ReconService.Classes
{
    class GetRouteDetails
    {
        ILog log = LogManager.GetLogger(typeof(GetRouteDetails));
        OracleConnection_Class oracleDB = new OracleConnection_Class();

        public Dictionary<string, string> getRouteData(string Shift_ID, DateTime Duty_Date, string tripSeq)
        {
            log.Info("In getRouteData");
            Dictionary<string, string> details = new Dictionary<string, string>();
            details.Add("RESULT", "FALSE");
            string ROUTENAME = string.Empty;
            string ORIGIN = string.Empty;
            string DESTINATION = string.Empty;
            
            // Step 1: Get index of first occurance for A or M from shift_id.
            int subIndex = Shift_ID.IndexOf('A');
            if (subIndex == -1) {
                subIndex = Shift_ID.IndexOf('M');
            }
            // Unable to process.
            if (subIndex == -1) {
                return details;
            }
 
            // Step 2: Substring Shift_Id from 0 till the index of A or M.
            string shiftParamForDB = Shift_ID.Substring(0,subIndex+1)+"%";
            DateTime startDate = Duty_Date.AddDays(-30);
            DateTime endDate = Duty_Date;
            string startD = startDate.ToString("dd-MMM-yy", CultureInfo.InvariantCulture);
            string endD = endDate.ToString("dd-MMM-yy", CultureInfo.InvariantCulture);
            
            // Step 3: Pass this substring shift and Duty date to query. [Get DataSet in return]
            string query = "SELECT * FROM TRIP_DETAILS WHERE SHIFT_ID LIKE '" + shiftParamForDB + "' AND (TRUNC(TRIP_START_TIME) BETWEEN TO_DATE('" + startD + "','DD-MM-YY') AND TO_DATE('" + endD + "','DD-MM-YY')) AND ROWNUM <= 8 ORDER BY TRIP_ID";
            DataSet queryDS = oracleDB.SelectRecordsETMDB(query);

            if (queryDS.Tables[0].Rows.Count > 0)
            {
                for (int i = 0; i < queryDS.Tables[0].Rows.Count; i++)
                {
                    string tripID = queryDS.Tables[0].Rows[i]["TRIP_ID"].ToString().Trim();
                    string seq = tripID[tripID.Length - 1].ToString();

                    if (tripSeq.Equals(seq))
                    {
                        ROUTENAME = queryDS.Tables[0].Rows[i]["ROUTENAME"].ToString().Trim();
                        ORIGIN = queryDS.Tables[0].Rows[i]["ORG_STOP_ID"].ToString().Trim();
                        DESTINATION = queryDS.Tables[0].Rows[i]["DEST_STOP_ID"].ToString().Trim();
                        break;
                    }
                }
                
                if (ROUTENAME.Equals(string.Empty) && ORIGIN.Equals(string.Empty) && DESTINATION.Equals(string.Empty))
                {
                    if (int.Parse(tripSeq) % 2 == 0)
                    {
                        ROUTENAME = queryDS.Tables[0].Rows[2]["ROUTENAME"].ToString().Trim();
                        ORIGIN = queryDS.Tables[0].Rows[2]["ORG_STOP_ID"].ToString().Trim();
                        DESTINATION = queryDS.Tables[0].Rows[2]["DEST_STOP_ID"].ToString().Trim();

                        details["RESULT"] = "TRUE";
                        details.Add("ROUTENAME", ROUTENAME);
                        details.Add("ORIGIN", ORIGIN);
                        details.Add("DESTINATION", DESTINATION);
                    }
                    else {
                        ROUTENAME = queryDS.Tables[0].Rows[1]["ROUTENAME"].ToString().Trim();
                        ORIGIN = queryDS.Tables[0].Rows[1]["ORG_STOP_ID"].ToString().Trim();
                        DESTINATION = queryDS.Tables[0].Rows[1]["DEST_STOP_ID"].ToString().Trim();

                        details["RESULT"] = "TRUE";
                        details.Add("ROUTENAME", ROUTENAME);
                        details.Add("ORIGIN", ORIGIN);
                        details.Add("DESTINATION", DESTINATION);
                    }
                }
                else 
                {
                    details["RESULT"] = "TRUE";
                    details.Add("ROUTENAME", ROUTENAME);
                    details.Add("ORIGIN", ORIGIN);
                    details.Add("DESTINATION", DESTINATION);
                }
                //details["RESULT"] = "TRUE";
                //details.Add("ROUTENAME", ROUTENAME);
                //details.Add("ORIGIN", ORIGIN);
                //details.Add("DESTINATION", DESTINATION);
            }
            else {
                return details;
            }
            
            // Step 4: Extract Shift and trip from DataSet add to map and return.
            
            log.Info("Exiting getRouteData");
            return details;
        }
    }
}
