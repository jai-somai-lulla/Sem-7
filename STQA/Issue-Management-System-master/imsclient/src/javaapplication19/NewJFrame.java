/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author Saurabh
 */
public class NewJFrame extends javax.swing.JFrame implements Runnable{

     String uname = "";
    loading l = new loading();
     Socket soc;
            
            
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        
        initComponents();
//        System.out.println(soc.getPort());
    }
    
    public void setsocket(Socket soc)
    {
    this.soc = soc;
   
    }
    
    public void display()
    {
    System.out.println(soc.getPort());
    }
     
    public void run()
    {
      //  NewJFrame1 n = new NewJFrame1();
    jdbc j =  new jdbc();
         String s ="Select * from login";
         ResultSet r = j.getaccess(s);
         int f =0;
         
        
        try {
            while(r.next())
            {
                if(r.getString(3).equals(jTextField1.getText()) && r.getString(1).equals(jPasswordField1.getText()) )
               {
                   if(jComboBox1.getSelectedItem().equals(r.getString(2)))
                   {
                    f=1;
                    break;
                   }
                   else
                   {
                   jLabel2.setText("You are not "+jComboBox1.getSelectedItem());
                   f=2;
                   }
               }     
            }
            uname = r.getString(3);
             //n.setuname(uname);
            j.closecon();
            
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         
            
        if(f==1 )
       {
       jLabel2.setText("Sucess!!");
      //  NewJFrame1 n = new NewJFrame1(jComboBox1.getSelectedItem().toString());
      MainDisplayFrame n = new MainDisplayFrame();
        try {
            n.setsocket(soc);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
      n.display();
       n.setuname(uname);
       n.setUserType(jComboBox1.getSelectedItem().toString());
               l.jProgressBar1.setValue(100);
              
             l.dispose();
             
               n.setVisible(true);
               n.setSize(820, 655);
              
       }
        else if(f==0)
       {
              l.jProgressBar1.setValue(100);
               
            
             
           l.dispose();
           this.setVisible(true);
           
       jLabel2.setText("Invalid");
       }
        else
        {
              l.jProgressBar1.setValue(100);
         
             
           l.dispose();
           this.setVisible(true);
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel6 = new javax.swing.JLabel();
        list1 = new java.awt.List();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.setLayout(null);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(360, 330, 200, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Student","Admin", "Principal"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(470, 450, 90, 30);

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(260, 450, 190, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Username");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(250, 330, 100, 30);
        jPanel2.add(jPasswordField1);
        jPasswordField1.setBounds(360, 390, 200, 30);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(280, 500, 110, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Password");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(250, 390, 100, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/15003918289975.png"))); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(240, 20, 160, 70);

        jButton2.setText("Sign up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(410, 500, 110, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/3.jpg"))); // NOI18N
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       this.setVisible(false);
        
       Thread Th1 = new Thread(l);
       Thread Th2 = new Thread(this);
      
       l.setVisible(true);
       l.setSize(800, 600);
       Th1.start();
       Th2.start();
      
      
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed


        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          new student_Reg().setVisible(true);
          this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}