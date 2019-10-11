using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ReconService.Interface;
using log4net;
using System.Data;
using System.Globalization;
using ReconService.DBConnectionFactory;
using System.Collections;
using System.Text.RegularExpressions;

namespace ReconService.Classes
{
    /// <summary>
    /// This Class creates structure which can store Ticket Count and and Trip Sequence Number.
    /// This is used for finding out which Trip has maximum no of tickets and its sequence number.
    /// </summary>
    public class maxTicketNode : IComparer<maxTicketNode>
    {
        public int ticketCount;
        public int tripSequenceNumber;

        public maxTicketNode()
        {
            this.ticketCount = int.MinValue;
            this.tripSequenceNumber = int.MinValue;
        }

        public maxTicketNode(int ticketCount, int tripSequenceNumber)
        {
            this.ticketCount = ticketCount;
            this.tripSequenceNumber = tripSequenceNumber;
        }

        public int Compare(maxTicketNode a, maxTicketNode b)
        {
            if (a.ticketCount > b.ticketCount)
            {
                return 1;
            }
            if (a.ticketCount < b.ticketCount)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }

    class CreateTrips : ICreateTripRecords
    {
        ILog log = LogManager.GetLogger(typeof(CreateTrips));
        bool routeNameException = false;

        public DataSet createTrip(Dictionary<string, string> shiftDetails, DataSet TripData_AVL, DataSet tripDataBMS)
        {
            log.Info("In CreateTrips");
            DataSet Trips = new DataSet();

            GetTripDataTable TripsDT = new GetTripDataTable();
            DataTable dt = TripsDT.TripDataTable();

            // Declaring Variables
            string DUTY_ID = tripDataBMS.Tables[0].Rows[0]["DUTY_NO"].ToString();
            string DEPOT_ID = shiftDetails["Depot_ID"];
            string ETM_SR_NO = shiftDetails["ETM_SR_NO"];
            string DATE_OF_DUTY = string.Empty;
            string TRIP_ID = string.Empty;

            string SUM_TDR_TRIP = string.Empty;
            string COUNT_TDR_TRIP = string.Empty;
            
            string WAYBILL_TDR_CASH = string.Empty;
            string WAYBILL_TDR_COUNT = string.Empty;
            
            string DATE_OF_SUBMISSION = string.Empty;
            
            string CONFIRM_TDR_CASH = string.Empty; // would be populated on confirmation 
            string CONFIRM_TDR_COUNT = string.Empty; // would be populated on confirmation 
            
            string CONFIRMATION_FLAG = "0";
            
            string CONFIRMATION_DATE = string.Empty; // would be populated on confirmation 
            string CONFIRMATION_ID = string.Empty; // would be populated on confirmation 

            string SUBMITTER_ID = "Auto Recon";
            string SHIFT_ID = shiftDetails["Shift_ID"];
            
            string TRIP_END_TIME = string.Empty;
            string TRIP_START_TIME = string.Empty;
            
            string FLAG = "C";
            
            string ROUTETYPE = string.Empty; // From query
            
            string SERVICETYPE = "1";
            
            string ORG_STOP_ID = string.Empty;
            string DEST_STOP_ID = string.Empty;
            string ROUTENAME = string.Empty;
            
            string REASON = "Device got Tempered";
            string REMARKS = "Auto Recon";
            string SUM_TDR_DMRC = "0";
            string COUNT_TDR_DMRC = "0";

            string shiftTotalRevenue = shiftDetails["ETM_REVENUE"];
            string shift_passenger_count = shiftDetails["PASSENGER_COUNT"];

            var ci = new CultureInfo("");
            var formats = new[] { "dd-MM-yyyy"}.Union(ci.DateTimeFormat.GetAllDateTimePatterns()).ToArray();

            // Trip Tickets Sum
            int sumOfTripTickets = 0;

            // Maintaining Trip Seq with Maximum Tickets
            int maxTicketsCount = 0;

            // Global Max Node which holds the TripSeq number and Ticket Count
            maxTicketNode maxNode = new maxTicketNode();

            /* Iterate through Data fetched from BMS and Create required records */
            for(int i=0; i<tripDataBMS.Tables[0].Rows.Count; i++){
                
                DataRow dr = dt.NewRow();

                //Step 1: Create Trip_ID 
                TRIP_ID = "T";
                string totalTripCount = tripDataBMS.Tables[0].Rows.Count.ToString();
                string tripSeq = tripDataBMS.Tables[0].Rows[i]["SequenceofTrip"].ToString();
                string seqNo = "";
                if (totalTripCount.Length == 1)
                {
                    //seqNo = "0" + tripSeq;
                    seqNo = "0" + (i+1).ToString();
                }
                else
                {
                    //seqNo = tripSeq;
                    seqNo = (i + 1).ToString();
                }

                string ETM_UID = shiftDetails["ETM_UID"];

                string[] dutyAllocationDateBMS = tripDataBMS.Tables[0].Rows[i]["DUTY_ALLOCATION_DATE"].ToString().Split(' ');
                DateTime dutyAllocationDate = DateTime.ParseExact(dutyAllocationDateBMS[0], formats, ci, DateTimeStyles.AssumeLocal);
                string finalDutyDate = dutyAllocationDate.ToString("dd-MM-yy", CultureInfo.InvariantCulture);
                                
                string[] tripStartTimeBMS = tripDataBMS.Tables[0].Rows[i]["TRIP_START_TIME"].ToString().Split(' ');
                string finalDutyTime = tripStartTimeBMS[1];

                string tripDateTime = finalDutyDate.Replace("-","") + finalDutyTime.Replace(":","").Substring(0,4);

                TRIP_ID = TRIP_ID + ETM_UID + tripDateTime + seqNo;


                // Step 2: Create DATE_OF_DUTY
                DATE_OF_DUTY = dutyAllocationDate.ToString("dd-MMM-yy", CultureInfo.InvariantCulture);
                DATE_OF_DUTY = DATE_OF_DUTY + " " + finalDutyTime;

                // Step 3: SUM_TDR_TRIP
                SUM_TDR_TRIP = tripDataBMS.Tables[0].Rows[i]["ETM_REVENUE"].ToString();

                // Step 4: Calculate Ticket Count [COUNT_TDR_TRIP]
                
                /* Start of Number of Tickets Calculation for Trip in Iteration */
                
                // Current Trip Revenue
                double etmTripRevenue = double.Parse(SUM_TDR_TRIP);
                // Shift Total Revenue
                double etmShiftRevenue = double.Parse(shiftTotalRevenue);
                // Total number of tickets in Shift
                double shiftPassengerCount = double.Parse(shift_passenger_count);
                // Percentage of Trip revenue with Shift revenue
                double percentageTripRevenueWithShift = ((etmTripRevenue / etmShiftRevenue) * 100);
                // Number of tickets as per percentage of Trip Revenue with Shift
                double numberOfTicketsByPercentage = (percentageTripRevenueWithShift * shiftPassengerCount)/100;
                // Get the floor value of Ticket Count
                int tripTicketCount = (int)Math.Floor(numberOfTicketsByPercentage);
                // Counting sum of tickets.
                sumOfTripTickets += tripTicketCount;

                int tripSeqInt = int.Parse(seqNo);
                // keeps the Global max ticket count.
                maxTicketsCount = Math.Max(maxTicketsCount, tripTicketCount);
                // Keep the ticket count and trip seq for current iteration
                maxTicketNode tempNode = new maxTicketNode(tripTicketCount, tripSeqInt);
                // Update COUNT_TDR_TRIP
                COUNT_TDR_TRIP = tempNode.ticketCount.ToString();
                
                // Compare Object to get maximum
                int res = tempNode.Compare(tempNode,maxNode);
                // If there is a new Max then update the global Max node.
                if (res == 1) {
                    maxNode = tempNode;
                }
                
                /* End of Number of Tickets Calculation for Trip in Iteration */

                // Step 5: WAYBILL_TDR_CASH
                WAYBILL_TDR_CASH = SUM_TDR_TRIP;

                // Step 6: WAYBILL_TDR_COUNT
                WAYBILL_TDR_COUNT = COUNT_TDR_TRIP;

                // Step 7: Get TRIP_END_TIME
                TRIP_START_TIME = DATE_OF_DUTY;

                // Step 8: Get TRIP_END_TIME
                string[] tripDate = DATE_OF_DUTY.Split(' ');
                string[] tripEndTimeTemp = tripDataBMS.Tables[0].Rows[i]["TRIP_END_TIME"].ToString().Split(' ');
                TRIP_END_TIME = tripDate[0] + " " + tripEndTimeTemp[1];

                // Step 9: Get ROUTETYPE
                string route_ID = string.Empty;
                string[] route_ID_Temp = tripDataBMS.Tables[0].Rows[i]["DUTY_NO"].ToString().Split('/');
                string completeRoute = route_ID_Temp[0];
                Regex regex = new Regex("[A-Z].{0}");
                completeRoute = regex.Replace(completeRoute, "");
                if (completeRoute[completeRoute.Length - 1].Equals('A'))
                {
                    route_ID = completeRoute.Substring(0, completeRoute.Length - 2);
                }
                else {
                    route_ID = completeRoute;
                }
                OracleConnection_Class con = new OracleConnection_Class();
                ROUTETYPE = con.getRouteType(route_ID);

                if (TripData_AVL.Tables[0].Rows.Count > 0)
                {
                    GetRouteDetails GRD = new GetRouteDetails();
                    Dictionary<string, string> result = new Dictionary<string, string>();
                    DateTime dutyDate = dutyAllocationDate;
                    result = GRD.getRouteData(SHIFT_ID, dutyDate, tripSeq);

                    //DataSet origin_destination_ID = new DataSet();
                    //string origin_dest_ID_query = "SELECT ROUTENAME,ORIGIN,DESTINATION,DIRECTION FROM ETM.ROUTE_MASTER WHERE ROUTENAME = '" + TripData_AVL.Tables[0].Rows[i]["Route_Name"].ToString().Trim()+ "'";
                    //origin_destination_ID = con.SelectRecordsETMDB(origin_dest_ID_query);

                    if (result["RESULT"].Equals("TRUE"))
                    {
                        // Step 10: ROUTENAME
                        ROUTENAME = result["ROUTENAME"].ToString();

                        // Step 11: ORG_STOP_ID
                        ORG_STOP_ID = result["ORIGIN"].ToString();

                        // Step 12: DEST_STOP_ID
                        DEST_STOP_ID = result["DESTINATION"].ToString();
                    }
                    // When ETM Db does not have data for routename passed from AVL.
                    else {

                        // Check in the table AVL_ETM_ROUTEMAP
                        /*DataSet RouteNameFromAVL_ETM_Map = new DataSet();
                        string getRouteNameFromMap = "SELECT ETM_ROUTENAME FROM AVL_ETM_ROUTEMAP where AVL_ROUTENAME='" + TripData_AVL.Tables[0].Rows[i]["Route_Name"].ToString().ToUpper().Trim() + "'";
                        RouteNameFromAVL_ETM_Map = con.SelectRecordsOleDb(getRouteNameFromMap);
                        
                        // Routename found in Map
                        if (RouteNameFromAVL_ETM_Map.Tables[0].Rows.Count > 0)
                        {
                            ROUTENAME = RouteNameFromAVL_ETM_Map.Tables[0].Rows[0]["ETM_ROUTENAME"].ToString();

                            // Get Dest and Origin ID and Fill
                            DataSet OD_ID = new DataSet();
                            string OD_ID_Query = "SELECT ROUTENAME,ORIGIN,DESTINATION,DIRECTION FROM ETM.ROUTE_MASTER WHERE ROUTENAME = '" + ROUTENAME + "'";
                            OD_ID = con.SelectRecordsETMDB(OD_ID_Query);

                            ORG_STOP_ID = OD_ID.Tables[0].Rows[0]["ORIGIN"].ToString();

                            DEST_STOP_ID = OD_ID.Tables[0].Rows[0]["DESTINATION"].ToString();

                        }
                        // RouteName not found in Map
                        else {
                            routeNameException = true;
                            // Add this Trip data in Partial Exceptions
                            ROUTENAME = TripData_AVL.Tables[0].Rows[i]["Route_Name"].ToString();
                            ORG_STOP_ID = TripData_AVL.Tables[0].Rows[i]["Origin_Stop_ID"].ToString(); ;
                            DEST_STOP_ID = TripData_AVL.Tables[0].Rows[i]["Dest_Stop_ID"].ToString();
                        }*/
                    }
                }
                else { 
                    // add to exception.
                }
                
                // Step 13: Insert into DataSet for returning trip records.
                dr["DUTY_ID"] = DUTY_ID;
                dr["DEPOT_ID"] = DEPOT_ID;
                dr["ETM_SR_NO"] = ETM_SR_NO;
                dr["DATE_OF_DUTY"] = DATE_OF_DUTY;
                dr["TRIP_ID"] = TRIP_ID;
                dr["SUM_TDR_TRIP"] = SUM_TDR_TRIP;
                dr["COUNT_TDR_TRIP"] = COUNT_TDR_TRIP;
                dr["WAYBILL_TDR_CASH"] = WAYBILL_TDR_CASH;
                dr["WAYBILL_TDR_COUNT"] = WAYBILL_TDR_COUNT;
                dr["DATE_OF_SUBMISSION"] = DATE_OF_SUBMISSION;
                dr["CONFIRM_TDR_CASH"] = CONFIRM_TDR_CASH;
                dr["CONFIRM_TDR_COUNT"] = CONFIRM_TDR_COUNT;
                dr["CONFIRMATION_FLAG"] = CONFIRMATION_FLAG;
                dr["CONFIRMATION_DATE"] = CONFIRMATION_DATE;
                dr["CONFIRMATION_ID"] = CONFIRMATION_ID;
                dr["SUBMITTER_ID"] = SUBMITTER_ID;
                dr["SHIFT_ID"] = SHIFT_ID;
                dr["TRIP_END_TIME"] = TRIP_END_TIME;
                dr["TRIP_START_TIME"] = TRIP_START_TIME;
                dr["FLAG"] = FLAG;
                dr["ROUTETYPE"] = ROUTETYPE;
                dr["SERVICETYPE"] = SERVICETYPE;
                dr["ORG_STOP_ID"] = ORG_STOP_ID;
                dr["DEST_STOP_ID"] = DEST_STOP_ID;
                dr["ROUTENAME"] = ROUTENAME; 
                dr["REASON"] = REASON;
                dr["REMARKS"] = REMARKS;
                dr["SUM_TDR_DMRC"] = SUM_TDR_DMRC;
                dr["COUNT_TDR_DMRC"] = COUNT_TDR_DMRC;

                dt.Rows.Add(dr);
                

            } // For loop ends

            Trips.Tables.Add(dt);

            // Step 14: Update the ticket Count in DataSet if any difference is found with total number of tickets in Sum of all trips tickets.
            int shiftTicketCount = int.Parse(shift_passenger_count);
            int diff = 0;
            if (shiftTicketCount > sumOfTripTickets) // This should be true everytime.
            {
                diff = shiftTicketCount - sumOfTripTickets;
                // update the difference in number of tickets to the trip with maximum tickets.
                int tripWithMaxTicket = maxNode.tripSequenceNumber;
                Trips.Tables[0].Rows[tripWithMaxTicket - 1]["COUNT_TDR_TRIP"] = (maxNode.ticketCount + diff).ToString();
                Trips.Tables[0].Rows[tripWithMaxTicket - 1]["WAYBILL_TDR_COUNT"] = Trips.Tables[0].Rows[tripWithMaxTicket - 1]["COUNT_TDR_TRIP"].ToString();
            }

            log.Info("Exiting CreateTrips");

            if (!routeNameException)
            {
                return Trips;
            }
            else {
                //ISaveTripRecord saveTripsWithAVLRoute = new SaveTripRecord();
                //bool saved = saveTripsWithAVLRoute.savePartialTripRecord(Trips);
                //if (!saved) {
                //    RollbackCreatedShift rollback = new RollbackCreatedShift();
                //    rollback.rollbackShift(SHIFT_ID);
                //}

                RollbackCreatedShift rollback = new RollbackCreatedShift();
                rollback.rollbackShift(SHIFT_ID);

                DataSet empty = new DataSet();
                DataTable dt_Empty  = TripsDT.TripDataTable();
                empty.Tables.Add(dt_Empty);

                return empty;
            }
            
        }
    }
}
