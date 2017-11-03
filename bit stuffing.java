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
        int i,c=0,j;
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
        for(i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
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
