using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceProcess;
using System.Text;
using System.Configuration.Install;
using System.Reflection;
using ReconService.Interface;
using ReconService.Classes;
using ReconService.DBConnectionFactory;
using System.Data;

namespace ReconService
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        static void Main(string[] args)
        {
            /* Running as a Windows Service */
            //if (Environment.UserInteractive)
            //{
            //    string parameter = string.Concat(args);
            //    switch (parameter)
            //    {
            //        case "--install":
            //            ManagedInstallerClass.InstallHelper(new[] { Assembly.GetExecutingAssembly().Location });
            //            break;
            //        case "--uninstall":
            //            ManagedInstallerClass.InstallHelper(new[] { "/u", Assembly.GetExecutingAssembly().Location });
            //            break;
            //    }
            //}
            //else
            //{
            //    ServiceBase[] ServicesToRun;
            //    ServicesToRun = new ServiceBase[] 
            //    { 
            //        new ReconService() 
            //    };
            //    ServiceBase.Run(ServicesToRun);
            //}

            /* Debugging as a Console Application */
            Console.WriteLine("Started");
            int test = ServiceLibrary.returnSomething();
            Console.WriteLine(test);

            ///* Call Methods from Driver Class */
            DriverClass dc = new DriverClass();
            dc.callMethods();

            //GetRouteDetails GRD = new GetRouteDetails();
            //Dictionary<string, string> result = new Dictionary<string, string>();
            //DateTime dutyDate = DateTime.ParseExact("29-May-19", "dd-MMM-yy", null);
            //result = GRD.getRouteData("418A23A10066210519143801", dutyDate, "1");

            //Oracle Connection Test
            //OracleConnection_Class conn = new OracleConnection_Class();
            //DataSet rs = new DataSet();
            //rs = conn.SelectRecordsOleDb("Select * from ETM_DATA_REPORT WHERE BMS_TOTAL_REVENUE = '4303'");
            
            //SQL Connection Test
            //SQLConnection_Class sql = new SQLConnection_Class();
            //DataSet res = sql.procETM_Recon();

            Console.ReadLine();
        }
    }
}
