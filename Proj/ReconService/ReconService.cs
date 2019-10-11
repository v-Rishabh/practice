using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Linq;
using System.ServiceProcess;
using System.Text;
using log4net;
using System.Timers;

namespace ReconService
{
    public partial class ReconService : ServiceBase
    {
        private Timer timerTenSecond = new Timer(100);
        ILog log = LogManager.GetLogger(typeof(ReconService));
        public ReconService()
        {
            InitializeComponent();
        }

        protected override void OnStart(string[] args)
        {
            log.Info("Started - Recon Service");
            ServiceLibrary.ScheduleService();
        }

        protected override void OnStop()
        {
            ServiceLibrary.Schedular.Dispose();
        }
    }
}
