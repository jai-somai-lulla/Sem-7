/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.awt.CardLayout;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saurabh
 */
public class MainDisplayFrame extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form MainDSaisplayFrame
     * @param uname
     */
    
    String username;
    String type;
    String subject,status,sort;
    Socket soc;
    
    public MainDisplayFrame() {   
       myinit();
       subject="ALL";
       status="ALL";
       sort="Sort by Rating (High to Low)";
       
       CardLayout cardLayout = (CardLayout) base.getLayout();
       cardLayout.show(base,"card2");
       
       jButton2.setVisible(false);
       
       

       
    }
    public void run(){}
  
    void setsocket(Socket soc) throws IOException
    {
    this.soc = soc;
    
        try {
            main_list_panel1.setsocket(soc);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainDisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        admin1.setsocket(soc);
        issue_desc1.setsocket(soc);
        principal1.setsocket(soc);
        user1.setsocket(soc);
        //main_list_panel1.display();
    }
    
    public void display()
    {
    System.out.println(soc.getPort());
    }
    
     public void setuname(String uname)
     {
       username = uname;
     jLabel2.setText(username);
     issue_desc1.setuname(uname);
     admin1.setuname(uname);
     user1.setuname(uname);
     main_list_panel1.setuname(uname);
     
     }
     public void setUserType(String type)
     {
       this.type = type;
         if("Admin".equals(type)){
     CardLayout cardLayout = (CardLayout) MainPanel_base.getLayout();
                  cardLayout.show(MainPanel_base,"card2");
         }
     if(type=="Student"){
     CardLayout cardLayout = (CardLayout) MainPanel_base.getLayout();
                  cardLayout.show(MainPanel_base,"card3");
     }
          if(type=="Principal"){
     CardLayout cardLayout = (CardLayout) MainPanel_base.getLayout();
                  cardLayout.show(MainPanel_base,"card4");
     }
       
     }
     
     
     private void myinit() {

        base = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        MainPanel_base = new javax.swing.JPanel();
        
        main_list_panel1 = new javaapplication19.Main_list_panel();
        
        issue_desc1 = new javaapplication19.issue_desc(base,main_list_panel1);
        
        user1 = new javaapplication19.User(base,issue_desc1,main_list_panel1);
        admin1 = new javaapplication19.admin(base,issue_desc1,main_list_panel1);
        principal1 = new javaapplication19.principal(base,issue_desc1,main_list_panel1);
        
        
        
        
        main_list_panel1.getobjs(principal1, admin1, user1);
        
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        
        subjectcombo = new javax.swing.JComboBox<>();
        statuscombo = new javax.swing.JComboBox<>();
        sortcombo = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
         
        
        issue_desc1.title.setText(type);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        base.setLayout(new java.awt.CardLayout());

        main.setLayout(null);

        MainPanel_base.setLayout(new java.awt.CardLayout());
        MainPanel_base.add(user1, "card3");
        MainPanel_base.add(admin1, "card2");
        MainPanel_base.add(principal1, "card4");
        
        main.add(MainPanel_base);
        MainPanel_base.setBounds(20, 20, 220, 560);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hello,");
        main.add(jLabel1);
        jLabel1.setBounds(570, 20, 70, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        main.add(jLabel2);
        jLabel2.setBounds(630, 20, 110, 40);
        main.add(main_list_panel1);
        main_list_panel1.setBounds(260, 130, 520, 450);

        subjectcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL","ISEE", "SEPM", "DBMS", "TOC"}));
        subjectcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectcomboActionPerformed(evt);
            }
        });
        main.add(subjectcombo);
        subjectcombo.setBounds(580, 80, 110, 30);

        statuscombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "Awaiting approval", "Approved", "Solved"}));
        statuscombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statuscomboActionPerformed(evt);
            }
        });
        main.add(statuscombo);
        statuscombo.setBounds(250, 80, 110, 30);

        sortcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by Rating (High to Low)","Sort by Rating(Low to High)","Sort by Date (High to Low)","Sort by Date (Low to High)"}));
        sortcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortcomboActionPerformed(evt);
            }
        });
        main.add(sortcombo);
        sortcombo.setBounds(380, 80, 170, 30);

        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        main.add(jButton5);
        jButton5.setBounds(430, 30, 110, 30);

        
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/Refresh-square.png"))); // 
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        main.add(jButton1);
       jButton1.setBounds(720, 70, 40, 40);

        jButton2.setText("Apply");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        main.add(jButton2);
        jButton2.setBounds(290, 30, 59, 30);


        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/UserWin - Copy.jpg"))); // NOI18N
        main.add(jLabel3);
        jLabel3.setBounds(0, 0, 820, 610);

        base.add(main, "card2");
        base.add(issue_desc1, "card3");

        getContentPane().add(base);
        base.setBounds(0, 0, 810, 630);

        pack();
        setLocationRelativeTo(null);
    }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        base = new javax.swing.JPanel();
        main = new javax.swing.JPanel();
        MainPanel_base = new javax.swing.JPanel();
        user1 = new javaapplication19.User();
        admin1 = new javaapplication19.admin();
        principal1 = new javaapplication19.principal();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        main_list_panel1 = new javaapplication19.Main_list_panel();
        subjectcombo = new javax.swing.JComboBox<>();
        statuscombo = new javax.swing.JComboBox<>();
        sortcombo = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        issue_desc1 = new javaapplication19.issue_desc();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        base.setLayout(new java.awt.CardLayout());

        main.setLayout(null);

        MainPanel_base.setLayout(new java.awt.CardLayout());
        MainPanel_base.add(user1, "card3");
        MainPanel_base.add(admin1, "card3");
        MainPanel_base.add(principal1, "card4");

        main.add(MainPanel_base);
        MainPanel_base.setBounds(20, 20, 220, 560);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hello,");
        main.add(jLabel1);
        jLabel1.setBounds(570, 20, 70, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        main.add(jLabel2);
        jLabel2.setBounds(630, 20, 110, 40);
        main.add(main_list_panel1);
        main_list_panel1.setBounds(260, 130, 520, 450);

        subjectcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL","ISEE", "SEPM", "DBMS", "TOC"}));
        subjectcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectcomboActionPerformed(evt);
            }
        });
        main.add(subjectcombo);
        subjectcombo.setBounds(580, 80, 110, 30);

        statuscombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "Awaiting approval", "Approved", "Solved"}));
        statuscombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statuscomboActionPerformed(evt);
            }
        });
        main.add(statuscombo);
        statuscombo.setBounds(250, 80, 110, 30);

        sortcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by Rating (High to Low)","Sort by Rating(Low to High)","Sort by Date (High to Low)","Sort by Date (Low to High)"}));
        sortcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortcomboActionPerformed(evt);
            }
        });
        main.add(sortcombo);
        sortcombo.setBounds(380, 80, 170, 30);

        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        main.add(jButton5);
        jButton5.setBounds(430, 30, 110, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/Refresh-square.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        main.add(jButton1);
        jButton1.setBounds(720, 70, 40, 40);

        jButton2.setText("Apply");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        main.add(jButton2);
        jButton2.setBounds(290, 30, 59, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/UserWin - Copy.jpg"))); // NOI18N
        main.add(jLabel3);
        jLabel3.setBounds(0, 0, 820, 610);

        base.add(main, "card2");
        base.add(issue_desc1, "card3");

        getContentPane().add(base);
        base.setBounds(0, 0, 810, 630);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void subjectcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectcomboActionPerformed
        // TODO add your handling code here:
        this.subject=subjectcombo.getSelectedItem().toString();
                main_list_panel1.particulars(status,sort,subject);
                
              
         admin1.edit.setVisible(false);
         admin1.deleteb.setVisible(false);
         admin1.view.setVisible(false);  
         
        
         user1.edit.setVisible(false);
         user1.deleteb.setVisible(false);
         user1.view.setVisible(false);
         
         principal1.approved.setVisible(false);
         principal1.solved.setVisible(true);

    }//GEN-LAST:event_subjectcomboActionPerformed

    private void statuscomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statuscomboActionPerformed
        // TODO add your handling code here:
        this.status=statuscombo.getSelectedItem().toString();
         main_list_panel1.particulars(status,sort,subject);
         
         
         admin1.edit.setVisible(false);
         admin1.deleteb.setVisible(false);
         admin1.view.setVisible(false);
         
          
         user1.edit.setVisible(false);
         user1.deleteb.setVisible(false);
         user1.view.setVisible(false);
         
         principal1.approved.setVisible(false);
         principal1.solved.setVisible(true);

    }//GEN-LAST:event_statuscomboActionPerformed

    private void sortcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortcomboActionPerformed
        // TODO add your handling code here:
        this.sort=sortcombo.getSelectedItem().toString();
                main_list_panel1.particulars(status,sort,subject);
                
         
         admin1.edit.setVisible(false);
         admin1.deleteb.setVisible(false);
         admin1.view.setVisible(false);
         
         
         user1.edit.setVisible(false);
         user1.deleteb.setVisible(false);
         user1.view.setVisible(false);
         
         principal1.approved.setVisible(false);
         principal1.solved.setVisible(true);

    }//GEN-LAST:event_sortcomboActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       //this.setVisible(false);
       this.dispose();
       NewJFrame n = new NewJFrame();
               n.setVisible(true);
                Socket soc;
        try {
            soc = new Socket("localhost",1978);
            n.setsocket(soc);
        } catch (IOException ex) {
            Logger.getLogger(MainDisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new Refresh(main_list_panel1).start();
        
//        try {
//            try {
//                // TODO add your handling code here:
//                main_list_panel1.refresh_list();
//            } catch (IOException ex) {
//                Logger.getLogger(MainDisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MainDisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MainDisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        main_list_panel1.particulars(status,sort,subject);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainDisplayFrame n=new MainDisplayFrame();
                n.setVisible(true);
                n.setSize(810,635);
            }
        });
               
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel_base;
    private javaapplication19.admin admin1;
    public javax.swing.JPanel base;
    private javaapplication19.issue_desc issue_desc1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel main;
    private javaapplication19.Main_list_panel main_list_panel1;
    private javaapplication19.principal principal1;
    private javax.swing.JComboBox<String> sortcombo;
    private javax.swing.JComboBox<String> statuscombo;
    private javax.swing.JComboBox<String> subjectcombo;
    private javaapplication19.User user1;
    // End of variables declaration//GEN-END:variables

 
}
