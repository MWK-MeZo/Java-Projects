/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information.system;

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
public class ModifyCourses extends javax.swing.JFrame {

    /**
     * Creates new form modifiy_courses
     */
    public ModifyCourses() {
        initComponents(); 
        this.setSize(456,436);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
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
     String coursess []=new String [20]; 
     int registeredHours=0,count=0;
     
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
                  levels=s.getLevel()+"";
                 String gpas=s.getGpa()+"";
                 id.setText(ids);
                 name.setText(s.getName());
                 gendar.setText(s.getGendar());
                 level.setText(levels);
                 hours.setText(s.getHours()+"");
                // registeredHours=s.getHours();

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
                 gpa.setText(gpas);
            }
            else 
            JOptionPane.showMessageDialog(null,"Sorry");
            STDinfo s2;
            while(rs1.next()){
               s2=new STDinfo(rs1.getString("coursename"));
                 coursess[count]=s2.getcourses();
                 count++;
            }
            for(int i=0 ;i<count ;i++)
                show_user(coursess[i]);
            
            for(int i=0 ;i<count ;i++)
            {
                for(int j=0 ;j<7;j++)
                {
                    if(coursess[i].equalsIgnoreCase(course.getItemAt(j)))
                        course.removeItemAt(j);
                }
            }
            course.updateUI();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        gendar = new javax.swing.JLabel();
        hours = new javax.swing.JLabel();
        gpa = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1_display_student = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 46, 18);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID       :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 40, 46, 18);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Level     :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(270, 40, 60, 18);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gender  :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 70, 60, 18);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GPA   :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 100, 43, 18);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hours    :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(270, 100, 59, 18);

        name.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(name);
        name.setBounds(80, 70, 190, 20);

        id.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(id);
        id.setBounds(90, 40, 50, 20);

        level.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        level.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(level);
        level.setBounds(360, 40, 40, 20);

        gendar.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        gendar.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(gendar);
        gendar.setBounds(360, 70, 90, 20);

        hours.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        hours.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(hours);
        hours.setBounds(360, 100, 60, 20);

        gpa.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        gpa.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(gpa);
        gpa.setBounds(80, 100, 120, 20);

        update.setFont(new java.awt.Font("Trebuchet MS", 3, 16)); // NOI18N
        update.setForeground(new java.awt.Color(0, 0, 51));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons24x24/iconfinder_Sync_132469.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(160, 360, 140, 30);

        remove.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        remove.setForeground(new java.awt.Color(0, 0, 51));
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons 16x16/iconfinder_Erase_132784.png"))); // NOI18N
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        getContentPane().add(remove);
        remove.setBounds(20, 370, 120, 20);

        clear.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 0, 51));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(320, 370, 110, 20);

        Table1_display_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Name ", "Course Hour"
            }
        ));
        jScrollPane1.setViewportView(Table1_display_student);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 175, 410, 170);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Courses");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(30, 140, 51, 18);

        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(course);
        course.setBounds(100, 140, 220, 20);

        add.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        add.setForeground(new java.awt.Color(0, 0, 51));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons 16x16/iconfinder_Create_132699.png"))); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(330, 140, 80, 20);

        back.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        back.setForeground(new java.awt.Color(0, 0, 51));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/icons 16x16/iconfinder_Forward_132664.png"))); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(350, 0, 90, 27);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Modify Courses");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(140, 10, 140, 21);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/information/system/images/open-book-low-poly-blue-vector-24633871.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-240, 0, 780, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String registeredCourses[]=new String[20];
    int c=0;
    String selectedCourse;
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
       try{
       int i=course.getSelectedIndex();
       selectedCourse = course.getItemAt(i).toString();
       registeredCourses[c]=selectedCourse;
       c++;
       DefaultTableModel model = (DefaultTableModel) Table1_display_student.getModel();
       show_user(selectedCourse);
       hours.setText(registeredHours+"");       
        course.removeItemAt(i);
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"No Item Selected");
       }    
            // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

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
          c=0;
          hours.setText(registeredHours+"");
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";
            Connection con =DriverManager.getConnection(url);
            String query1 ="DELETE FROM usercourses where username='"+user+"'";
            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null,"All Courses are Deleted");
       }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed
    Date d= new Date();

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
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
            JOptionPane.showMessageDialog(null,"Courses Registered Succesfully ,For Any Edition Go to Modify \n\t                      YouRegistered "+registeredHours+" Hours");
            
            String query1 ="UPDATE stdinfo SET stdhours=? , date0=? where username='"+user+"'";
            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.setString(1,registeredHours+"");
            pst1.setObject(2,d);
            pst1.executeUpdate();
            modifiy show = new modifiy();
            show.setUP(user);
            show.setVisible(true);
            setVisible(false);
       }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
            int opt= JOptionPane.showConfirmDialog(null, "Are U Sure to Remove TheCourse","Remove Course",JOptionPane.YES_NO_OPTION);
        if(opt==0){ 
        try{
            DefaultTableModel model = (DefaultTableModel) Table1_display_student.getModel();
            int row =Table1_display_student.getSelectedRow(); 
            String removedcourse=model.getValueAt(row,1).toString();   
            course.addItem(removedcourse);
            registeredHours=registeredHours-(Integer.parseInt(model.getValueAt(row,2).toString()));
            hours.setText(registeredHours+"");
             model.removeRow(row);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=01098581649rod";
            Connection con =DriverManager.getConnection(url);
            String query1 ="DELETE FROM usercourses where username='"+user+"' and coursename='"+removedcourse+"'";
            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.executeUpdate();
       }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,"No Item Selected");
       }
        if(c>0)
            c--;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_removeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    modifiy show = new modifiy();
            show.setUP(user);
            show.setVisible(true);
            setVisible(false);        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyCourses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1_display_student;
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JLabel gendar;
    private javax.swing.JLabel gpa;
    private javax.swing.JLabel hours;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    private javax.swing.JButton remove;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
