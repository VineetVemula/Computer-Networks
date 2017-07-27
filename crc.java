import java.util.*;

class crc
{
	static int xor(int a,int b)
	{
		if(a==b)
			return 0;
		else return 1;
	}
	public static void main(String args[])
	{
		int res[]= new int[4];
		int s=0,e=3,i,j,c=0;
		Scanner sc = new Scanner(System.in);
		int gen[]={1,0,1,1};
		for(i=0;i<4;i++)
		{
			System.out.print(gen[i]+" ");
		}
		int ip[] = new int[50];
		System.out.println("\nEnter the number of input bits");
		int n = sc.nextInt();
		System.out.println("Enter the input bits");
		for(i=0;i<n;i++)
		{
			ip[i]=sc.nextInt();
		}
		for(i=n;i<n+3;i++)
		{
			ip[i]=0;
		}
		System.out.println("\nThe input bits are:");
		for(i=0;i<n+3;i++)
			System.out.print(ip[i]+" ");
		System.out.print("\n ");



			for(i=0;i<4;i++)
			{
				res[i]=ip[i];
			}



		while(e!=n+2)
		{
			for(i=0;i<gen.length;i++)
			{
				res[i]=xor(res[i],gen[i]);
			}

			while(res[0]==0)
			{
				for(i=0;i<3;i++)
				{
					res[i]=res[i+1];
				}
				res[3]=ip[e+1];
				e++;
				s++;
			}
		}
		for(i=0;i<gen.length;i++)
		{
			res[i]=xor(res[i],gen[i]);
		}

		System.out.print("\n res array is\n");
		for(i=0;i<4;i++)
			System.out.print(res[i]+" ");




		if(res[0]!=0)
		{
			for(i=0;i<gen.length;i++)
			{
				res[i]=xor(res[i],gen[i]);
			}
		}
		for(i=1,j=n;i<4;i++,j++)
		{
			ip[j]=res[i];
		}
		System.out.println("\nThe input bits are now:");
		for(i=0;i<n+3;i++)
			System.out.print(ip[i]+" ");
		System.out.print("\nres array is\n");
		for(i=0;i<4;i++)
			System.out.print(res[i]+" ");
		System.out.println("message is sent");

		//System.out.println("s: "+ s+" e: "+e);
		s=0;
		e=3;
		for(i=0;i<4;i++)
		{
			res[i]=ip[i];
		}

		while(e!=n+2)
		{
			for(i=0;i<gen.length;i++)
			{
				res[i]=xor(res[i],gen[i]);
			}

			while(res[0]==0)
			{
				for(i=0;i<3;i++)
				{
					res[i]=res[i+1];
				}
				res[3]=ip[e+1];
				e++;
				s++;
			}
		}
		for(i=0;i<gen.length;i++)
		{
			res[i]=xor(res[i],gen[i]);
		}
		
		System.out.print("\nres array is\n");
		for(i=0;i<4;i++)
			System.out.print(res[i]+" ");

		for(i=1;i<4;i++)
		{
			if(res[i]==1)
				c++;
		}
		if(c==0)
			System.out.println("Recieved message is accepted");
	}
}

OUTPUT-------
1 0 1 1 
Enter the number of input bits
4
Enter the input bits
1 1 1 1

The input bits are:
1 1 1 1 0 0 0 
 
 res array is
0 1 1 1 
The input bits are now:
1 1 1 1 1 1 1 
res array is
0 1 1 1 message is sent

res array is
0 0 0 0 Recieved message is accepted
