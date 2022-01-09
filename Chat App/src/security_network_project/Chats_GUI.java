/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security_network_project;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static security_network_project.Chats_GUI.client_num;
import static security_network_project.Sever.i;

/**
 *
 * @author MWK
 */
public class Chats_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Chats_GUI
     */
    static RSA rsa=new RSA();
        static int client_num=0;
        Scanner scn = new Scanner(System.in);
        InetAddress ip = InetAddress.getByName("localhost");
        Socket s = new Socket(ip, 1234);
        //DataInputStream dis = new DataInputStream(s.getInputStream());
        InputStream in = s.getInputStream();
           DataInputStream dis = new DataInputStream(in);
         OutputStream out = s.getOutputStream(); 
    DataOutputStream dos = new DataOutputStream(out);
    
       //DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        
       int the_num = client_num+1;
    public Chats_GUI() throws IOException, AWTException {
        initComponents();
        client_num++;
        this.setSize(702, 429);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Chat");
        Cleint.setText("Client Number : " + Integer.toString(client_num));
        read();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cleint = new javax.swing.JLabel();
        MSG_FORM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Show_Data = new javax.swing.JTextArea();
        number = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cleint.setBackground(new java.awt.Color(0, 0, 0));
        Cleint.setFont(new java.awt.Font("Monotype Corsiva", 3, 48)); // NOI18N
        Cleint.setText("Client");
        getContentPane().add(Cleint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 370, -1));

        MSG_FORM.setBackground(new java.awt.Color(51, 51, 51));
        MSG_FORM.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        MSG_FORM.setForeground(new java.awt.Color(255, 255, 255));
        MSG_FORM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(MSG_FORM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 380, 30));

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setFont(new java.awt.Font("Monotype Corsiva", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/security_network_project/iconfinder_Go_back_132769.png"))); // NOI18N
        jButton1.setText("Send");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 80, 30));

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setFont(new java.awt.Font("Monotype Corsiva", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/security_network_project/iconfinder_Exit_132751.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 100, 30));

        Show_Data.setEditable(false);
        Show_Data.setBackground(new java.awt.Color(51, 51, 51));
        Show_Data.setColumns(20);
        Show_Data.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        Show_Data.setForeground(new java.awt.Color(255, 255, 255));
        Show_Data.setRows(5);
        Show_Data.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(Show_Data);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 650, 300));

        number.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        getContentPane().add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 50, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/security_network_project/this.jpeg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if( Integer.parseInt(number.getSelectedItem().toString().trim()) > client_num){
            JOptionPane.showMessageDialog(this, "You Can't send to an offline Client! ","WARNING", JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                chat_connection();
            } catch (IOException ex) {
                Logger.getLogger(Chats_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Chats_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chats_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chats_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chats_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Chats_GUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Chats_GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AWTException ex) {
                    Logger.getLogger(Chats_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cleint;
    private javax.swing.JTextField MSG_FORM;
    private javax.swing.JTextArea Show_Data;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> number;
    // End of variables declaration//GEN-END:variables
    
    private void chat_connection() throws UnknownHostException, IOException {
  
         Thread sendMessage = new Thread(new Runnable() 
        {
            @Override
            public void run() {   
                    String temp = number.getSelectedItem().toString().trim();
                    int process = Integer.parseInt(temp);
                    System.out.println(temp);
                    String msg = MSG_FORM.getText().toString().trim() ;
                    
                    
                    String client_num="#client " + Integer.toString(process);
                    System.out.println("H:  "+client_num);
                  
                    byte[] cipher = rsa.encryptMessage(msg.getBytes());
                     System.out.println("Chiper message is: " + RSA.bToS(cipher));
                    int len=cipher.length;
                   
                    Show_Data.setText(Show_Data.getText().toString().trim() + "\n" + "Me : " + MSG_FORM.getText().toString().trim() + "         (Send To : #client " +  Integer.toString(process) + " ) " );
                    try {
                         dos.writeInt(len);
                         dos.write(cipher,0,cipher.length);
                         dos.writeUTF(client_num);
                        MSG_FORM.setText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        });
        
  
        sendMessage.start();
  
    }
    
    void read(){
         Thread readMessage = new Thread(new Runnable() 
        {
            @Override
            public void run() {
                while (true) {
                    try {
                         int len = dis.readInt();
                        String client_num = dis.readUTF();
                       
                        byte[] data = new byte[len];
                        dis.read(data);
                        
                        byte[] plain = rsa.decryptMessage(data);
                        
                         System.out.println("Plain message is: " + RSA.bToS(plain));
                        //String client_num = dis.readUTF();
                        System.out.println(client_num + new String(plain)); 
                        Show_Data.setText(Show_Data.getText().toString().trim() + "\n" + client_num +  new String(plain));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(" Lol");   
                }
            }
            
            
        });
        
        readMessage.start();
    }
}
