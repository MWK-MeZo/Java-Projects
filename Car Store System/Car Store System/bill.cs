using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Drawing.Printing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;
using System.Drawing.Printing;
using System.Windows.Forms;

namespace Car_Store_System
{
    public partial class bill : Form
    {
        string Cust_id, car_file;
        public bill()
        {
            InitializeComponent();
            /////////////////////////////////////////////
            try
            {
                SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                ////////////////////////////////////////////////////////////////////
                con.Open();
                string quary = "SELECT store_name , store_number ,store_address FROM my_setting WHERE id=@id ";
                SqlCommand cmd = new SqlCommand(quary, con);
                cmd.Parameters.AddWithValue("@id", 1);
                SqlDataReader da = cmd.ExecuteReader();
                while (da.Read())
                {
                    store_name.Text = da.GetValue(0).ToString();
                    store_number.Text = da.GetValue(1).ToString();
                    store_add.Text = da.GetValue(2).ToString();
                    // storeLOGO.Image = Image.FromFile(Directory.GetCurrentDirectory() + da.GetValue(3));


                    name2.Text = store_name.Text.ToString();
                }
                con.Close();
                ////////////////////////////////////////////
                con.Open();
                SqlCommand cmdzs = new SqlCommand("SELECT MAX(Id) as i FROM sold_cars ", con);
                cmdzs.ExecuteNonQuery();
                DataTable dttt = new DataTable();
                SqlDataAdapter ss = new SqlDataAdapter(cmdzs);
                ss.Fill(dttt);
                foreach (DataRow dr in dttt.Rows)
                {
                    string str = dr["i"].ToString();
                    int k = Int32.Parse(str);
                    k++;
                    bill_id.Text = k + "";
                }
                con.Close();
                //////////////////////////////////////////////
           }
            catch (Exception ex)
            {
                
            }
            /////////////////////////////////////////////////

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void roundButton3_Click(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                ///////////////////////////////////////////car id & model id
                long c_id, m_id;
                c_id = Int64.Parse(Car_ID.Text.ToString());
                m_id = Int64.Parse(Car_MODEL.Text.ToString());
                //////////////////////////////////////////img1
                byte[] images = null;
                FileStream stream = new FileStream(Cust_id, FileMode.Open, FileAccess.Read);
                BinaryReader brs = new BinaryReader(stream);
                images = brs.ReadBytes((int)stream.Length);
                /////////////////////////////////file proccessing
                FileStream fstream = File.OpenRead(car_file);
                byte[] contents = new byte[fstream.Length];
                fstream.Read(contents, 0, (int)fstream.Length);
                fstream.Close();
                //////////////////////////////////////////sql options
                string insert_query0 = "insert into sold_cars values ('" + c_id + "','" + Car_brand.Text.ToString() + "' , '" + Car_capacity.Text.ToString() + "', '" + m_id + "' , '" + Color.Text.ToString() + "' , '" + Car_CATAGORY.Text.ToString() + "' , '" + Cost.Text.ToString() + "' , '" + contents + "' , '" + CustomerName.Text.ToString() + "' , '" + Cust_add.Text.ToString() + "' , '" + Cust_number.Text.ToString() + "', '" + images + "')";
                SqlCommand sc = new SqlCommand(insert_query0, conn);
                int ok = sc.ExecuteNonQuery();
                
                if (ok >= 1)
                    MessageBox.Show("Congratulations, Operation Completed Successfully", "Congratulations", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
                else
                    MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
                conn.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Your Data Has An Error ! ", "Error", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }

        }

        private void roundButton1_Click(object sender, EventArgs e)
        {
              
        }

        private Bitmap _memoryImage;

        private void CaptureScreen()
        {
            // put into using construct because Graphics objects do not 
            //  get automatically disposed when leaving method scope
            using (var myGraphics = CreateGraphics())
            {
                var s = Size;
                _memoryImage = new Bitmap(s.Width, s.Height, myGraphics);
                using (var memoryGraphics = Graphics.FromImage(_memoryImage))
                {
                    memoryGraphics.CopyFromScreen(Location.X, Location.Y, 0, 0, s);
                }
            }
        }

        private void printDocument1_PrintPage(object sender, PrintPageEventArgs e)
        {
            // calculate width and height scalings taking page margins into account
            var wScale = e.MarginBounds.Width / (float)_memoryImage.Width;
            var hScale = e.MarginBounds.Height / (float)_memoryImage.Height;

            // choose the smaller of the two scales
            var scale = wScale < hScale ? wScale : hScale;

            // apply scaling to the image
            e.Graphics.ScaleTransform(scale, scale);

            // print to default printer's page
            e.Graphics.DrawImage(_memoryImage, 0, 0);
        }
        private void bill_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void label10_Click(object sender, EventArgs e)
        {

        }

        private void label12_Click(object sender, EventArgs e)
        {

        }

        private void label13_Click(object sender, EventArgs e)
        {

        }

        private void label14_Click(object sender, EventArgs e)
        {

        }

        private void label15_Click(object sender, EventArgs e)
        {

        }

        private void label16_Click(object sender, EventArgs e)
        {

        }

        private void label17_Click(object sender, EventArgs e)
        {

        }

        private void label18_Click(object sender, EventArgs e)
        {

        }

        private void label19_Click(object sender, EventArgs e)
        {

        }

        private void label20_Click(object sender, EventArgs e)
        {

        }

        private void label22_Click(object sender, EventArgs e)
        {

        }

        private void label23_Click(object sender, EventArgs e)
        {

        }

        private void label24_Click(object sender, EventArgs e)
        {

        }

        private void label25_Click(object sender, EventArgs e)
        {

        }

        private void label26_Click(object sender, EventArgs e)
        {

        }

        private void label21_Click(object sender, EventArgs e)
        {

        }

        private void label27_Click(object sender, EventArgs e)
        {

        }

        private void label28_Click(object sender, EventArgs e)
        {

        }

        private void label29_Click(object sender, EventArgs e)
        {

        }

        private void label30_Click(object sender, EventArgs e)
        {

        }

        private void label31_Click(object sender, EventArgs e)
        {

        }

        private void CustomerName_TextChanged(object sender, EventArgs e)
        {

        }

        private void Cust_add_TextChanged(object sender, EventArgs e)
        {

        }

        private void Cust_number_TextChanged(object sender, EventArgs e)
        {

        }

        private void Cost_TextChanged(object sender, EventArgs e)
        {

        }

        private void Color_TextChanged(object sender, EventArgs e)
        {

        }

        private void Car_capacity_TextChanged(object sender, EventArgs e)
        {

        }

        private void Car_brand_TextChanged(object sender, EventArgs e)
        {

        }

        private void Car_CATAGORY_TextChanged(object sender, EventArgs e)
        {

        }

        private void Car_MODEL_TextChanged(object sender, EventArgs e)
        {

        }

        private void Car_ID_TextChanged(object sender, EventArgs e)
        {

        }

        private void label33_Click(object sender, EventArgs e)
        {

        }

        private void label34_Click(object sender, EventArgs e)
        {

        }

        private void label35_Click(object sender, EventArgs e)
        {

        }

        private void textBox13_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox14_TextChanged(object sender, EventArgs e)
        {

        }

        private void Car_File_label_Click(object sender, EventArgs e)
        {

        }

        private void Cust_id_label_Click(object sender, EventArgs e)
        {

        }

        private void label32_Click(object sender, EventArgs e)
        {

        }

        private void roundButton1_Click_1(object sender, EventArgs e)
        {
            using (var BMP = new Bitmap(panel1.Width, panel1.Height))
            {
                panel1.DrawToBitmap(BMP, new Rectangle(0, 0, BMP.Width, BMP.Height));
                string add= @"F:\moaz folders\Car Store Project\Car Store System\Car Store System\Bill Images/";
                
                BMP.Save(add+ CustomerName.Text.ToString()+".jpg");
            }
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            
        }

        private void roundButton3_Click_1(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                ////////////////////////////
               int id = Int32.Parse(Car_ID.Text.ToString()) , modelid = Int32.Parse(Car_MODEL.Text.ToString());
                string insert_query0 = "DELETE FROM car WHERE id ='" + id + "' ";
                SqlCommand sc = new SqlCommand(insert_query0, conn);
                
                ////////////////////////////
                int ok = sc.ExecuteNonQuery();
                conn.Close();
                //////////////////////
                conn.Open();
                string insert_query = "insert into sold_cars values('" + id + "' , '" + Car_brand.Text.ToString() + "', '" + Car_capacity.Text.ToString() + "', '" + modelid + "', '" + Color.Text.ToString() + "', '" + Car_CATAGORY.Text.ToString() + "', '" + Cost.Text.ToString() + "', '" + CustomerName.Text.ToString() + "', '" + Cust_add.Text.ToString() + "', '" + Cust_number.Text.ToString() + "', '" + custid.Text.ToString() + "')";
                SqlCommand s2 = new SqlCommand(insert_query, conn);
                int ok2 = s2.ExecuteNonQuery();
                conn.Close();
                //////////////////////////////
                if (ok >= 1 )
                    MessageBox.Show("Operation Completed Successfully", "Leavingthe System ", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
                else
                    MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n Some thing went wrong check you data please ", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }

        }

    }
}
