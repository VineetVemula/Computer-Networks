package cn;
import java.util.*;
import java.math.*;
public class parity {
	public static void main(String x[])
	{
		Scanner t=new Scanner(System.in);
		System.out.println("Enter the number of bits in the msg including parity bit\n");
		int n=t.nextInt();
		int send[]=new int[n];
		int recd[]=new int[n];
		System.out.println("Enter the bits in the msg");
		for(int i=0;i<n-1;i++)
			send[i]=t.nextInt();
		int count=0;
		System.out.println("Enter 1 for even parity and 2 for odd parity");
		int ch=t.nextInt();
		for(int i=0;i<n-1;i++)
			if(send[i]==1)
				count++;
		switch(ch)
		{
			case 1:
			{
				if(count%2==0)
					send[n-1]=0;
				else send[n-1]=1;
			}
			break;
			case 2:
			{
				if(count%2==0)
					send[n-1]=1;
				else send[n-1]=0;
			}
			break;
		}
		System.out.println("Sender ka msg:-\n");
		for(int i=0;i<n;i++)
		{
			System.out.print(send[i]);
			recd[i]=send[i];
		}
		int ran=(int)Math.random()%n;
		if(recd[ran]==0)
			recd[ran]=1;
		else recd[ran]=0;
		System.out.println("Receiver ka msg:-\n");
		for(int i=0;i<n;i++)
		{
			System.out.print(recd[i]);
		}
		count=0;
		for(int i=0;i<n;i++)
		{
			if(recd[i]==1)
				count++;
		}
		switch(ch)
		{
			case 1:
			{
				if(count%2==0)
					System.out.println("no error\n");
				else 
					System.out.println("error\n");
			}
			break;
			case 2:
			{
				if(count%2==0)
					System.out.println("error\n");
				else 
					System.out.println("no error\n");
			}
			break;
		}
	}
}
