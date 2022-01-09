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
    public partial class salles_table : Form
    {
        DataSet ds = new DataSet();

        public salles_table()
        {
            InitializeComponent();
            upload_data();
        }


        private void upload_data()
        {

            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                SqlDataAdapter da = new SqlDataAdapter();
                conn.Open();
                /////////////////////////
                da.SelectCommand = new SqlCommand("SELECT * FROM sold_cars ", conn);
                ds.Clear();
                da.Fill(ds);
                data.DataSource = ds.Tables[0];
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
        }

        private void roundButton1_Click(object sender, EventArgs e)
        {
            Form4.export_pdf(data, "Salles Table Data ");
        }
    }
}
