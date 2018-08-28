/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Saurabh
 */
public class Imsserver {

    /**
     * @param args the command line arguments
     */
    static final int PORT = 1978;
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        System.out.println("SERVER MACHINE");
        ServerSocket serverSocket = null;
        Socket socket = null;
        serverSocket = new ServerSocket(PORT);
        while (true) {
             socket = serverSocket.accept();
             
              System.out.println(socket.getInetAddress()+"Requested new thread Creation");
              new AttachThread(socket).start();
        }
    }
    
}
