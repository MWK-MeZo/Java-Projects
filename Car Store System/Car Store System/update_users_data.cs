﻿using System;
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
    public partial class update_users_data : Form
    {
        string image_location, file_location; 

        public update_users_data()
        {
            InitializeComponent();
        }

        private void id_img_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog ofd = new OpenFileDialog())
            {
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    image_location = ofd.FileName.ToString();
                    img_label.Text = "The Image is Selected.";

                }
            }
        }

        private void cv_xml_Click(object sender, EventArgs e)
        {
            using (OpenFileDialog ofd = new OpenFileDialog())
            {
                if (ofd.ShowDialog() == DialogResult.OK)
                {
                    DialogResult dialog = MessageBox.Show(" Are You Sure you want to upload this pdf ?! ", "Warnning !", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                    if (dialog == DialogResult.Yes)
                    {
                        file_location = ofd.FileName;
                        pdf_label.Text = "the File Is selected !";
                    }
                }
            }
        }

        private void label11_Click(object sender, EventArgs e)
        {

        }

        private void roundButton1_Click(object sender, EventArgs e)
        {

            int user_type = 1;
            byte[] images = null;
            /////////////////////////////////img proccessing
            FileStream stream = new FileStream(image_location, FileMode.Open, FileAccess.Read);
            BinaryReader brs = new BinaryReader(stream);
            images = brs.ReadBytes((int)stream.Length);
            /////////////////////////////////file proccessing
            FileStream fstream = File.OpenRead(file_location);
            byte[] contents = new byte[fstream.Length];
            fstream.Read(contents, 0, (int)fstream.Length);
            
            /////////////////////////////////age proccessing
            long age_value = Int64.Parse(age.Text.ToString());
            /////////////////////////////////SQL SERVER PROCCESSING     

            try
            {
                SqlConnection conn = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=F:\moaz folders\Car Store Project\Car Store System\Car Store System\Data_Base\Car_Store.mdf;Integrated Security=True;Connect Timeout=30;");
                conn.Open();
                user_type = comboBox1.SelectedIndex;
                string insert_query = "update users_data SET name='" + name.Text.ToString() + "',age='" + age_value + "',id='" + id.Text.ToString() + "',qualification='" + qualification.Text.ToString() + "',address='" + address.Text.ToString() + "',phone_number='" + phone_number.Text.ToString() + "',employee_type'" + user_type + "' ,username='" + username.Text.ToString() + "'";
                SqlCommand sc2 = new SqlCommand(insert_query, conn);
                int check2 = sc2.ExecuteNonQuery();
                
                if (check2 >= 1)
                    MessageBox.Show("Congratulations, Operation Completed Successfully", "Congratulations", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
                else
                    MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
                fstream.Close();
                conn.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error! \n make sure that all data is correct please", "Warnning", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
            }
        }

    }
}
