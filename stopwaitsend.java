/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwaitsend;

/**
 *
 * @author pshkr
 */
import java.net.*;
import java.io.*;

public class StopWaitSend {
    public static void main(String args[]) throws Exception
    {
       StopWaitSend sws=new StopWaitSend();
       sws.run();
    }
    public void run() throws Exception
    {
        Socket s=new Socket("localhost",9999);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout  = new DataOutputStream(s.getOutputStream());
        String msg="";
        for(int i=0;i<=10;)
        {
            if(i==10)
            {
                dout.writeUTF("exit");
                break;
            }
            System.out.println("sending frame "+i);
            dout.writeUTF(String.valueOf(i));
            String rec=din.readUTF();
            if(rec!=null)
            {
                System.out.println("Acknowledgemen received for frame "+i);
                i++;
                Thread.sleep(2000);
            }
            else
            {
                dout.writeUTF(String.valueOf(i));
            }
        }
        
    
    }
    
}
