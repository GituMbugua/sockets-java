/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gmbug
 */
public class Sockets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket cs;
            cs = new Socket("localhost", 5000);
            
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number: ");
            int n = Integer.parseInt(input.readLine());
            
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeInt(n);
            
            DataInputStream in = new DataInputStream(cs.getInputStream());
            System.out.println(in.readUTF());
            cs.close();
        } catch (IOException ex) {
            Logger.getLogger(Sockets.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
