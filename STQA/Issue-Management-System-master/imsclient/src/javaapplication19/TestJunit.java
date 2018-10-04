/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

/**
 *
 * @author groot
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestJunit {
   @Test
   public void testAdd() {
       
         // System.out.println("JUnit:");
      String str = "Junit is working fine";
     // assertEquals("Junit is working fine",str);
   }
   
   public void testJDBC() {
       try {
          System.out.println("Jdbc:");
           jdbc j =new jdbc();
           Connection conn=j.getconnection();
           assertTrue(conn.isValid(10));
       } catch (SQLException ex) {
           Logger.getLogger(TestJunit.class.getName()).log(Level.SEVERE, null, ex);
       }  
   }
   @Test
   public void testLogin() {
      //  NewJFrame n = new NewJFrame();
        //new JavaApplication19();
   }
     
}