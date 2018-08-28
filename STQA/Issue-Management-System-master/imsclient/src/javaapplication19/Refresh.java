/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author COMP2
 */
public class Refresh extends Thread{
    Main_list_panel panel;
    public Refresh() {
    }

    public Refresh(Main_list_panel panel){
    this.panel=panel;    
    }
   public void  run(){
        
      
   
        
            //     while(true){
//     System.out.println("Refreshed From DataBase");
//         try {
//             panel.refresh_list();
//         } catch (ClassNotFoundException ex) {
//             Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (SQLException ex) {
//             Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (IOException ex) {
//             Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         try {
//             Thread.sleep(1000);
//         } catch (InterruptedException ex) {
//             Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }
try {
    
while(true){
panel.refresh_list();
Thread.sleep(5000);
}

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Refresh.class.getName()).log(Level.SEVERE, null, ex);
        }

   
}
}
