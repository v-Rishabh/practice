using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ReconService.Interface;
using log4net;
using System.Data;
using ReconService.DBConnectionFactory;

namespace ReconService.Classes
{
    class SaveTripRecord : ISaveTripRecord
    {
        ILog log = LogManager.GetLogger(typeof(SaveTripRecord));
        OracleConnection_Class oracle = new OracleConnection_Class();

        /// <summary>
        /// Saves the Trip record to Partial Closer table.
        /// </summary>
        /// <param name="shiftRecordsList"></param>
        /// <returns>Result of saving[True or False]</returns>
        public bool saveTripRecord(DataSet Trips)
        {
            log.Info("In saveTripRecord");
            bool isSavedSuccessfully = false;
            List<bool> tripSavingResult = new List<bool>();
            for (int i = 0; i < Trips.Tables[0].Rows.Count; i++)
            {
                string vQry = "INSERT INTO PARTIAL_CLOSURE_HISTORY(DEPOT_ID,TRIP_ID,SHIFT_ID,ETM_SR_NO,DUTY_ID,TRIP_START_TIME,TRIP_END_TIME,DATE_OF_DUTY,SUM_TDR_TRIP,COUNT_TDR_TRIP,WAYBILL_TDR_CASH,WAYBILL_TDR_COUNT,DATE_OF_SUBMISSION,CONFIRMATION_FLAG,FLAG,SUBMITTER_ID,ROUTENAME,ROUTETYPE,SERVICETYPE,ORG_STOP_ID,DEST_STOP_ID,TRIP_CLOSE_FLAG,REASON,REMARKS)" +
                                                    " values('" + Trips.Tables[0].Rows[i]["DEPOT_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["TRIP_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["SHIFT_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["ETM_SR_NO"].ToString() + "','" + Trips.Tables[0].Rows[i]["DUTY_ID"].ToString() + "',To_Date('" + Convert.ToDateTime(Trips.Tables[0].Rows[i]["TRIP_START_TIME"].ToString()).ToString("dd/MM/yyyy hh:mm:ss tt") + "','dd/MM/yyyy HH:MI:SS AM')"
                                                    + ",To_Date('" + Convert.ToDateTime(Trips.Tables[0].Rows[i]["TRIP_END_TIME"].ToString()).ToString("dd/MM/yyyy hh:mm:ss tt") + "','dd/MM/yyyy HH:MI:SS AM')" + ",To_Date('" + Convert.ToDateTime(Trips.Tables[0].Rows[i]["DATE_OF_DUTY"].ToString()).ToString("dd/MM/yyyy") + "','dd/MM/yyyy')" + " ,'" + Trips.Tables[0].Rows[i]["SUM_TDR_TRIP"].ToString()
                                                    + "','" + Trips.Tables[0].Rows[i]["COUNT_TDR_TRIP"].ToString() + "','" + Trips.Tables[0].Rows[i]["WAYBILL_TDR_CASH"].ToString() + "','" + Trips.Tables[0].Rows[i]["WAYBILL_TDR_COUNT"].ToString() + "',sysdate,'0','C','" + Trips.Tables[0].Rows[i]["SUBMITTER_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["ROUTENAME"].ToString() + "','" + Trips.Tables[0].Rows[i]["ROUTETYPE"].ToString() + "','1','" + Trips.Tables[0].Rows[i]["ORG_STOP_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["DEST_STOP_ID"].ToString() + "','Y','" + Trips.Tables[0].Rows[i]["REASON"].ToString() + "','" + Trips.Tables[0].Rows[i]["REMARKS"].ToString() + "')";
                isSavedSuccessfully = oracle.saveRecord(vQry);
                tripSavingResult.Add(isSavedSuccessfully);
                if (isSavedSuccessfully)
                {
                    log.Info("Trip Created, Shift_Id =" + Trips.Tables[0].Rows[i]["SHIFT_ID"].ToString() + " Trip_Id =" + Trips.Tables[0].Rows[i]["TRIP_ID"].ToString() + " Duty_Date =" + Trips.Tables[0].Rows[i]["DUTY_ID"].ToString());
                }
                else
                {
                    log.Error("ERROR: Trip Not Created, Shift_Id =" + Trips.Tables[0].Rows[i]["SHIFT_ID"].ToString() + " Trip_Id =" + Trips.Tables[0].Rows[i]["TRIP_ID"].ToString() + " Duty_Date =" + Trips.Tables[0].Rows[i]["DUTY_ID"].ToString());
                }
                isSavedSuccessfully = false;
            }

            log.Info("Exiting saveTripRecord");
            foreach(bool result in tripSavingResult){
                if (result == false) {
                    return false;
                }
            }
            return true;
        }

        /// <summary>
        /// This Tables keepe records with incorrect routename for correction before moving into Partial_closure_history
        /// </summary>
        /// <param name="Trips">Partial Trips whose routename are not correct</param>
        /// <returns></returns>
        public bool savePartialTripRecord(DataSet Trips)
        {
            log.Info("In savePartialTripRecord");
            bool isSavedSuccessfully = false;
            List<bool> tripSavingResult = new List<bool>();
            for (int i = 0; i < Trips.Tables[0].Rows.Count; i++)
            {
                string vQry = "INSERT INTO PARTIAL_AVL_ETM_ROUTEMAP_TRIPS(DEPOT_ID,TRIP_ID,SHIFT_ID,ETM_SR_NO,DUTY_ID,TRIP_START_TIME,TRIP_END_TIME,DATE_OF_DUTY,SUM_TDR_TRIP,COUNT_TDR_TRIP,WAYBILL_TDR_CASH,WAYBILL_TDR_COUNT,DATE_OF_SUBMISSION,CONFIRMATION_FLAG,FLAG,SUBMITTER_ID,ROUTENAME,ROUTETYPE,SERVICETYPE,ORG_STOP_ID,DEST_STOP_ID,TRIP_CLOSE_FLAG,REASON,REMARKS)" +
                                                    " values('" + Trips.Tables[0].Rows[i]["DEPOT_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["TRIP_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["SHIFT_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["ETM_SR_NO"].ToString() + "','" + Trips.Tables[0].Rows[i]["DUTY_ID"].ToString() + "',To_Date('" + Convert.ToDateTime(Trips.Tables[0].Rows[i]["TRIP_START_TIME"].ToString()).ToString("dd/MM/yyyy hh:mm:ss tt") + "','dd/MM/yyyy HH:MI:SS AM')"
                                                    + ",To_Date('" + Convert.ToDateTime(Trips.Tables[0].Rows[i]["TRIP_END_TIME"].ToString()).ToString("dd/MM/yyyy hh:mm:ss tt") + "','dd/MM/yyyy HH:MI:SS AM')" + ",To_Date('" + Convert.ToDateTime(Trips.Tables[0].Rows[i]["DATE_OF_DUTY"].ToString()).ToString("dd/MM/yyyy") + "','dd/MM/yyyy')" + " ,'" + Trips.Tables[0].Rows[i]["SUM_TDR_TRIP"].ToString()
                                                    + "','" + Trips.Tables[0].Rows[i]["COUNT_TDR_TRIP"].ToString() + "','" + Trips.Tables[0].Rows[i]["WAYBILL_TDR_CASH"].ToString() + "','" + Trips.Tables[0].Rows[i]["WAYBILL_TDR_COUNT"].ToString() + "',sysdate,'0','C','" + Trips.Tables[0].Rows[i]["SUBMITTER_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["ROUTENAME"].ToString() + "','" + Trips.Tables[0].Rows[i]["ROUTETYPE"].ToString() + "','1','" + Trips.Tables[0].Rows[i]["ORG_STOP_ID"].ToString() + "','" + Trips.Tables[0].Rows[i]["DEST_STOP_ID"].ToString() + "','Y','" + Trips.Tables[0].Rows[i]["REASON"].ToString() + "','" + Trips.Tables[0].Rows[i]["REMARKS"].ToString() + "')";
                isSavedSuccessfully = oracle.savePartialTrips(vQry);
                tripSavingResult.Add(isSavedSuccessfully);
                if (isSavedSuccessfully)
                {
                    log.Info("Partial Trip Created, Shift_Id =" + Trips.Tables[0].Rows[i]["SHIFT_ID"].ToString() + " Trip_Id =" + Trips.Tables[0].Rows[i]["TRIP_ID"].ToString() + " Duty_Date =" + Trips.Tables[0].Rows[i]["DUTY_ID"].ToString());
                }
                else
                {
                    log.Error("ERROR: Partial Trip Not Created, Shift_Id =" + Trips.Tables[0].Rows[i]["SHIFT_ID"].ToString() + " Trip_Id =" + Trips.Tables[0].Rows[i]["TRIP_ID"].ToString() + " Duty_Date =" + Trips.Tables[0].Rows[i]["DUTY_ID"].ToString());
                }
                isSavedSuccessfully = false;
            }

            log.Info("Exiting savePartialTripRecord");
            foreach (bool result in tripSavingResult)
            {
                if (result == false)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
