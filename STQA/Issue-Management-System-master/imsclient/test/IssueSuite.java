
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication19.JavaApplication19;
import javaapplication19.Main_list_panel;
import javaapplication19.issue_desc;
import javaapplication19.jdbc;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author groot
 */
public class IssueSuite {
    jdbc j;
    Connection c;
    PreparedStatement ps;
    private Socket soc;


    @Before
    public void setup()
    {
       j= new jdbc();    
       c = j.getconnection();
        try {
            soc=JavaApplication19.getSocket();
        } catch (IOException ex) {
            Logger.getLogger(LoginSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    @Test (timeout=10000)
    public void submitIssue () throws IOException
    {
       
        //JPanel base = new javax.swing.JPanel();
        //JPanel main = new javax.swing.JPanel();
        
      //  Main_list_panel main_list_panel1 = new javaapplication19.Main_list_panel();
        //issue_desc ide = new javaapplication19.issue_desc(base,main_list_panel1);
        issue_desc ide = new issue_desc();
        ide.setsocket(soc);
        int check=ide.setandclick("jai", "AutoGen", "Junit is too-cool", 2,"3144","Approved");
        Assert.assertEquals(check,2);
    }
    
    @Test (timeout=10000)
    public void submitInvaildDesc () throws IOException
    {
        issue_desc ide = new issue_desc();
        ide.setsocket(soc);
        int check=ide.setandclick("jai", "AutoGen", "", 2,"31441","Approved");
        Assert.assertEquals(check,1);
    }
    
    
    @Test (timeout=10000)
    public void submitInvaildTitle () throws IOException
    {
        issue_desc ide = new issue_desc();
        ide.setsocket(soc);
        int check=ide.setandclick("jai", "", "Cool Desc", 2,"31441","Approved");
        Assert.assertEquals(check,1);
    }
    
     @After
   public void teardown() throws SQLException{
       String s ="delete from issue where Title=?";
       ps= c.prepareStatement(s);
       ps.setString(1, "AutoGen");
       ps.executeUpdate();
       //ps.setString(1, "Charles");
       //ps.executeUpdate();
       //ps.setString(1, "Addy");
       //ps.executeUpdate();
   }
}  