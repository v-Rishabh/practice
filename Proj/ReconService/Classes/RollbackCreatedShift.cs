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
    /// <summary>
    /// This class deletes the shift from Partial Shift Closer Table.
    /// </summary>
    class RollbackCreatedShift
    {
        ILog log = LogManager.GetLogger(typeof(RollbackCreatedShift));
        OracleConnection_Class oracle = new OracleConnection_Class();
        UnitTestClass UTC = new UnitTestClass();

        /// <summary>
        /// Deletes the shift from Partial Shift Closer Table.
        /// </summary>
        /// <param name="shiftForDeletion">Shift_ID</param>
        /// <returns>Boolean value (True if Deletes successfully) else False.</returns>
        public bool rollbackShift(string shiftForDeletion) {
            log.Info("In rollbackShift() class");
            // Rollback the Shift from PARTIAL_SHIFT_CLOSER Table.
            string delQuery = "DELETE FROM PARTIAL_SHIFT_CLOSER WHERE SHIFT_ID ='" + shiftForDeletion + "'";
            bool isDeleted = oracle.deleteRecord(delQuery);
            if (isDeleted)
            {
                log.Info("Exiting rollbackShift() class");
                return true;
            }
            log.Info("Exiting rollbackShift() class");
            return false;
        }
    }
}
