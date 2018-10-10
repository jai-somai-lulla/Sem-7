/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author groot
*/

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication19.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LoginSuite {
 
    private jdbc j;
    private Socket soc;
    static JavaApplication19 foo;
    NewJFrame jf;
    @Before
    public void setup()
    {
        //System.out.println("Socket check");      
        try {
            soc=JavaApplication19.getSocket();
        } catch (IOException ex) {
            Logger.getLogger(LoginSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("Jdbc Test Run");
          jdbc j =new jdbc();
          jf=new NewJFrame();
          jf.setsocket(soc);
      
           
    }
    
    //@Test
    public void jdbc ()
    {
          Connection conn=j.getconnection();
        try {
            assertTrue(conn.isValid(10));
        } catch (SQLException ex) {
            Logger.getLogger(LoginSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   //  @Test
   public void testLogin() {
       // System.out.println("Login");      
        
   }
   
 //  @Test
   public void socketcheck() throws IOException {
        assertNotNull(soc);
   }
   
   @Test
   public void testStudent() throws IOException {
      
    //assertNotNull(foo);  // Instantiated?
       //soc=new Socket("localhost",1978); 
      //System.out.println("JUnit Login:");   
      //System.out.println("F:"+f);
      //String str = "Junit is working fine";
      //assertEquals("Junit is working fine",str);
      //new JavaApplication19();
    //  JavaApplication19.main(null);
      
    //jf.jButton1.doClick();
      //jf.run();
      //
      //jButton1.doClick();
      //System.out.println("F:"+f);
      //jf.setdb(j);
     
      //NewJFrame jf=new NewJFrame();
      //jf.setsocket(soc);
      int loginbit=jf.setfields("jai", "admin", 0);
      assertEquals(loginbit, 1);
      //System.out.println("F---->"+loginbit);
   }
   @Test
   public void testadminLogin() throws IOException, InterruptedException { 
     // Thread.sleep(2000);
      int loginbit=jf.setfields("admin", "admin", 1);
      //Thread.sleep(2000);
      assertEquals(loginbit, 1);
   }
   @Test
   public void testPrincipalLogin()  { 
     // Thread.sleep(2000);
      int loginbit=jf.setfields("Mr.P", "supersecret", 2);
      //Thread.sleep(2000);
      assertEquals(loginbit, 1);
   }
   
   @Test
   public void NegativeStudent()  { 
      int loginbit=jf.setfields("Unknownusername", "abc", 0);
      assertEquals(loginbit,0);
   }
   
   @Test
   public void StudentasAdmin()  { 
      int loginbit=jf.setfields("jai", "admin", 1);
      assertEquals(loginbit,2);
   }
   
   @Test
   public void StudentasPrincipal()  { 
      int loginbit=jf.setfields("jai", "admin", 2);
      assertEquals(loginbit,2);
   }
    
}