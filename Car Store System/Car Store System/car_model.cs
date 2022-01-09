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
    public partial class car_model : Form
    {
        public car_model()
        {
            InitializeComponent();
        }

        private void roundButton1_Click(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                string insert_query0 = "insert into car_model values ('" + comboBox1.Text.ToString() + "' ,'" + textBox2.Text.ToString() + "','" + textBox3.Text.ToString() + "','" + comboBox2.Text.ToString() + "')";
                SqlCommand sc = new SqlCommand(insert_query0, conn);
                int ok = sc.ExecuteNonQuery();
                conn.Close();
                MessageBox.Show("Congratulations, Operation Completed Successfully", "Congratulations", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
            }
            catch(Exception ex)
            {
                MessageBox.Show("Oops, Operation didn't Completed Successfully", "Error", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }

        }
    }
}
