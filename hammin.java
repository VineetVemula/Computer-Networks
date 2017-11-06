package cn;
import java.util.*;
import java.math.*;

public class hamming {
	public static int ch;
	public static void main(String x[])
	{
		Scanner t=new Scanner(System.in);
		int data[]=new int[4];
		int send[]=new int[7];
		int rec[]=new int[7];
		System.out.println("Enter the 4 bit data");
		for(int i=0;i<4;i++)
			data[i]=t.nextInt();
		System.out.println("Enter 1 for even parity nd 2 for odd parity");
		ch=t.nextInt();
		send[0]=find(data[0],data[1],data[3]);
		send[1]=find(data[0],data[2],data[3]);
		send[2]=data[0];
		send[3]=find(data[1],data[2],data[3]);
		send[4]=data[1];
		send[5]=data[2];
		send[6]=data[3];
		System.out.println("Senders msg:-\n");
		for(int i=0;i<7;i++)
		{
			System.out.print(send[i]);
			rec[i]=send[i];
		}
		int ran=(int)(Math.random()%7);
		if(rec[ran]==0)
			rec[ran]=1;
		else rec[ran]=0;
		System.out.println("Received msg:-\n");
		for(int i=0;i<7;i++)
		{
			System.out.print(rec[i]);
		}
		int count=7;
		for(int i=0;i<7;i++)
		{
			if(send[i]!=rec[i])
			{
				count=i;
				break;
			}
		}
		int i;
		if(count==7)
			System.out.println("\nNo Error has occured");
		else{
			System.out.println("\nError has occured at "+count);
			if(rec[count]==0)
				rec[count]=1;
			else rec[count]=0;
			System.out.println("\ncorrected msg:-");
			for(i=0;i<7;i++)
				System.out.print(rec[i]);
		}
	}
	public static int find(int a,int b,int c)
	{
		int sum=0;
		sum=a+b+c;
		if(ch==1)
		{
			if(sum%2==0)
				return 0;
			else return 1;
		}
		else
		{
			if(sum%2==0)
				return 1;
			else return 0;
		}
	}

}
