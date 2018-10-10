
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication19.JavaApplication19;
import javaapplication19.NewJFrame;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author groot
 */
import javaapplication19.*;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SignupSuite {
    jdbc j;
    Connection c;
    PreparedStatement ps;

    @Before
    public void setup()
    {
       j= new jdbc();    
       c = j.getconnection();
        
    }
    
    @Test (timeout=10000)
    public void SignupStudent ()
    {
     student_Reg s=new student_Reg();
     int signedup=s.setandclick("SmartStudent", "2", "2", "2",  0, "passw", "passw");
        assertEquals(signedup, 2);
    }
    
    @Test (timeout=10000)
    public void SignupAdmin ()
    {
     student_Reg s=new student_Reg();
     int signedup=s.setandclick("Addy", "2", "2", "2",  1, "passw", "passw");
        assertEquals(signedup, 2);
    }
    
    @Test (timeout=10000)
    public void SignupPrincipal ()
    {
     student_Reg s=new student_Reg();
     int signedup=s.setandclick("Charles", "2", "2", "2",  2, "passw", "passw");
        assertEquals(signedup, 2);
    }
    
    
    @Test (timeout=10000)
    public void SignupInvalid ()
    {
     student_Reg s=new student_Reg();
     int signedup=s.setandclick("Charles", "2", "2", "2",  2, "passaaw", "nomatch");
        assertEquals(signedup, 0);
    }
    
     @Test (timeout=10000)
    public void SignupInvalidName ()
    {
     student_Reg s=new student_Reg();
     int signedup=s.setandclick("", "2", "2", "2",  2, "passaaw", "nomatch");
        assertEquals(signedup, 0);
    }
   @After
   public void teardown() throws SQLException{
       String s ="delete from login where uname=?";
       ps= c.prepareStatement(s);
       ps.setString(1, "SmartStudent");
       ps.executeUpdate();
       ps.setString(1, "Charles");
       ps.executeUpdate();
       ps.setString(1, "Addy");
       ps.executeUpdate();
   }
}