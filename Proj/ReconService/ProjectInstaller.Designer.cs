namespace ReconService
{
    partial class ProjectInstaller
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.reconServiceProcessInstaller = new System.ServiceProcess.ServiceProcessInstaller();
            this.ReconService = new System.ServiceProcess.ServiceInstaller();
            // 
            // reconServiceProcessInstaller
            // 
            this.reconServiceProcessInstaller.Account = System.ServiceProcess.ServiceAccount.LocalService;
            this.reconServiceProcessInstaller.Password = null;
            this.reconServiceProcessInstaller.Username = null;
            // 
            // ReconService
            // 
            this.ReconService.ServiceName = "ReconService";
            // 
            // ProjectInstaller
            // 
            this.Installers.AddRange(new System.Configuration.Install.Installer[] {
            this.reconServiceProcessInstaller,
            this.ReconService});

        }

        #endregion

        private System.ServiceProcess.ServiceProcessInstaller reconServiceProcessInstaller;
        private System.ServiceProcess.ServiceInstaller ReconService;
    }
}