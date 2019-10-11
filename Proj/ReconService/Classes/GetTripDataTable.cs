using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace ReconService.Classes
{
    class GetTripDataTable
    {
        public DataTable TripDataTable() {
            DataTable Trips = new DataTable("TRIP_RECORDS");
            Trips.Columns.Add(new DataColumn("DUTY_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("DEPOT_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("ETM_SR_NO", typeof(string)));
            Trips.Columns.Add(new DataColumn("DATE_OF_DUTY", typeof(string)));
            Trips.Columns.Add(new DataColumn("TRIP_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("SUM_TDR_TRIP", typeof(string)));
            Trips.Columns.Add(new DataColumn("COUNT_TDR_TRIP", typeof(string)));
            Trips.Columns.Add(new DataColumn("WAYBILL_TDR_CASH", typeof(string)));
            Trips.Columns.Add(new DataColumn("WAYBILL_TDR_COUNT", typeof(string)));
            Trips.Columns.Add(new DataColumn("DATE_OF_SUBMISSION", typeof(string)));
            Trips.Columns.Add(new DataColumn("CONFIRM_TDR_CASH", typeof(string)));
            Trips.Columns.Add(new DataColumn("CONFIRM_TDR_COUNT", typeof(string)));
            Trips.Columns.Add(new DataColumn("CONFIRMATION_FLAG", typeof(string)));
            Trips.Columns.Add(new DataColumn("CONFIRMATION_DATE", typeof(string)));
            Trips.Columns.Add(new DataColumn("CONFIRMATION_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("SUBMITTER_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("SHIFT_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("TRIP_END_TIME", typeof(string)));
            Trips.Columns.Add(new DataColumn("TRIP_START_TIME", typeof(string)));
            Trips.Columns.Add(new DataColumn("FLAG", typeof(string)));
            Trips.Columns.Add(new DataColumn("ROUTETYPE", typeof(string)));
            Trips.Columns.Add(new DataColumn("SERVICETYPE", typeof(string)));
            Trips.Columns.Add(new DataColumn("ORG_STOP_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("DEST_STOP_ID", typeof(string)));
            Trips.Columns.Add(new DataColumn("ROUTENAME", typeof(string)));
            Trips.Columns.Add(new DataColumn("REASON", typeof(string)));
            Trips.Columns.Add(new DataColumn("REMARKS", typeof(string)));
            Trips.Columns.Add(new DataColumn("SUM_TDR_DMRC", typeof(string)));
            Trips.Columns.Add(new DataColumn("COUNT_TDR_DMRC", typeof(string)));
            return Trips;
        }
    }
}
