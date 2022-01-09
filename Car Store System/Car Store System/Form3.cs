using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Car_Store_System
{
    public partial class Form3 : Form
    {
        string admin_image, admin_id_image, store_logo;
        public Form3()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void roundButton2_Click(object sender, EventArgs e)
        {
            show sh = new show(1);
            sh.Show();
        }

        private void roundButton3_Click(object sender, EventArgs e)
        {
            show sh = new show(2);
            sh.Show();
        }
        
        private void label9_Click(object sender, EventArgs e)
        {

        }
        

        private void roundButton5_Click(object sender, EventArgs e)
        {
            show sh = new show(3);
            sh.Show();
        }

        private void roundButton6_Click(object sender, EventArgs e)
        {
            update_user_pass up = new update_user_pass();
            up.Show();
        }

        private void roundButton2_Click_1(object sender, EventArgs e)
        {
            update_users_data uud = new update_users_data();
            uud.Show();
        }

        private void roundButton4_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Are You sure that you will Leave the system ?! ", "Question", MessageBoxButtons.YesNo, MessageBoxIcon.Asterisk);
            if (DialogResult.Yes == dr)
            {
                try
                {
                    SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                    conn.Open();
                    ////////////////////////////
                    string insert_query0 = "DELETE FROM Car_Store.users_data WHERE username='" + Form1.username_login + "' ;";
                    string insert_query = "DELETE FROM login WHERE username='" + Form1.username_login + "' ;";
                    // SqlCommand sc = new SqlCommand(insert_query0, conn);
                    SqlCommand s2 = new SqlCommand(insert_query, conn);
                    ////////////////////////////
                    int ok2 = s2.ExecuteNonQuery();
                    conn.Close();
                    if (ok2 >= 1)
                    {
                        MessageBox.Show("Operation Completed Successfully", "Leavingthe System ", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
                        Application.Exit();
                    }
                    else
                        MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
                }
            }
            else
            {
                MessageBox.Show("Nothing Happend, will still in the system", "information", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog ofd = new OpenFileDialog())
            {
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    store_logo = ofd.FileName.ToString();
                    logo_label.Text = "The Image is Selected.";

                }
            }
        }

        private void roundButton1_Click(object sender, EventArgs e)
        {

            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                //////////////////////////////////////img store logo
                byte[] images3 = null;
                FileStream stream3 = new FileStream(store_logo, FileMode.Open, FileAccess.Read);
                BinaryReader brs3 = new BinaryReader(stream3);
                images3 = brs3.ReadBytes((int)stream3.Length);
                ///////////////////////////////////////////////////////////////////////////////////////////////
                string insert_query0 = "UPDATE my_setting SET store_name='" + store_name.Text + "',store_number='" + store_number.Text + "',store_address='" + store_address.Text + "',store_logo='" + images3 + "' WHERE id=1 ";
                SqlCommand sc = new SqlCommand(insert_query0, conn);
                sc.ExecuteNonQuery();
                int ok = sc.ExecuteNonQuery();

                
                if (ok >= 1)
                    MessageBox.Show("Congratulations, Operation Completed Successfully", "Congratulations", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
                else
                    MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
                conn.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
        }
    }
}
