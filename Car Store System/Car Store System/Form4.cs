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
using iTextSharp.text;
using iTextSharp.text.pdf;
using System.IO;
namespace Car_Store_System
{
    public partial class Form4 : Form
    {
        DataSet ds = new DataSet();
        public Form4()
        {
            InitializeComponent();
        }

        private void logOutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void carModelToolStripMenuItem_Click(object sender, EventArgs e)
        {
            car_model cm = new car_model();
            cm.Show();
        }

        private void showInventoryCarToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void carToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Add_car ac = new Add_car();
            ac.Show();
        }

        private void mySettingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            update_user_pass setting = new update_user_pass();
            setting.Show();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
        }

        private void roundButton2_Click(object sender, EventArgs e)
        {
                
            string table_name = "";
            if (select_table.Text == "All Cars")
                table_name = "car";
            else if (select_table.Text == "Garages")
                table_name = "garage_data";
            else if (select_table.Text == "Car Models")
                table_name = "car_model";
            else if (select_table.Text == "Customers")
                table_name = "customers";
            else if (select_table.Text == "Store Cars")
                table_name = "car";
            else if (select_table.Text == "Garage Car")
                table_name = "car";

            SqlConnection cs = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
            SqlDataAdapter da = new SqlDataAdapter();
            if(select_table.Text == "Store Cars")
            {
                da.SelectCommand = new SqlCommand("SELECT * FROM " + "car" + "WHERE  car_place ="+"Store"+"", cs);
            }
            else if(select_table.Text == "Garage Cars")
            {
                da.SelectCommand = new SqlCommand("SELECT * FROM " + table_name + "WHERE  car_place !=" + "Store" + "", cs);
            }
            else
            {
                da.SelectCommand = new SqlCommand("SELECT * FROM " + table_name + " ", cs);
            }
            ds.Clear();
            da.Fill(ds);
            dataGridView1.DataSource = ds.Tables[0];
        }

        private void customerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form5 customer = new Form5();
            customer.Show();
        }

        private void saleBillToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bill bl = new bill();
            bl.Show();
        }

        private void roundButton1_Click(object sender, EventArgs e)
        {
            export_pdf(dataGridView1, select_table.Text.ToString());
        }

        public static void export_pdf(DataGridView dgw, string filename)
        {
            BaseFont bf = BaseFont.CreateFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.EMBEDDED);
            PdfPTable pdftable = new PdfPTable(dgw.Columns.Count);
            pdftable.DefaultCell.Padding = 3;
            pdftable.WidthPercentage = 100;
            pdftable.HorizontalAlignment = Element.ALIGN_LEFT;
            pdftable.DefaultCell.BorderWidth = 1;
            iTextSharp.text.Font text = new iTextSharp.text.Font(bf, 10, iTextSharp.text.Font.NORMAL);
            ///////////////add header
            foreach (DataGridViewColumn column in dgw.Columns)
            {
                PdfPCell cell = new PdfPCell(new Phrase(column.HeaderText, text));
                //cell.BackgroundColor = new iTextSharp.text.Color(240, 240, 240);
                pdftable.AddCell(cell);
            }
            ///////////////add datarow
            foreach(DataGridViewRow row in dgw.Rows)
            {
                foreach(DataGridViewCell cell in row.Cells)
                {
                    pdftable.AddCell(new Phrase(cell.Value.ToString(), text));
                }
            }

            var savefiledialoge = new SaveFileDialog();
            savefiledialoge.FileName = filename;
            savefiledialoge.DefaultExt = ".pdf";
            if(savefiledialoge.ShowDialog() == DialogResult.OK)
            {
                using(FileStream stream = new FileStream(savefiledialoge.FileName, FileMode.Create))
                {
                    Document pdfdoc = new Document(PageSize.A4, 10f, 10f, 10f, 0f);
                    pdfdoc.Open();
                    pdfdoc.Add(pdftable);
                    pdfdoc.Close();
                    stream.Close();
                }
            }
        }

        private void leaveTheSystemToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Are You sure that you will Leave the system ?! ", "Question", MessageBoxButtons.YesNo, MessageBoxIcon.Asterisk);
            if (DialogResult.Yes == dr)
            {
                try
                {
                    SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                    conn.Open();
                    ////////////////////////////
                    string insert_query0 = "DELETE FROM users_data WHERE username =" + Form1.username_login + " ";
                    string insert_query = "DELETE FROM login WHERE username =" + Form1.username_login + " ";
                    SqlCommand sc = new SqlCommand(insert_query0, conn);
                    SqlCommand s2 = new SqlCommand(insert_query, conn);
                    ////////////////////////////
                    int ok = sc.ExecuteNonQuery(), ok2 = s2.ExecuteNonQuery();
                    conn.Close();
                    if (ok >= 1 && ok2 >= 1)
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

        private void select_table_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Form4_Load(object sender, EventArgs e)
        {

        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void Form4_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void newPrandToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form7 open = new Form7();
            open.Show();

        }
    }
}
