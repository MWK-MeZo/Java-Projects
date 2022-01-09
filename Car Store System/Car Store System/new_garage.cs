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
    public partial class new_garage : Form
    {
        string image_garage = "";
        public new_garage()
        {
            InitializeComponent();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void roundButton1_Click(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                ///////////////////////////////img
                byte[] images = null; 
                FileStream stream = new FileStream(image_garage, FileMode.Open, FileAccess.Read);
                BinaryReader brs = new BinaryReader(stream);
                images = brs.ReadBytes((int)stream.Length);
                //////////////////////////////////////////////
                string insert_query0 = "insert into garage_data values ('" + garage_owner_id.Text.ToString() + "' ,'" + garage_name.Text.ToString() + "','" + garage_address.Text.ToString() + "','" + garage_number.Text.ToString() + "','" + garage_owner_phone.Text.ToString() + "')";
                SqlCommand sc = new SqlCommand(insert_query0, conn);
                int ok = sc.ExecuteNonQuery();
                
                conn.Close();
                if (ok>=1)
                    MessageBox.Show("Congratulations, Operation Completed Successfully", "Congratulations", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
                else
                    MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }

        }

        private void import_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog ofd = new OpenFileDialog())
            {
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    image_garage = ofd.FileName.ToString();
                    img_label.Text = "The Image is Selected.";

                }
            }
        }
    }
}
