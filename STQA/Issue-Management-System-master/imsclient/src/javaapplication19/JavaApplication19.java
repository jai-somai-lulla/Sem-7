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
    
    public JavaApplication19() throws IOException {
        main(null);
    }

    public static Socket getSocket() throws IOException{
        Socket soc=new Socket("localhost",1978);
        return soc;
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket soc=getSocket();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("RUNNUNG J19");
                NewJFrame n = new NewJFrame();
                System.out.println("HERE");
                System.out.println(soc.getPort());
                n.setsocket(soc);
                //n.display();
                n.setVisible(true);
                n.setSize(810,635);
            }
        });
    }
    
}
