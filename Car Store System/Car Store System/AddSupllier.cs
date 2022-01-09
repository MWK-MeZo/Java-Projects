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
    public partial class AddSupllier : Form
    {
        public AddSupllier()
        {
            InitializeComponent();
        }

        private void AddSupllier_Load(object sender, EventArgs e)
        {
           
        }

        private void roundButton2_Click(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                /////////////////////////

                string insert_query0 = "insert into supllier values ('" + name.Text.ToString() + "' ,'" + phone.Text.ToString() + "','" + address.Text.ToString() + "','" + e_mail.Text.ToString() + "')";
                SqlCommand sc = new SqlCommand(insert_query0, conn);
                int ok = sc.ExecuteNonQuery();
                conn.Close();
                if (ok >= 1)
                    MessageBox.Show("Congratulations, Operation Completed Successfully", "Congratulations", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
                else
                    MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
        }
    }
}
