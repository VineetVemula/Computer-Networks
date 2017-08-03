import java.util.*;

class ip
{
    public static void main (String args[])
    {
        int i,dec=-1,j=0,l,c=0;
        String dfm;
        int p[]= new int[4];
        Arrays.fill(p, -1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP address");
        String ip=sc.next();
        char a[]= new char[15];
        ip.getChars(0,ip.length(),a,0);
        for(i=0;i<ip.length();i++)
        {
            if(a[i]=='.')
            {
                p[j]=dec;
                j++;
                dec=-1;
                continue;
            }
            l=Character.getNumericValue(a[i]);
            if(l!=-1)
            {
                if(dec==-1)
                  dec=0;
                dec= dec*10 + l;
            }
            else
            {
              break;
            }
            if(i==ip.length()-1)
            {
                p[j]=dec;
                j++;
            }
        }
        for(i=0;i<4;i++)
        {
            if(p[i]>=0 && p[i]<=255)
                c++;
        }
        if(c==4)
        {
            System.out.println("The entered IP adress is valid");

        if(p[0]<=127)
        {
            System.out.println("The IP adress belongs to class A");
            dfm=("255.0.0.0");
            System.out.println("The default mask is "+ dfm);
            System.out.println("fisrt ip is "+p[0]+".0.0.0");
            System.out.println("last ip is "+p[0]+".255.255.255");
        }
        else if(p[0]<=191)
        {
            System.out.println("The IP adress belongs to class B");
            dfm=("255.255.0.0");
            System.out.println("The default mask is "+ dfm);
            System.out.println("first ip is "+p[0]+"."+p[1]+".0.0");
            System.out.println("last ip is "+p[0]+"."+p[1]+".255.255");
        }
        else if(p[0]<=223)
        {
            System.out.println("The IP adress belongs to class C");
            dfm=("255.255.255.0");
            System.out.println("The default mask is "+ dfm);
            System.out.println("first ip is "+p[0]+"."+p[1]+"."+p[2]+".0");
            System.out.println("last ip is "+p[0]+"."+p[1]+"."+p[2]+".255");
        }
        else if(p[0]<=239)
        {
            System.out.println("The IP adress belongs to class D");
        }
        else
        {
            System.out.println("The IP adress belongs to class E");
        }
        }
        else System.out.println("The entered IP adress is not valid");
    }
}

OUTPUT-----------------

 Enter IP address
132.34.45.145
The entered IP adress is valid
The IP adress belongs to class B
The default mask is 255.255.0.0
first ip is 132.34.0.0
last ip is 132.34.255.255
