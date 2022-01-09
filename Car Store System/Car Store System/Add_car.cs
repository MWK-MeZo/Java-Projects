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
    public partial class Add_car : Form
    {
        String car_owner_img, car_img;
        
        public Add_car()
        {
            InitializeComponent();
           
        }

        private void import_car_img_Click(object sender, EventArgs e)
        {

            using (OpenFileDialog ofd = new OpenFileDialog())
            {
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    car_img = ofd.FileName.ToString();
                    Car_image.Text = "The Image is Selected.";
                }
            }
        }

        private void car_owner_id_image_Click(object sender, EventArgs e)
        {

            using (OpenFileDialog ofd = new OpenFileDialog())
            {
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    car_owner_img = ofd.FileName.ToString();
                    car_owner_id_image.Text = "The Image is Selected.";
                }
            }
        }

        private void Add_car_Load(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
            ////////////////////////////////brand 
            brand.Items.Clear();
            conn.Open();
            SqlCommand cdp = conn.CreateCommand();
            cdp.CommandType = CommandType.Text;
            cdp.CommandText = "select prand from prand";
            cdp.ExecuteNonQuery();
            DataTable dttp = new DataTable();
            SqlDataAdapter sa = new SqlDataAdapter(cdp);
            sa.Fill(dttp);
            foreach (DataRow dr in dttp.Rows)
            {
                brand.Items.Add(dr["prand".ToString()]);
            }
            conn.Close();
            ////////////////////////////////car palce 
            car_place.Items.Clear();
            conn.Open();
            SqlCommand cmd = conn.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "select garage_name from garage_data";
            cmd.ExecuteNonQuery();
            DataTable dt = new DataTable();
            SqlDataAdapter sda = new SqlDataAdapter(cmd);
            car_place.Items.Add("Store");
            sda.Fill(dt);
            foreach (DataRow drr in dt.Rows)
            {
                car_place.Items.Add(drr["garage_name".ToString()]);
            }
            conn.Close();
            ///////////////////////////////////car model
            model_id.Items.Clear();
            conn.Open();
            SqlCommand cd = conn.CreateCommand();
            cmd.CommandType = CommandType.Text;
            cmd.CommandText = "select model from car_model";
            cmd.ExecuteNonQuery();
            DataTable dtt = new DataTable();
            SqlDataAdapter sd = new SqlDataAdapter(cmd);
            sd.Fill(dtt);
            foreach (DataRow dr in dtt.Rows)
            {
                model_id.Items.Add(dr["model".ToString()]);
            }
            conn.Close();
            
        }

        private void model_id_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void brand_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void roundButton1_Click(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                //////////////////////////////////////////car model number
                long car_model_num;
                car_model_num = Int64.Parse(model_id.Text.ToString());
                //////////////////////////////////////////img1
                byte[] images = null;
                FileStream stream = new FileStream(car_img, FileMode.Open, FileAccess.Read);
                BinaryReader brs = new BinaryReader(stream);
                images = brs.ReadBytes((int)stream.Length);
                //////////////////////////////////////////img2
                byte[] images2 = null;
                FileStream stream2 = new FileStream(car_owner_img, FileMode.Open, FileAccess.Read);
                BinaryReader brs2 = new BinaryReader(stream2);
                images2 = brs2.ReadBytes((int)stream2.Length);
                //////////////////////////////////////////sql options
                string insert_query0 = "insert into car values ('" + brand.Text.ToString() + "' ,'" + color.Text.ToString() + "','" + capacity.Text.ToString() + "','" + body_style.Text.ToString() + "','" + cost.Text.ToString() + "','" + car_type.Text.ToString() + "','" + car_kind.Text.ToString() + "','" + car_owner_name.Text.ToString() + "','" + car_owner_id.ToString() + "','" + car_owner_address.Text.ToString() + "','" + car_owner_phone_number.Text.ToString() + "','" + car_model_num + "','" + car_place.Text.ToString() + "')";
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
                MessageBox.Show("Your Data Has An Error ! ", "Error", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }

        }
    }
}
