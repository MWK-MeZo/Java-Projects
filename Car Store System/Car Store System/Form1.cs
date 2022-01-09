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
    
    public partial class Form1 : Form
    {
        int login_type_choose = 0;

        public static string username_login = "";

        public Form1()
        {
            InitializeComponent();
        }

        private void roundButton1_Click(object sender, EventArgs e)
        {
            
            try
            {
                SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                SqlDataAdapter sda = new SqlDataAdapter("SELECT Count(*) From login where username='" + username.Text + "'and password ='" + password.Text + "'and user_type = '" + login_type_choose + "'", con);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                if (dt.Rows[0][0].ToString() == "1")
                {
                    if (login_type_choose == 0)
                    {
                        MessageBox.Show("Login Sucessful, Thanks Admin !", "Congratulations", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Hide();
                        Form2 ad = new Form2();
                        ad.Show();
                    }
                    else if(login_type_choose == 1)
                    {
                        MessageBox.Show("Login Sucessful, Thanks Manager !", "Congratulations", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Hide();
                        Form4 mn = new Form4();
                        mn.Show();
                    }
                  
                }
                else
                {
                    MessageBox.Show("please enter the user name and the password correctly ! ", "CHeck Your Data",MessageBoxButtons.OK , MessageBoxIcon.Hand);
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show("Your Data Has An Error ! ","Error",MessageBoxButtons.OKCancel,MessageBoxIcon.Error);
            }
            
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {
        }

        private void admin_CheckedChanged(object sender, EventArgs e)
        {

            if (sender == admin)
                login_type_choose = 0;
        }

        private void manager_CheckedChanged(object sender, EventArgs e)
        {
             if (sender == manager)
                login_type_choose = 1;
        }

    
        private void username_TextChanged(object sender, EventArgs e)
        {
            username_login = username.Text.ToString();   
        }
    }
}
