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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author MWK
 */
public class print extends javax.swing.JFrame {

    /**
     * Creates new form print
     */
    public print() {
        initComponents();
          this.setSize(462,345);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
      
    }
       
    String user;
    String course[]=new String[20];
    int c=0;
    public void setUP(String username)
    {
         user=username;
         
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";
            Connection con =DriverManager.getConnection(url);
            String query="SELECT * FROM stdinfo where username = '"+user+"'";        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            String query1="SELECT * FROM usercourses where username = '"+user+"'";         
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);
 
            STDinfo s;
            if(rs.next())
            {
                 s=new STDinfo(rs.getInt("id"),rs.getString("name"),rs.getInt("stdlevel"),rs.getString("gendar"),rs.getDouble("gpa"),"",rs.getInt("stdhours"),"");   
                 String ids=s.getId()+"";
                 String levels=s.getLevel()+"";
                 String gpas=s.getGpa()+"";
                 id.setText(ids);
                 name.setText(s.getName());
                 gendar.setText(s.getGendar());
                 level.setText(levels);
                 gpa.setText(gpas);
                 hours.setText(s.getHours()+"");
                 
            }
            STDinfo s2;
            while(rs1.next()){
               s2=new STDinfo(rs1.getString("coursename"));
                 course[c]=s2.getcourses();
                 c++;
            }
            courses.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = course;
            public int getSize() { return c; }
            public String getElementAt(int i) { return strings[i]; }
});      
      
         }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        gendar = new javax.swing.JLabel();
        gpa = new javax.swing.JLabel();
        hours = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        courses = new javax.swing.JList<>();
        back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID         :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name   :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Level   :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gender:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GPA     : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hours  :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        id.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 100, 20));

        name.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 170, 20));

        level.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        level.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(level, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 120, 20));

        gendar.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        gendar.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(gendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 160, 20));

        gpa.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        gpa.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(gpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 110, 20));

        hours.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        hours.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 130, 20));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Courses");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jScrollPane2.setViewportView(courses);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 140, 220));

        back.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons 16x16/iconfinder_Go_forward_132792.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/lap.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 570, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
            modifiy show = new modifiy();
            show.setUP(user);
            show.setVisible(true);
            setVisible(false);                    // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JList<String> courses;
    private javax.swing.JLabel gendar;
    private javax.swing.JLabel gpa;
    private javax.swing.JLabel hours;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
