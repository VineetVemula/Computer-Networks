/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwaitreceiver;

/**
 *
 * @author pshkr
 */
import java.net.*;
import java.io.*;
import java.util.*;

 
public class Stopwaitreceiver{
    public static void main(String args[]) throws Exception
    {
        Stopwaitreceiver swr=new Stopwaitreceiver();
        swr.run();
    }
    
public void run() throws Exception
{
    ServerSocket ss=new ServerSocket(9999);
    Socket s=ss.accept();
    DataInputStream din= new DataInputStream(s.getInputStream());
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    while(true)
    {
        String msg=din.readUTF();
        if(msg.equals("exit")==true)
            break;
        System.out.println("frame "+msg+" was received");
        dout.writeUTF("received");
        
    }
    System.out.println("All Fames Received");
}
}
