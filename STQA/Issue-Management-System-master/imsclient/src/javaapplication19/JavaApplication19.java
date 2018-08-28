/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Saurabh
 */
public class JavaApplication19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
            Socket soc=new Socket("localhost",1978); 
            
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame n = new NewJFrame();
                System.out.println(soc.getPort());
                n.setsocket(soc);
                //n.display();
                n.setVisible(true);
                n.setSize(810,635);
            }
        });
               
    }
    
}
