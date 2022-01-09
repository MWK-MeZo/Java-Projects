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
    public partial class remove : Form
    {
        DataSet ds = new DataSet();
        public remove()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            
        }

        private void upload_Click(object sender, EventArgs e)
        {
            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                SqlDataAdapter da = new SqlDataAdapter();
                conn.Open();
                /////////////////////////
                if (comboBox1.Text == "Managers")
                    da.SelectCommand = new SqlCommand("SELECT * FROM users_data WHERE employee_type = 1  ", conn);
                else if (comboBox1.Text == "Bank Accountant")
                    da.SelectCommand = new SqlCommand("SELECT * FROM users_data WHERE employee_type = 3  ", conn);
                else if (comboBox1.Text == "Layer")
                    da.SelectCommand = new SqlCommand("SELECT * FROM users_data WHERE employee_type = 4 ", conn);
                else if (comboBox1.Text == "All Cars")
                    da.SelectCommand = new SqlCommand("SELECT * FROM car ", conn);
                else if (comboBox1.Text == "Store Cars")
                    da.SelectCommand = new SqlCommand("SELECT * FROM car WHERE place_type = " + "Store" + "  ", conn);
                else if (comboBox1.Text == "Garages Cars")
                    da.SelectCommand = new SqlCommand("SELECT * FROM users_data WHERE place_type != " + "Store" + "", conn);
                else if (comboBox1.Text == "Car Models")
                    da.SelectCommand = new SqlCommand("SELECT * FROM car_model ", conn);
                else if(comboBox1.Text == "Suppllier")
                    da.SelectCommand = new SqlCommand("SELECT * FROM supllier  ", conn);
                else if (comboBox1.Text == "Garages")
                    da.SelectCommand = new SqlCommand("SELECT * FROM  garage_data ", conn);

                ds.Clear();
                da.Fill(ds);
                data.DataSource = ds.Tables[0];
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form4.export_pdf(data, comboBox1.Text.ToString());
        }
    }
}
