import java.util.*;

class bs
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of input String");
        int n= sc.nextInt();
        System.out.println("Enter the input String");
        String ip = sc.next();
        char a[] =new char[50];
        ip.getChars(0,ip.length(),a,0);
        int i,c=0,j,m;
        char res[]=new char[50];
        char flag[]= new char[]{'0','1','1','1','1','1','1','0'};
        for(i=0;i<n;i++)
        {
            if(a[i]=='1')
            {
                c++;
            }
            else c=0;

            if(c==5)
            {
                n++;
                c=0;
                for(j=n-1;j>i;j--)
                {
                    a[j+1]=a[j];
                }
                a[i+1]='0';
            }
        }
        System.out.println(" Message will be sent as");
        m=n+16;
        for(i=0;i<8;i++)
        {
          res[i]= flag[i];
        }
        for(j=8,i=0;i<n;j++,i++)
        {
          res[j]=a[i];
        }
        for(i=n+8,j=0;j<8;i++,j++)
        {
          res[i]=flag[j];
        }
        for(i=0;i<n+16;i++)
        {
            System.out.print(res[i]+" ");
        }
        c=0;
        System.out.println("\n Message recieved and decoded as");
        for(i=0;i<n;i++)
        {
            if(a[i]=='1')
            {
                c++;
            }
            else c=0;

            if(c==5)
            {

                c=0;
                for(j=i+1;j<n-1;j++)
                {
                    a[j]=a[j+1];
                }
                n--;
            }
        }
        for(i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}



OUTPUT

Enter the length of input String
7
Enter the input String
1111110
 Message will be sent as
0 1 1 1 1 1 1 0 1 1 1 1 1 0 1 0 0 1 1 1 1 1 1 0 
 Message recieved and decoded as
1 1 1 1 1 1 0 

