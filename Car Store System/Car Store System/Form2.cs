using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Car_Store_System
{
    public partial class Form2 : Form
    {
        DataSet ds = new DataSet();
        

        public Form2()
        {
            InitializeComponent();
        }

        private void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void logOutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void managerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            manager_data md = new manager_data();
            md.Show();
        }

        private void garageToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new_garage ng = new new_garage();
            ng.Show();
        }

        private void removeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            remove rm = new remove();
            rm.Show();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void mySettingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form3 setting = new Form3();
            setting.Show();
        }

        private void backUpDataToolStripMenuItem_Click(object sender, EventArgs e)
        {
         
        }

        private void salesChartToolStripMenuItem_Click(object sender, EventArgs e)
        {
            salles_table st = new salles_table();
            st.Show();
        }

        private void addToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            AddSupllier ads = new AddSupllier();
            ads.Show();
        }

        private void updateToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form6 update = new Form6();
            update.Show();
        }

        private void removeToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            remove_supplier rs = new remove_supplier();
            rs.Show();
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
