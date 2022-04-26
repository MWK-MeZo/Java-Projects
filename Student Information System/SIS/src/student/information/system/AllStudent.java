/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MWK
 */
public class AllStudent extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public AllStudent() {
        initComponents();
        this.setSize(445,437);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
      public ArrayList<STDinfo> userlist(){
        ArrayList<STDinfo> userslist = new ArrayList<>();
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";
            Connection con =DriverManager.getConnection(url);
            String query1;
            if(level==0)
                 query1="SELECT * FROM stdinfo";
            else 
                 query1="SELECT * FROM stdinfo where stdlevel="+level;
                
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            STDinfo std;
            while(rs.next())
            {
                std=new STDinfo(rs.getInt("id"),rs.getString("name"),rs.getInt("stdlevel"),"",rs.getDouble("gpa"),"",rs.getInt("stdhours"),"");
                userslist.add(std);
                stdn++;
            }
         }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }
         return userslist;
    }
    public void show_user(){
        ArrayList<STDinfo> list =  userlist( );
        DefaultTableModel model = (DefaultTableModel)Table1_display_student.getModel();
        Object [] row = new Object[5];
        for(int i=0 ;i<list.size() ;i++)
        {
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getName();    
            row[2]=list.get(i).getLevel();
            row[3]=list.get(i).getGpa();
            row[4]=list.get(i).getHours();
            model.addRow(row);            
        }
    }
    int stdn=0;
    int level;
    public void setLevel(int level)
    {
        this.level=level;
        show_user();
         number.setText(stdn+"");
    }

    public void set()
    {
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1_display_student = new javax.swing.JTable();
        printall = new javax.swing.JButton();
        display = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        number = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Information ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        Table1_display_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Level", "GPA", "Hours"
            }
        ));
        jScrollPane1.setViewportView(Table1_display_student);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 420, 270));

        printall.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        printall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons24x24/Printer-icon.png"))); // NOI18N
        printall.setText("Print All Student");
        printall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printallActionPerformed(evt);
            }
        });
        getContentPane().add(printall, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 170, -1));

        display.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        display.setText("Display All Info");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayActionPerformed(evt);
            }
        });
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 150, 30));

        back.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons 16x16/iconfinder_Go_forward_132792.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 90, 20));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Number Of Students  :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 130, 20));

        number.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        number.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 80, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/lap.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, -30, 540, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Admin_loOgo f= new Admin_loOgo();
        f.setVisible(true);
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";
            Connection con =DriverManager.getConnection(url);
            DefaultTableModel model =(DefaultTableModel) Table1_display_student.getModel();
            int row,id;
            row = Table1_display_student.getSelectedRow();
            id = Integer.parseInt(model.getValueAt(row,0).toString());
            String query1="SELECT * FROM stdinfo where id ="+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            STDinfo std;
            if(rs.next())
            {
                std=new STDinfo(rs.getInt("id"),rs.getString("username"),0,"",0,"",0,"");
                
                printadmin p = new printadmin();
                p.setUP(std.getName());
                p.setVisible(true);
                setVisible(false);
            }
         }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,"NO Item Selected !");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_displayActionPerformed

    private void printallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printallActionPerformed
        MessageFormat header = new MessageFormat("Student Information ");
        MessageFormat footer = new MessageFormat("Page - [1] ");
        try{
            Table1_display_student.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_printallActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AllStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1_display_student;
    private javax.swing.JButton back;
    private javax.swing.JButton display;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel number;
    private javax.swing.JButton printall;
    // End of variables declaration//GEN-END:variables
}
