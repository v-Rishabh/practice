using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ReconService.Interface;
using log4net;
using ReconService.DBConnectionFactory;

namespace ReconService.Classes
{
    class SaveShiftRecord : ISaveShiftRecord
    {
        ILog log = LogManager.GetLogger(typeof(SaveShiftRecord));
        OracleConnection_Class oracle = new OracleConnection_Class();

        /// <summary>
        /// Saves the Shift record to Partial Closer table.
        /// </summary>
        /// <param name="shiftRecordsList"></param>
        /// <returns>Result of saving[True or False]</returns>
        public bool saveTripRecord(Dictionary<string,string> shiftRecordsList) {
            log.Info("In saveShiftRecord");
            bool isSavedSuccessfully = false;

            string vQry = "INSERT INTO PARTIAL_SHIFT_CLOSER(SHIFT_ID,MESSAGE_ID,DEPOT_ID,SHIFT_START_TIME,ETM_UID,CONDUCTOR_ID,DRIVER_ID,BUS_ID,SUBMITTER_ID,SUBMIT_DATE,IS_APPROVED,REMARKS,REASON,WAYBILL_NO)" +
                                      " values('" + shiftRecordsList["Shift_ID"] + "','" + shiftRecordsList["Message_ID"] + "','" + shiftRecordsList["Depot_ID"] + "',To_Date('" + Convert.ToDateTime(shiftRecordsList["Shift_Start_Time"]).ToString("dd/MM/yyyy hh:mm:ss tt") + "','dd/MM/yyyy HH:MI:SS AM')" + ",'" + shiftRecordsList["ETM_UID"] + "','" +
                                        shiftRecordsList["Conductor_Id"] + "','" + shiftRecordsList["Driver_ID"] + "','" + shiftRecordsList["Bus_Id"] + "','" + shiftRecordsList["Submitter_ID"] + "',sysdate,'0','" + shiftRecordsList["Remarks"] + "','" + shiftRecordsList["Reason"] + "','" + shiftRecordsList["waybill_no"] + "')";

            isSavedSuccessfully = oracle.saveRecord(vQry);

            if (isSavedSuccessfully)
            {
                log.Info("Shift Created, Shift_Id =" + shiftRecordsList["Shift_ID"] + " Conductor_ID =" + shiftRecordsList["Conductor_Id"] + " Duty_Date =" + shiftRecordsList["Shift_Start_Time"]);
            }
            else {
                log.Error("ERROR: Failed to Save Shift in Partial Table, Shift_Id =" + shiftRecordsList["Shift_ID"] + " Conductor_ID =" + shiftRecordsList["Conductor_Id"] + " Duty_Date =" + shiftRecordsList["Shift_Start_Time"]);
            }

            log.Info("Exiting saveShiftRecord");
            return isSavedSuccessfully;
        }
    }
}
