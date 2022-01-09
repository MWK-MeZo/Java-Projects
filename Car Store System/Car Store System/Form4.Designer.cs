namespace Car_Store_System
{
    partial class Form4
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

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form4));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.optionsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.addToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.carToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.carModelToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.customerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saleBillToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.mySettingToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.leaveTheSystemToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.logOutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.select_table = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.newPrandToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.roundButton2 = new Car_Store_System.RoundButton();
            this.roundButton1 = new Car_Store_System.RoundButton();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.Color.Transparent;
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.optionsToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(875, 30);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            this.menuStrip1.ItemClicked += new System.Windows.Forms.ToolStripItemClickedEventHandler(this.menuStrip1_ItemClicked);
            // 
            // optionsToolStripMenuItem
            // 
            this.optionsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.addToolStripMenuItem,
            this.saleBillToolStripMenuItem,
            this.mySettingToolStripMenuItem,
            this.leaveTheSystemToolStripMenuItem,
            this.logOutToolStripMenuItem});
            this.optionsToolStripMenuItem.Font = new System.Drawing.Font("Monotype Corsiva", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.optionsToolStripMenuItem.ForeColor = System.Drawing.SystemColors.ScrollBar;
            this.optionsToolStripMenuItem.Name = "optionsToolStripMenuItem";
            this.optionsToolStripMenuItem.Size = new System.Drawing.Size(75, 26);
            this.optionsToolStripMenuItem.Text = "Options";
            // 
            // addToolStripMenuItem
            // 
            this.addToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.carToolStripMenuItem,
            this.newPrandToolStripMenuItem,
            this.carModelToolStripMenuItem,
            this.customerToolStripMenuItem});
            this.addToolStripMenuItem.Name = "addToolStripMenuItem";
            this.addToolStripMenuItem.Size = new System.Drawing.Size(202, 26);
            this.addToolStripMenuItem.Text = "Add ";
            // 
            // carToolStripMenuItem
            // 
            this.carToolStripMenuItem.Name = "carToolStripMenuItem";
            this.carToolStripMenuItem.Size = new System.Drawing.Size(158, 26);
            this.carToolStripMenuItem.Text = "Car";
            this.carToolStripMenuItem.Click += new System.EventHandler(this.carToolStripMenuItem_Click);
            // 
            // carModelToolStripMenuItem
            // 
            this.carModelToolStripMenuItem.Name = "carModelToolStripMenuItem";
            this.carModelToolStripMenuItem.Size = new System.Drawing.Size(158, 26);
            this.carModelToolStripMenuItem.Text = "Car Model";
            this.carModelToolStripMenuItem.Click += new System.EventHandler(this.carModelToolStripMenuItem_Click);
            // 
            // customerToolStripMenuItem
            // 
            this.customerToolStripMenuItem.Name = "customerToolStripMenuItem";
            this.customerToolStripMenuItem.Size = new System.Drawing.Size(158, 26);
            this.customerToolStripMenuItem.Text = "Customer";
            this.customerToolStripMenuItem.Click += new System.EventHandler(this.customerToolStripMenuItem_Click);
            // 
            // saleBillToolStripMenuItem
            // 
            this.saleBillToolStripMenuItem.Name = "saleBillToolStripMenuItem";
            this.saleBillToolStripMenuItem.Size = new System.Drawing.Size(202, 26);
            this.saleBillToolStripMenuItem.Text = "Sale Bill";
            this.saleBillToolStripMenuItem.Click += new System.EventHandler(this.saleBillToolStripMenuItem_Click);
            // 
            // mySettingToolStripMenuItem
            // 
            this.mySettingToolStripMenuItem.Name = "mySettingToolStripMenuItem";
            this.mySettingToolStripMenuItem.Size = new System.Drawing.Size(202, 26);
            this.mySettingToolStripMenuItem.Text = "My Setting";
            this.mySettingToolStripMenuItem.Click += new System.EventHandler(this.mySettingToolStripMenuItem_Click);
            // 
            // leaveTheSystemToolStripMenuItem
            // 
            this.leaveTheSystemToolStripMenuItem.Name = "leaveTheSystemToolStripMenuItem";
            this.leaveTheSystemToolStripMenuItem.Size = new System.Drawing.Size(202, 26);
            this.leaveTheSystemToolStripMenuItem.Text = "Leave the System ";
            this.leaveTheSystemToolStripMenuItem.Click += new System.EventHandler(this.leaveTheSystemToolStripMenuItem_Click);
            // 
            // logOutToolStripMenuItem
            // 
            this.logOutToolStripMenuItem.Name = "logOutToolStripMenuItem";
            this.logOutToolStripMenuItem.Size = new System.Drawing.Size(202, 26);
            this.logOutToolStripMenuItem.Text = "Log Out";
            this.logOutToolStripMenuItem.Click += new System.EventHandler(this.logOutToolStripMenuItem_Click);
            // 
            // select_table
            // 
            this.select_table.AutoCompleteCustomSource.AddRange(new string[] {
            "All Cars",
            "Store Cars",
            "Garages Cars",
            "Customers",
            "Garages"});
            this.select_table.FormattingEnabled = true;
            this.select_table.Items.AddRange(new object[] {
            "All Cars",
            "Garages",
            "Car Models",
            "Store Cars",
            "Garage cars",
            "Customers"});
            this.select_table.Location = new System.Drawing.Point(369, 81);
            this.select_table.Name = "select_table";
            this.select_table.Size = new System.Drawing.Size(243, 21);
            this.select_table.TabIndex = 5;
            this.select_table.SelectedIndexChanged += new System.EventHandler(this.select_table_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Monotype Corsiva", 14.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.Window;
            this.label1.Location = new System.Drawing.Point(226, 77);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(125, 22);
            this.label1.TabIndex = 6;
            this.label1.Text = "Show Items of ";
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.GridColor = System.Drawing.SystemColors.Window;
            this.dataGridView1.Location = new System.Drawing.Point(204, 131);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(517, 241);
            this.dataGridView1.TabIndex = 7;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // newPrandToolStripMenuItem
            // 
            this.newPrandToolStripMenuItem.Name = "newPrandToolStripMenuItem";
            this.newPrandToolStripMenuItem.Size = new System.Drawing.Size(158, 26);
            this.newPrandToolStripMenuItem.Text = "New Prand";
            this.newPrandToolStripMenuItem.Click += new System.EventHandler(this.newPrandToolStripMenuItem_Click);
            // 
            // roundButton2
            // 
            this.roundButton2.BackColor = System.Drawing.Color.Transparent;
            this.roundButton2.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.roundButton2.Font = new System.Drawing.Font("Monotype Corsiva", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.roundButton2.ForeColor = System.Drawing.Color.Black;
            this.roundButton2.Location = new System.Drawing.Point(504, 404);
            this.roundButton2.Name = "roundButton2";
            this.roundButton2.Size = new System.Drawing.Size(130, 38);
            this.roundButton2.TabIndex = 8;
            this.roundButton2.Text = "Show Data";
            this.roundButton2.UseVisualStyleBackColor = false;
            this.roundButton2.Click += new System.EventHandler(this.roundButton2_Click);
            // 
            // roundButton1
            // 
            this.roundButton1.BackColor = System.Drawing.Color.Transparent;
            this.roundButton1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.roundButton1.Font = new System.Drawing.Font("Monotype Corsiva", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.roundButton1.ForeColor = System.Drawing.Color.Black;
            this.roundButton1.Location = new System.Drawing.Point(264, 404);
            this.roundButton1.Name = "roundButton1";
            this.roundButton1.Size = new System.Drawing.Size(130, 38);
            this.roundButton1.TabIndex = 4;
            this.roundButton1.Text = "Print";
            this.roundButton1.UseVisualStyleBackColor = false;
            this.roundButton1.Click += new System.EventHandler(this.roundButton1_Click);
            // 
            // Form4
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(875, 458);
            this.Controls.Add(this.roundButton2);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.select_table);
            this.Controls.Add(this.roundButton1);
            this.Controls.Add(this.menuStrip1);
            this.Cursor = System.Windows.Forms.Cursors.PanNW;
            this.Font = new System.Drawing.Font("Monotype Corsiva", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form4";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Manager";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form4_FormClosing);
            this.Load += new System.EventHandler(this.Form4_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem optionsToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem addToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem carToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem carModelToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem mySettingToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem logOutToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem customerToolStripMenuItem;
        private System.Windows.Forms.ComboBox select_table;
        private System.Windows.Forms.Label label1;
        private RoundButton roundButton1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private RoundButton roundButton2;
        private System.Windows.Forms.ToolStripMenuItem saleBillToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem leaveTheSystemToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newPrandToolStripMenuItem;
    }
}