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
    public partial class show : Form
    {
        public show(int value)
        {
            InitializeComponent();
            if (value == 1)
            {
                //////////////////////
                SqlCommand cmd;
                SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                con.Open();
                cmd = new SqlCommand("select admin_image from my_setting where username=" + Form1.username_login + "", con);
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    MemoryStream ms = new MemoryStream((byte[])ds.Tables[0].Rows[0]["picname"]);
                    picture.Image = new Bitmap(ms);
                }
            }
            else if(value ==2)
            {
                //////////////////////
                SqlCommand cmd;
                SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                con.Open();
                cmd = new SqlCommand("select admin_id_image from my_setting where username=" + Form1.username_login + "", con);
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    MemoryStream ms = new MemoryStream((byte[])ds.Tables[0].Rows[0]["picname"]);
                    picture.Image = new Bitmap(ms);
                }
            }
            else if(value ==3)
            {
                //////////////////////
                SqlCommand cmd;
                SqlConnection con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                con.Open();
                cmd = new SqlCommand("select store_logo from my_setting where username=" + Form1.username_login + "", con);
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    MemoryStream ms = new MemoryStream((byte[])ds.Tables[0].Rows[0]["picname"]);
                    picture.Image = new Bitmap(ms);
                }
            }
        }

        private void picture_Click(object sender, EventArgs e)
        {

        }
    }
}
