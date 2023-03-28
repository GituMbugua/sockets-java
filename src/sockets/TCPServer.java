/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gmbug
 */
public class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket ss;
            ss = new ServerSocket(5000);
            System.out.println("Server started...");
            
            Socket s = ss.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            int x = in.readInt();
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            int y = x/2;
            boolean flag = false;

            for (int i=2; i<=y; i++) {
                if (x % i == 0) {
                    flag = true;
                    break;
                }
            }
            
            if (flag) {
                    out.writeUTF(x + " is not a prime number");
                } else {
                    out.writeUTF(x + " is a prime number");
                }
            
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
