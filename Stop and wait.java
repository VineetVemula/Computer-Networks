swsend.java

package cn;
import java.io.*;
import java.net.*;
import java.util.*;
public class swsend {
	public static void main(String x[])throws Exception
	{
		swsend sw=new swsend();
		sw.run();
	}
	public void run()throws Exception
	{
		Scanner t=new Scanner(System.in);
		Socket s = new Socket("localhost",3000);
		System.out.println("enter no of frames to be sent");
		int n=t.nextInt();
		PrintStream ps=new PrintStream(s.getOutputStream());
		int i;
		for(i=0;i<=n;)
		{
			if(i==n)
			{
				ps.println("exit");
				break;
			}
			System.out.println("frame "+i+"is sent");
			ps.println(i);
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String ack=br.readLine();
			if(ack!=null)
			{
				System.out.println("Acknowlegdement received");
				i++;
				Thread.sleep(4000);
			}
			else
				ps.println(i);
		}
	}
}


swrec.java

package cn;
import java.io.*;
import java.net.*;
public class swrec {
	public static void main(String x[])throws Exception
	{
		swsend sw=new swsend();
		sw.run();
	}
	public void run()throws Exception
	{
		String temp="any",str="exit";
		ServerSocket ss=new ServerSocket(3000);
		Socket s=ss.accept();
		PrintStream ps=new PrintStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		while(temp.compareTo(str)!=0)
		{
			Thread.sleep(1000);
			temp=br.readLine();
			if(temp.compareTo(str)==0)
			{
				break;
			}
			System.out.println("frame "+temp+"received");
			ps.println("received");
		}
		System.out.println("ALL FRAMES RECEIVED");
	}
}
