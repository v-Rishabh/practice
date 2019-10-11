using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ReconService.Interface;
using ReconService.Classes;
using ReconService.DBConnectionFactory;
using System.Data;
using log4net;
using System.Globalization;

namespace ReconService.Classes
{
    public class DriverClass
    {
        ILog log = LogManager.GetLogger(typeof(DriverClass));
        OracleConnection_Class oracle = new OracleConnection_Class();
        UnitTestClass UTC = new UnitTestClass();
        public DriverClass() {
            // Constructor
        }

        /// <summary>
        /// This method does all the work of extracting data and calling methods for processing them.
        /// </summary>
        public void callMethods() {
            log.Info("In callMethods");
            IWorker worker = new Worker();
            
            // Step 1: Getting missing duties
            DataSet missingDuties = worker.getMissingDuties();

            // Step 2: Create Shift Records
            ICreateShiftRecords createShiftRecords = new CreateShift();
            IgetDutyDetailsBMS getDutyfromBMS = new GetDutyDetails();
            //ICreateTripRecords createTrips = new CreateTrips();
            ICreateTripRecords createTrips = null;
            IgetTripDataAVL getAVLTrips = new GetTripDataAVL();

            /* Traverse the Missing Records DataSet,
             * One by one get the details from BMS corresponding to all the shifts(Duties).
             * Pass Duty, Duty Date and Conductor ID to get all the records.
             */
            
            // TEST ARRAY LIST FOR TESTING SHIFTS CREATED VS PUSHED IN PARTIAL TABLE.
            List<string> shiftsCreated = new List<string>();
            List<string> shiftsWithNoAVLData = new List<string>();
            List<string> shiftsNotCreated = new List<string>();
            List<string> shiftsDeleted = new List<string>();
            Dictionary<string, bool> shiftsInsertResult = new Dictionary<string, bool>();

            // Traversing the rows of missing duties.
            for (int i = 0; i < missingDuties.Tables[0].Rows.Count; i++)
            {
                // Get Duty[BMS_DUTY_NO],Duty_date[BMS_DUTY_DATE] and Conductor ID[BMS_CONDUCTOR_ID]
                string[] Duty = missingDuties.Tables[0].Rows[i]["BMS_DUTY_NO"].ToString().Split(',');
                string Duty_Date = missingDuties.Tables[0].Rows[i]["BMS_DUTY_DATE"].ToString();
                string Conductor_ID = missingDuties.Tables[0].Rows[i]["BMS_CONDUCTOR_ID"].ToString();

                if (Conductor_ID.Length < 5) {
                    Conductor_ID = "0" + Conductor_ID;
                }

                // Converting Duty Date format to one required by BMS
                string[] dutyDateArr = Duty_Date.Split(' ');
                var ci = new CultureInfo("");
                //var formats = new[] { "M-d-yyyy", "dd-MM-yyyy", "MM-dd-yyyy", "dd/MM/yyyy", "dd/MMM/yyyy", "dd-MMM-yyyy" }.Union(ci.DateTimeFormat.GetAllDateTimePatterns()).ToArray();
                var formats = new[] { "dd-MM-yyyy"}.Union(ci.DateTimeFormat.GetAllDateTimePatterns()).ToArray();
                DateTime Duty_Date_con = DateTime.ParseExact(dutyDateArr[0], formats, ci, DateTimeStyles.AssumeLocal);
                string finalDutyDate = Duty_Date_con.ToString("yyyy-MM-dd", CultureInfo.InvariantCulture);

                
                // In Case of Multiple Duties passed in Duty Column of BMS then Iterate through all the duties.
                for(int dutySeq = 0; dutySeq < Duty.Length; dutySeq++)
                {
                    // Step 3: Get Shift Data from BMS.
                    // Pass Type 1 for Shift and 2 for Trips
                    int type = 1;
                    
                    /* Uncomment before moving to production */
                    DataSet dutyReceivedFromBMS = getDutyfromBMS.getDutyDetailsFromBMS(type, Duty[dutySeq], finalDutyDate, Conductor_ID);

                    /* TESTING With Dev Data */
                    //DataSet dutyReceivedFromBMS = UTC.getTestBMSShiftData(Duty[dutySeq], finalDutyDate, Conductor_ID);

                    // Iterate only if DataSet has rows in it.
                    if (dutyReceivedFromBMS.Tables[0].Rows.Count > 0)
                    {
                        /* UnComment before Moveing into Production */
                        // Step 5: Save result of BMS in Oracle
                        SaveBMSResult sbr = new SaveBMSResult();
                        bool saveResult = sbr.saveBMSData(dutyReceivedFromBMS);

                        if (saveResult == false)
                        {
                            // Store this [Duty, finalDutyDate, Conductor_ID] in Exceptions Table. Reason Data Fetched could not be saved
                            log.Warn(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + " Could not be stored in table BMS_DATA.");
                            string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'Unable to Save BMS Data in BMS_DATA table')";
                            bool saveException = oracle.saveException(query);
                            continue;
                        }
                        /* UnComment before Moveing into Production */

                        // Step 6: Create Shift
                        Dictionary<string, string> shiftDetails = new Dictionary<string, string>();
                        shiftDetails = createShiftRecords.createShift(dutyReceivedFromBMS);

                        //Proceed only when shift was successfully created
                        string shiftCreationResult = shiftDetails["Created"];

                        if (shiftCreationResult.Equals("DUTY_NOT_PRESENT"))
                        {
                            log.Warn(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + " BMS and ETM Duty could not be matched.");
                            string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'BMS and ETM Duty could not be matched')";
                            bool saveException = oracle.saveException(query);
                            continue;
                        }
                        else if (shiftCreationResult.Equals("TRUE"))
                        {
                            // TEST 
                            shiftsCreated.Add(shiftDetails["Shift_ID"]);

                            /* UnComment before Moveing into Production */
                            // Step 7: Get Data from AVL
                            DataSet TripData_AVL = getAVLTrips.getTripDataFromAVL(Duty[dutySeq], finalDutyDate);

                            /* TESTING With Dev Data */
                            //DataSet TripData_AVL = UTC.getTestAVLData(Duty[dutySeq], finalDutyDate);

                            if (TripData_AVL.Tables[0].Rows.Count > 0)
                            {
                                // Step 8: Push shift Record to Partial_Shift_Closer Table in Oracle
                                ISaveShiftRecord saveShift = new SaveShiftRecord();
                                bool isShiftSaved = saveShift.saveTripRecord(shiftDetails);

                                // TEST
                                shiftsInsertResult.Add(shiftDetails["Shift_ID"], isShiftSaved);

                                /* UnComment before Moveing into Production */
                                // Step 9: Save AVL Result in Oracle
                                SaveAVLResult sar = new SaveAVLResult();
                                sar.saveAVLData(TripData_AVL);


                                /* UnComment before Moveing into Production */
                                // Step 10: Get Trip Data from BMS
                                IgetTripDataBMS tripDataBMS = new GetTripDataBMS();
                                DataSet tripDataBMS_DS = new DataSet();
                                tripDataBMS_DS = tripDataBMS.getTripDataFromBMS(Duty[dutySeq], finalDutyDate, Conductor_ID);

                                /* TESTING With Dev Data */
                                //DataSet tripDataBMS_DS = new DataSet();
                                //tripDataBMS_DS = UTC.getTripDataBMS(Duty[dutySeq], finalDutyDate, Conductor_ID);

                                if (tripDataBMS_DS.Tables[0].Rows.Count > 0)
                                {
                                    // Check If Trip from BMS is less than or equal to Trips in AVL, if not then save it as exception and delete its shift.
                                    if (tripDataBMS_DS.Tables[0].Rows.Count <= TripData_AVL.Tables[0].Rows.Count)
                                    {
                                        /* UnComment before Moveing into Production */
                                        // Save fetched Trip Data for records.
                                        SaveBMSTripData vSaveBMSTripData = new SaveBMSTripData();
                                        bool tripBackupSucces = vSaveBMSTripData.saveBMSDataTRIP(tripDataBMS_DS);

                                        // Step 11: Create Trips
                                        createTrips = new CreateTrips();
                                        DataSet Trips = new DataSet();
                                        Trips = createTrips.createTrip(shiftDetails, TripData_AVL, tripDataBMS_DS);

                                        
                                        
                                        /* If Returned Trips DataSet has no record then Continue to next record in iteration */
                                        if (Trips.Tables[0].Rows.Count <= 0) {
                                            continue;
                                        }


                                        // Step 12: Push Trip Records to Partial_Closure_History Table in Oracle
                                        if (isShiftSaved)
                                        {
                                            ISaveTripRecord saveTrip = new SaveTripRecord();
                                            bool isTripSaved = saveTrip.saveTripRecord(Trips);
                                        }
                                        else
                                        {
                                            // Add to Exception : Shift was not inserted into Partial_Shift_Closer.
                                            log.Error(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + " : Shift=" + shiftDetails["Shift_ID"] + " was not inserted into Partial_Shift_Closer");
                                            string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'Shift was not inserted into Partial_Shift_Closer, Check Log for Database Error')";
                                            bool saveException = oracle.saveException(query);
                                        }
                                    }
                                    // This else would run when Trips received from BMS and AVL Mismatch.[Line no. 147] 
                                    else {
                                        // Store this [Duty, finalDutyDate, Conductor_ID] in Exceptions Table.
                                        // Remarks : Shift Created but Trips Not Found in BMS. 
                                        log.Error(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + " : Shift=" + shiftDetails["Shift_ID"] + " Shift Created but Number of Trips mismatched in BMS and AVL.");
                                        string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'Shift Created but Number of Trips mismatched in BMS and AVL.')";
                                        bool saveException = oracle.saveException(query);
                                        string shiftForDeletion = shiftDetails["Shift_ID"];
                                        RollbackCreatedShift rollback = new RollbackCreatedShift();
                                        bool isShiftDeleted = rollback.rollbackShift(shiftForDeletion);
                                        if (isShiftDeleted)
                                        {
                                            shiftsDeleted.Add(shiftForDeletion);
                                            shiftsInsertResult.Remove(shiftForDeletion);
                                            log.Warn(shiftForDeletion + " Shift_ID Deleted as Number of Trips mismatched in BMS and AVL.");
                                        }
                                    }
                                }
                                // This else would be executed when Trips are not found in BMS.
                                else
                                {
                                    // Store this [Duty, finalDutyDate, Conductor_ID] in Exceptions Table.
                                    // Remarks : Shift Created but Trips Not Found in BMS. 
                                    log.Error(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + " : Shift=" + shiftDetails["Shift_ID"] + " Shift Created but Trips Not Found in BMS.");
                                    string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'Shift Created but Trips Not Found in BMS')";
                                    bool saveException = oracle.saveException(query);

                                    // Rollback the Shift from PARTIAL_SHIFT_CLOSER Table.
                                    string shiftForDeletion = shiftDetails["Shift_ID"];

                                    RollbackCreatedShift rollback = new RollbackCreatedShift();
                                    bool isShiftDeleted = rollback.rollbackShift(shiftForDeletion);

                                    if (isShiftDeleted) {
                                        shiftsDeleted.Add(shiftForDeletion);
                                        shiftsInsertResult.Remove(shiftForDeletion);
                                        log.Warn(shiftForDeletion + " Shift_ID Deleted as corresponding Trips Not Found in BMS.");
                                    }
                                }
                            }
                            // This else would be executed when AVL Data is not Present.
                            else {
                                // Store this [Duty, finalDutyDate, Conductor_ID] in Exceptions Table.
                                //bool error = true;
                                shiftsWithNoAVLData.Add(shiftDetails["Shift_ID"]);
                                log.Error(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + "Data Not Present in AVL.");
                                string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'Data Not Present in AVL')";
                                bool saveException = oracle.saveException(query);
                            }
                        
                        }
                        // Else for shiftCreationResult
                        else {
                            // Shift was Not Created.
                            // Store this [Duty, finalDutyDate, Conductor_ID] in Exceptions Table.
                            log.Error(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + "Shift Could not be Created.");
                            string message = "Duty=" + Duty[dutySeq] + " Duty_Date=" + finalDutyDate + " Conductor_ID=" + Conductor_ID;
                            shiftsNotCreated.Add(message);

                            string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'Shift Could not be Created')";
                            bool saveException = oracle.saveException(query);
                        }
                    }
                    // Else for dutyReceivedFromBMS
                    else {
                        // BMS Does not have data for queried Duty.
                        // Store this [Duty, finalDutyDate, Conductor_ID] in Exceptions Table.
                        log.Error(finalDutyDate + "," + Duty[dutySeq] + "," + Conductor_ID + "BMS Does not have data for this duty.");
                        string query = "INSERT INTO RECON_EXCEPTIONS (DUTY_DATE,DUTY_NAME,CONDUCTOR_ID,EXCEPTION_DATE,REMARKS) VALUES ('" + finalDutyDate + "','" + Duty[dutySeq] + "','" + Conductor_ID + "',sysdate,'BMS Does not have data for this duty')";
                        bool saveException = oracle.saveException(query);
                    }
                    // For testing
                    //break
            } // End of for loop in case of multiple Duties passed separated by (,) in BMS.
            }
            log.Info("========================= SUMMARY OF THIS CYCLE =========================");
            log.Info("Total Number of Missing Records Present : " + missingDuties.Tables[0].Rows.Count);
            log.Info("Total Number of Shifts Created          : " + shiftsCreated.Count.ToString());
            log.Info("Total Number of Shifts With No AVL Data : " + shiftsWithNoAVLData.Count.ToString());
            log.Info("Number of Shifts failed while creation  : " + shiftsNotCreated.Count.ToString());
            log.Info("Number of Shifts Deleted while creation : " + shiftsDeleted.Count.ToString());
            // Shift_ID Insert in Partial Table Result 
            log.Info("Shift_ID Insert in Partial Table Result : " + shiftsInsertResult.Count.ToString());
            log.Info("--------SHIFT_ID--------" + " : " + "-RESULT-");
            foreach (KeyValuePair<string, bool> entry in shiftsInsertResult)
            {
                log.Info((entry.Key).PadRight(26) + " : " + entry.Value);
            }
            if (shiftsWithNoAVLData.Count > 0)
            {
                log.Info("");
                log.Info("Shifts With No AVL Data    : " + shiftsWithNoAVLData.Count.ToString());
                log.Info("--------SHIFT_ID--------");
                foreach (string item in shiftsWithNoAVLData)
                {
                    log.Info(item);
                }
            }
            log.Info("========================= END OF SUMMARY ================================");
            log.Info("Exiting callMethods");
        }
    }
}
