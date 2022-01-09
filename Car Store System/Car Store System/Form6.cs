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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void roundButton2_Click(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                /////////////////////////
                string insert_query0 = "UPDATE supllier SET name='" + name.Text + "' ,phone='" + phone.Text + "' ,address ='" + address.Text + "' WHERE e_mail='" + e_mail.Text + "' ";
                SqlCommand sc2 = new SqlCommand(insert_query0, conn);
                sc2.ExecuteNonQuery();

                ///////////////////
                int ok = sc2.ExecuteNonQuery();
                if (ok >= 1)
                {
                    MessageBox.Show("Update Sucessful, Thanks !", "Congratulations", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                else
                {
                    MessageBox.Show("please enter the user name and the password correctly ! ", "Check Your Data", MessageBoxButtons.OK, MessageBoxIcon.Hand);
                }
                conn.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
        }
    }
}
