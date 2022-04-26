/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MWK
 */
public class information_stusents extends javax.swing.JFrame {
    
    
    /**
     * Creates new form model
     */
    public information_stusents() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(459,436);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        
    
      public ArrayList<Courses> userlist(String selectedCourse){
        ArrayList<Courses> userslist = new ArrayList<>();
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";
            Connection con =DriverManager.getConnection(url);
            String query1="SELECT * FROM courses where name = '"+selectedCourse+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Courses courses;
            if(rs.next())
            {
                courses=new Courses(rs.getInt("id"),rs.getInt("hours"),rs.getString("name"));
                userslist.add(courses); 
            }
         }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }
         return userslist;
    }
      
    public void show_user(String selectedCourse){
        ArrayList<Courses> list =  userlist( selectedCourse);
        DefaultTableModel model = (DefaultTableModel)Table1_display_student.getModel();
        Object [] row = new Object[3];
        for(int i=0 ;i<list.size() ;i++)
        {
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getHours();
            model.addRow(row); 
            if(registeredHours+list.get(i).getHours()<=18)
                registeredHours+=list.get(i).getHours();
        }
    
    }
    
    
    
    
    
    
     String user, levels;
     public void setUP(String username)
    {
         user=username;
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";
            Connection con =DriverManager.getConnection(url);
            String query1="SELECT * FROM stdinfo where username = '"+user+"'";
         
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            STDinfo s;

            if(rs.next())
            {
                 s=new STDinfo(rs.getInt("id"),rs.getString("name"),rs.getInt("stdlevel"),rs.getString("gendar"),rs.getDouble("gpa"),"",rs.getInt("stdhours"),"");   
                 String ids=s.getId()+"";
                 levels=s.getLevel()+"";
                 String gpas=s.getGpa()+"";
                 id.setText(ids);
                 name.setText(s.getName());
                 gendar.setText(s.getGendar());
                 level.setText(levels);
                 gpa.setText(gpas);
                 hours.setText(s.getHours()+"");
           switch (levels) {
            case "1":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hand Writing", "IT", "Electronics", "Math1","Physics","English","History of Computing" }));
                break;
            case "2":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OOP", "Data Communication", "Discrete Math", "IS","Project Management","Technical Writing","Bussiness Mangement" }));
                break;
            case "3":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graphics", "Network","Algorithms","Art","Images","Software Engineering" }));
                break;
            case "4":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compiler", "Computer Vision", "Network Programming", "Web"," Computer Security " }));
                break;
            default:
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
                break;
        }
            }
         
            else 
                JOptionPane.showMessageDialog(null,"Sorry");
                
         }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        add = new javax.swing.JButton();
        course = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        gpa = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1_display_student = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        gendar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        hours = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        save.setForeground(new java.awt.Color(0, 0, 102));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons 16x16/iconfinder_OK_132710.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 93, 20));

        clear.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 0, 0));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 103, 20));

        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons 16x16/iconfinder_Create_132699.png"))); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 160, 80, -1));

        course.setToolTipText("OOP");
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        getContentPane().add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 160, 230, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name   :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID         :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Level    :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GPA     :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        id.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 40, 20));

        gpa.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        gpa.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(gpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 120, 20));

        name.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 150, 20));

        level.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        level.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(level, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 50, 20));

        Table1_display_student.setForeground(new java.awt.Color(0, 0, 153));
        Table1_display_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID ", "Course Name", "Course Hours   "
            }
        ));
        jScrollPane1.setViewportView(Table1_display_student);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 410, 150));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender  :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        gendar.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        gendar.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(gendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 110, 20));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Courses");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hours    :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        hours.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        hours.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 40, 20));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 3, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add Courses ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/lap.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 0, 590, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   Date d= new Date();
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";    
            Connection con =DriverManager.getConnection(url);
            String query="insert into usercourses(username ,coursename)values(?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            for(int i=0 ;i<c;i++){
            pst.setString(1,user);  
            pst.setString(2, registeredCourses[i]);
            pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null,"Courses Registered Succesfully ,For Any Edition Go to Modify ");
            
            String query1 ="UPDATE stdinfo SET stdhours=? , date0=? where username='"+user+"'"; 
            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.setString(1,registeredHours+"");
            pst1.setObject(2,d);
            pst1.executeUpdate();
            modifiy dis = new modifiy();
            dis.setUP(user);
            dis.setVisible(true);
            setVisible(false);
       }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
    
        int opt= JOptionPane.showConfirmDialog(null, "Are U Sure to Delete All Course","Delete All",JOptionPane.YES_NO_OPTION);
        if(opt==0){
        
        DefaultTableModel model = (DefaultTableModel) Table1_display_student.getModel();
        model.setRowCount(0);
              switch (levels) {
            case "1":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hand Writing", "IT", "Electronics", "Math1","Physics","English","History of Computing" }));
                break;
            case "2":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OOP", "Data Communication", "Discrete Math", "IS","Project Management","Technical Writing","Bussiness Mangement" }));
                break;
            case "3":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graphics", "Network","Algorithms","Art","Images","Software Engineering" }));
                break;
            case "4":
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compiler", "Computer Vision", "Network Programming", "Web"," Computer Security " }));
                break;
            default:
                course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
                break;
        }
          registeredHours=0;
          hours.setText(registeredHours+"");
            c=0;
       
        }

       
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_courseActionPerformed
             String registeredCourses[]=new String[10];
    int      registeredHours,c=0;
    String selectedCourse;

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try{
        selectedCourse = course.getSelectedItem().toString();
        registeredCourses[c]=selectedCourse;
        c++;
        int i=course.getSelectedIndex();
        DefaultTableModel model = (DefaultTableModel) Table1_display_student.getModel();
        show_user(selectedCourse);
        hours.setText(registeredHours+"");
        course.removeItemAt(i);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "    NO Item Selected");
        }
    }//GEN-LAST:event_addActionPerformed

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
            java.util.logging.Logger.getLogger(information_stusents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(information_stusents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(information_stusents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(information_stusents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new information_stusents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1_display_student;
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JLabel gendar;
    private javax.swing.JLabel gpa;
    private javax.swing.JLabel hours;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
 
}
