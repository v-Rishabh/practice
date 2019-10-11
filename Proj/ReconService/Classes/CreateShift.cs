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
    class CreateShift : ICreateShiftRecords
    {
        ILog log = LogManager.GetLogger(typeof(CreateShift));
        OracleConnection_Class conn = new OracleConnection_Class();

        /// <summary>
        /// This method would take Duty record from BMS and then
        /// it would create Shift with data received.
        /// </summary>
        /// <param name="recordFromBMS">Shift Details</param>
        /// <returns></returns>
        public Dictionary<string, string> createShift(DataSet recordFromBMS)
        {
            log.Info("In CreateShift");
            string shiftId = string.Empty;
            Dictionary<string, string> ShiftDetails = new Dictionary<string, string>();
            ShiftDetails.Add("Created", "FALSE");

            // Fill Data from DataSet
            for (int i = 0; i < recordFromBMS.Tables[0].Rows.Count; i++) {
                string duty = recordFromBMS.Tables[0].Rows[i]["DUTY_NO"].ToString();
                string duty_Date = recordFromBMS.Tables[0].Rows[i]["DUTY_DATE"].ToString();
                string conductor_ID = recordFromBMS.Tables[0].Rows[i]["CONDUCTOR_ID"].ToString();
                string total_Trip = recordFromBMS.Tables[0].Rows[i]["TOTAL_TRIP"].ToString();
                string etm_Sr_No = recordFromBMS.Tables[0].Rows[i]["ETM_SRNO"].ToString();
                string etm_Revenue = recordFromBMS.Tables[0].Rows[i]["ETM_REVENUE"].ToString();
                string passenger_Count = recordFromBMS.Tables[0].Rows[i]["PASSENGER_COUNT"].ToString();
                string dmrc_Amount = recordFromBMS.Tables[0].Rows[i]["DMRC_AMOUNT"].ToString();
                string dmrc_Passenger_Count = recordFromBMS.Tables[0].Rows[i]["DMRC_PASSANGER_COUNT"].ToString();
                string duty_Start_time = recordFromBMS.Tables[0].Rows[i]["DUTY_START_TIME"].ToString();
                string duty_End_time = recordFromBMS.Tables[0].Rows[i]["DUTY_END_TIME"].ToString();
                string depot_code = recordFromBMS.Tables[0].Rows[i]["ETM_DEPOT_CODE"].ToString();
                string waybill_no = recordFromBMS.Tables[0].Rows[i]["WAYBILL_NO"].ToString();

                // If Duty is not for Afternoon then suffix it with "M"
                string[] etm_dutyArr = duty.Split('/');
                if (etm_dutyArr[1][etm_dutyArr[1].Length - 1] == 'A')
                {
                    // Length should be 3 or more otherwise prefix with 0.
                    if (etm_dutyArr[1].Length < 3)
                    {
                        etm_dutyArr[1] = "0" + etm_dutyArr[1];
                    }
                }
                else {
                    // Length should be 2 or more otherwise prefix with 0.
                    if (etm_dutyArr[1].Length < 2)
                    {
                        etm_dutyArr[1] = "0" + etm_dutyArr[1] + "M";
                    }
                    else {
                        etm_dutyArr[1] = etm_dutyArr[1] + "M";
                    }
                }

                string etm_Duty = etm_dutyArr[0] + etm_dutyArr[1];

                // Get ETM_UID
                string ETM_UID = string.Empty;
                if (!etm_Sr_No.Equals("NO ETM"))
                {
                    ETM_UID = conn.getETMUID(etm_Sr_No);
                }
                else {
                    ETM_UID = "NNNNN";
                }

                /* Check Duty in Depot_Duty_Map */
                int indexToDuty = duty.IndexOf('/');
                string dutyToCheck = duty.Substring(0, indexToDuty);
                string query = "SELECT * FROM DEPOT_DUTY_MAP WHERE DUTY_FIELD='" + dutyToCheck + "' AND DEPOT_ID='" + depot_code + "'";
                OracleConnection_Class oracle = new OracleConnection_Class();
                DataSet DutyCheckDS = new DataSet();
                DutyCheckDS = oracle.SelectRecordsETMDB(query);
                if(DutyCheckDS.Tables[0].Rows.Count <= 0){
                    ShiftDetails["Created"] = "DUTY_NOT_PRESENT";
                    return ShiftDetails;
                }

                // Format Duty Date
                string[] dutyDateArr = duty_Date.Split(' ');
                var ci = new CultureInfo("");
                var formats = new[] {"dd-MM-yyyy"}.Union(ci.DateTimeFormat.GetAllDateTimePatterns()).ToArray();
                DateTime Duty_Date_con = DateTime.ParseExact(dutyDateArr[0], formats, ci, DateTimeStyles.AssumeLocal);
                string finalDutyDate = Duty_Date_con.ToString("dd-MM-yy", CultureInfo.InvariantCulture);
                finalDutyDate = finalDutyDate.Replace("-", "");

                // Duty Time
                string[] duty_Start_time_arr = duty_Start_time.Split(' ');
                duty_Start_time = duty_Start_time_arr[1].Replace(":", "");

                // Create Shift Start Time
                DateTime Shift_Start_Time = DateTime.ParseExact(dutyDateArr[0], formats, ci, DateTimeStyles.AssumeLocal);
                string Shift_Start_Time_Str = Shift_Start_Time.ToString("dd-MMM-yy", CultureInfo.InvariantCulture);
                Shift_Start_Time_Str = Shift_Start_Time_Str + " " + duty_Start_time_arr[1];
                string Shift_Start_Time_Str_final = Convert.ToDateTime(Shift_Start_Time_Str.ToString()).ToString("dd/MM/yyyy hh:mm:ss tt").ToString();

                // Creating components of Shift Record
                string shift_ID = etm_Duty + ETM_UID + finalDutyDate + duty_Start_time;
                string messageID = ETM_UID + finalDutyDate + duty_Start_time;

                // Get Vehicle Number
                DataSet VehicleNumber_AVL = new DataSet();
                ISQLConnection_Class sql = new SQLConnection_Class();
                
                // Converting Date format as required in Proc
                DateTime Duty_Date_Proc = DateTime.ParseExact(dutyDateArr[0], formats, ci, DateTimeStyles.AssumeLocal);
                string final_Duty_Date_Proc = Duty_Date_Proc.ToString("yyyy-MM-dd", CultureInfo.InvariantCulture);

                VehicleNumber_AVL = sql.getVehicleNumber(recordFromBMS.Tables[0].Rows[i]["DUTY_NO"].ToString(), final_Duty_Date_Proc);

                // Vehicle Number
                string vehicleNumber = "";
                if (VehicleNumber_AVL.Tables[0].Rows.Count > 0)
                {
                    vehicleNumber = VehicleNumber_AVL.Tables[0].Rows[0]["Vehicle_No"].ToString();
                }

                // Shift_End_time
                string[] Shift_End_Date_Arr = Shift_Start_Time_Str.Split(' ');
                string[] Shift_End_Time_Arr = duty_End_time.Split(' ');
                string Shift_End_Time = Shift_End_Date_Arr[0] + " " + Shift_End_Time_Arr[1];

                // Calculating Total Passengers Count
                if (int.Parse(passenger_Count) == 0) {
                    int etmRevenue = int.Parse(etm_Revenue);
                    passenger_Count = (etmRevenue / 8).ToString();
                }

                // Storing data in Dictionary
                ShiftDetails.Add("Shift_ID", shift_ID);
                ShiftDetails.Add("Message_ID",messageID);
                ShiftDetails.Add("Depot_ID", depot_code);
                ShiftDetails.Add("Shift_Start_Time", Shift_Start_Time_Str_final);
                ShiftDetails.Add("ETM_UID",ETM_UID);
                ShiftDetails.Add("ETM_SR_NO", etm_Sr_No);
                ShiftDetails.Add("Conductor_Id",conductor_ID);
                ShiftDetails.Add("Driver_ID","");
                ShiftDetails.Add("Bus_Id", vehicleNumber); // Get it from AVL Proc
                ShiftDetails.Add("Submitter_ID","Auto Recon");
                ShiftDetails.Add("Submit_Date", DateTime.Now.ToString("dd-MMM-yy"));
                ShiftDetails.Add("IS_Approved","0");
                ShiftDetails.Add("Remarks","Generated Using AutoRecon Service");
                ShiftDetails.Add("Reason","");
                ShiftDetails.Add("waybill_no", waybill_no);
                ShiftDetails.Add("ETM_REVENUE", etm_Revenue);
                ShiftDetails.Add("PASSENGER_COUNT", passenger_Count);
                ShiftDetails.Add("SHIFT_START_TIME", Shift_Start_Time_Str);
                ShiftDetails.Add("SHIFT_END_TIME", Shift_End_Time);
                ShiftDetails["Created"] =  "TRUE";
            }

            log.Info("Exiting CreateShift");
            return ShiftDetails;
        }
    }
}
