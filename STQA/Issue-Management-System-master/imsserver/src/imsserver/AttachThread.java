package imsserver;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import com.google.gson.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author groot
 */
public class AttachThread extends Thread{
 protected Socket socket;
    public AttachThread(Socket connectedSocket) {
     this.socket = connectedSocket;
    }
     
    public void run() {  
        try{
    DataInputStream din=new DataInputStream(socket.getInputStream()); 
    
    DataOutputStream dout=new DataOutputStream(socket.getOutputStream()); 
   // ObjectOutputStream dot = new ObjectOutputStream(socket.getOutputStream());
   // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
      String str=""; 
                  
      //dout.writeUTF("Bye");
jdbc j = new jdbc();
Connection c = j.getconnection();
 PreparedStatement ps;
 Gson g = new Gson();
 
         while(!str.equals("stop")){  
    str=din.readUTF(); 
    System.out.println("mainlist panel :"+socket.getPort()+" gis: "+socket.getInputStream()+" gos "+socket.getOutputStream());

    System.out.println(socket.getInetAddress()+" says: "+str);
    switch(str)
    {
        case "1":
            
                ArrayList<issue> issuelist=new ArrayList<issue>();
                 
                 String sql = "SELECT * FROM issue";
                 ResultSet rs = j.getaccess(sql);
                 //STEP 5: Extract data from result set
                
        try {
             while(rs.next()){
                    issue i1;
            i1 = new issue(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(8),rs.getString(7));
             issuelist.add(i1);
             }
             
             
            String st = g.toJson(issuelist);
            System.out.println(st);
            
            dout.writeUTF(st);
            System.out.println("Hi");
             
             
        } catch (SQLException ex) {
           Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
       }
            break;
            
        case "2":
            
         String s ="delete from issue where IID=?";
         String iid = din.readUTF();
         
    {
        try {
            ps= c.prepareStatement(s);
            ps.setString(1, iid);
           
            
            ps.executeUpdate();
            
            s ="delete from vote where IID=?";
            ps= c.prepareStatement(s);
            ps.setString(1, iid);
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
         
            break;
            
        case "3":
            String in ="insert into issue values(?,?,?,?,?,?,now(),?)";
         String issu = din.readUTF();
         issue z = g.fromJson(issu,issue.class);
         
        try {
            ps= c.prepareStatement(in);
            ps.setString(1, z.UID);
            ps.setString(2, z.Title);
            ps.setString(3, z.Description);
            ps.setString(4, z.Subject);
            ps.setString(5, z.IID);
            ps.setInt(6, 0);
            ps.setString(7, z.Status);
            
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    
            
            break; 
            
        case "4":
                    ArrayList<vote> v=new ArrayList<vote>();
                 
                 String m = "SELECT * FROM vote";
                 ResultSet r1 = j.getaccess(m);
                 //STEP 5: Extract data from result set
                
        try {
            
             while(r1.next()){
                    vote v1;
            v1 = new vote(r1.getString(2),r1.getString(1));
             v.add(v1);
             }
             
             
            String st = g.toJson(v);
            System.out.println(st);
            
            dout.writeUTF(st);
            System.out.println("Hi");
             
             
        } catch (SQLException ex) {
           Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
       }
            break;
            
        case "5":
         
            int ud = 0;
            try {
                
                int q = 0;
                
                String ra = "select rating from issue where IID=?";
            ps= c.prepareStatement(ra);
            String id = din.readUTF();
            ps.setString(1, id);
            
              
           ResultSet r2 = ps.executeQuery();
           while(r2.next()){
            q = r2.getInt(1);
             }
                System.out.println(q);
           String rate = din.readUTF();
                System.out.println(rate);
           if(  "up".equals(rate))
           {
           q++;
           ud=1;
           }
           else
           {
           q--;  
           ud=-1;
           }
           
           String upd="update issue set rating=? where IID=?";
           ps= c.prepareStatement(upd);
           
            ps.setInt(1,q);
            ps.setString(2, id);
              
           ps.executeUpdate();
          
           
        
       
    } catch (SQLException ex) {
        Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(AttachThread.class.getName());
                }
            
              String ins ="insert into vote values(?,?,?)";
         String vo = din.readUTF();
         vote y = g.fromJson(vo,vote.class);
         
        try {
            ps= c.prepareStatement(ins);
            ps.setString(1, y.IID);
            ps.setString(2, y.UID);
            ps.setInt(3, ud);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        break;
        
        case "6":
            String multiup = "update issue set Subject=?,Title=?,Description=? where IID=?";
            String obj = din.readUTF();
            issue si = g.fromJson(obj, issue.class);
            try {
            ps= c.prepareStatement(multiup);
            ps.setString(1,si.Subject);
            ps.setString(2,si.Title);
            ps.setString(3,si.Description);
            ps.setString(4,si.IID);
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
        }
            break;
            
        case "7":
            String app = "update issue set status='Approved' where IID=?";
            String ii = din.readUTF();
             {
        try {
            ps= c.prepareStatement(app);
            ps.setString(1, ii);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            break;
            
            case "8":
            String sol = "update issue set status='Solved' where IID=?";
            String iii = din.readUTF();
             {
        try {
            ps= c.prepareStatement(sol);
            ps.setString(1, iii);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttachThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            break;
        
            
    }
    
    //str2=br.readLine();  
    //dout.writeUTF(str2);  
    //dout.flush();  
        }
    din.close();  
    socket.close();   
        }
        catch(IOException e){
                System.out.println(socket.getInetAddress()+" says: EXCEPTION"); 
        e.printStackTrace();
        }
    }
}