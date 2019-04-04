using System;
using System.Collections.Generic;

namespace ReadPDFiTextSharp
{
    class WriteToExcel
    {
        private Dictionary<string, List<string>> data = new Dictionary<string, List<string>>();

        public WriteToExcel(Dictionary<string, List<string>> data) {
            this.data = data;
        }

        public string convertToExcel() {
            string result = string.Empty;
            if (data.Count > 0)
            {
                string conversionResult = _toExcel();
                result = conversionResult;
            }
            else {
                string errorText = "Empty set received.";
                result = errorText;
            }
            return result;
        }
        private string _toExcel() {
            Microsoft.Office.Interop.Excel.Application oXL;
            Microsoft.Office.Interop.Excel._Workbook oWB;
            Microsoft.Office.Interop.Excel._Worksheet oSheet;
            Microsoft.Office.Interop.Excel.Range oRng;
            object misvalue = System.Reflection.Missing.Value;

            try
            {
                //Start Excel and get Application object.
                oXL = new Microsoft.Office.Interop.Excel.Application();
                oXL.Visible = false;

                //Get a new workbook.
                oWB = (Microsoft.Office.Interop.Excel._Workbook)(oXL.Workbooks.Add(""));
                oSheet = (Microsoft.Office.Interop.Excel._Worksheet)oWB.ActiveSheet;

                //Add table headers going cell by cell.
                oSheet.Cells[1, 1] = "Business Day";
                oSheet.Cells[1, 2] = "Aggregation Date";
                oSheet.Cells[1, 3] = "Transaction Type";
                oSheet.Cells[1, 4] = "Number";
                oSheet.Cells[1, 5] = "Amount";

                //Format A1:D1 as bold, vertical alignment = center.
                oSheet.get_Range("A1", "E1").Font.Bold = true;
                oSheet.get_Range("A1", "E1").VerticalAlignment =
                    Microsoft.Office.Interop.Excel.XlVAlign.xlVAlignCenter;

                // Create an array to multiple values at once.
                int RecordCount =  data.Count;
                string[,] cellRecords = new string[RecordCount, 5];
                int i = 0;
                foreach (KeyValuePair<string, List<string>> entry in data)
                {
                    cellRecords[i, 0] = entry.Key;
                    int j = 1;
                    foreach (string value in entry.Value)
                    {
                        cellRecords[i, j] = value;
                        j++;
                    }
                    i++;
                }

                int end = RecordCount + 1;
                string cellRangeStart = "A2";
                string cellEndRange = "E" + end;

                //Fill cellRangeStart:cellEndRange with an array of values (First and Last Names).
                oSheet.get_Range(cellRangeStart, cellEndRange).Value2 = cellRecords;

                ////Fill A2:E_CellEndRange with a formula(=RAND()*100000) and apply format.
                oRng = oSheet.get_Range("E2", cellEndRange);
                //oRng.Formula = "=RAND()*1";
                oRng.NumberFormat = "$0.00";

                //AutoFit columns A:E.
                oRng = oSheet.get_Range("A1", cellEndRange);
                oRng.EntireColumn.AutoFit();

                oXL.Visible = false;
                oXL.UserControl = false;
                oWB.SaveAs("C:\\Users\\rishabh.verma\\Downloads\\PDF_TO_EXCEL_Test.xls", Microsoft.Office.Interop.Excel.XlFileFormat.xlWorkbookDefault, Type.Missing, Type.Missing,
                    false, false, Microsoft.Office.Interop.Excel.XlSaveAsAccessMode.xlNoChange,
                    Type.Missing, Type.Missing, Type.Missing, Type.Missing, Type.Missing);

                oWB.Close();
            }
            catch (Exception ex)
            {
                return  (ex.ToString());
            }

            return "File Written Successfully at location => C:\\Users\\rishabh.verma\\Downloads\\PDF_TO_EXCEL_Test.xls";
        }
    }
}
