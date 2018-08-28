/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
        /**
 *
 * @author Saurabh
 */
public class jdbc {

   
          String url="jdbc:mysql://localhost/issue_management";
//          String user="issue";
//          String pass="qwerty12";
          String user="root";
          String pass="";
          String d = "com.mysql.jdbc.Driver";
          Connection c;
          Statement s;
          ResultSet r;
          
     public ResultSet getaccess(String q)
    {
        try {
            Class.forName(d); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        try {
            c = DriverManager.getConnection(url, user, pass);
            s= c.createStatement();
            
           // String q ="select * from table1";
          
           
                       r = s.executeQuery(q);

        } catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
        return r;
    } 
     
     public Connection getconnection()
     {
     
           try {
            Class.forName(d); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        try {
            c = DriverManager.getConnection(url, user, pass);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
        
     }
     
     
     public void closecon() throws SQLException
     {
      c.close();
     }
    
    
}
