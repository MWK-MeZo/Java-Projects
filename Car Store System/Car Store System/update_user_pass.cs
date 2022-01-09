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
    public partial class update_user_pass : Form
    {
        int login_type_choose = -1;
        public update_user_pass()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                //////////////////////////////////////////////////
                SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                SqlDataAdapter sda = new SqlDataAdapter("SELECT Count(*) From login where username='" + username.Text.ToString()+ "'and password ='" + password.Text.ToString()+ "'and user_type = '" + login_type_choose + "'", con);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                if (dt.Rows[0][0].ToString() == "1" || dt.Rows[0][0].ToString() == "0")
                {
                    ///////////////////
                    SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                    conn.Open();
                    string insert_query0 = "UPDATE login SET username='" + new_username.Text+ "' ,password='" + new_password.Text + "' , user_type='"+login_type_choose+"' WHERE username='" + username.Text +"' ";
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
                else
                {
                    MessageBox.Show("please enter the user name and the password correctly ! ", "Check Your Data", MessageBoxButtons.OK, MessageBoxIcon.Hand);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Your Data Has An Error ! ", "Error", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            username.Text = "";
            password.Text = "";
            new_username.Text = "";
            new_password.Text = "";
            
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            if (sender == radioButton1)
                login_type_choose = 0;
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            if (sender == radioButton2)
                login_type_choose = 1;
        }
        
    }
}
