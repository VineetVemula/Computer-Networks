import java.io.*;
class subnett
{
public static void main(String ar[])throws Exception
{
String inputip;
int subnet;
int sub[];
sub = new int[4];
sub[0]=255;
int oc[]=new int[4];
int first[]=new int[4];
int last[]=new int[4];
int defm[]=new int[4];
int i,cls=0, j,temp=0;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter ip address");
inputip=br.readLine();
String[] octs=inputip.split("\\.");
for(i=0;i<4;i++)
{
oc[i]=Integer.parseInt(octs[i]);
defm[i]=0;
}		
if(oc[0]>=0 && oc[0]<=127)
{
if(oc[1]==0 && oc[2]==0 && oc[3]==1)
System.out.println("Loopback Address");
else
{
System.out.println("Class A");
cls=1;
}
}
else if(oc[0]>=128 && oc[0]<=191)
{
System.out.println("Class B");
cls=2;
}
else if(oc[0]>=192 && oc[0]<=223)
{
System.out.println("Class C");
cls=3;
}
System.out.println("Enter no. of bits usable for subnets: ");
subnet = Integer.parseInt(br.readLine());
switch(cls)
{
case 1:
first[0]=oc[0];
last[0]=oc[0];
for(i=1;i<4;i++)
{
first[i]=0;
last[i]=255;
}
if(subnet < 8)
{
for(j = 0; j<subnet; j++)
temp = (int) (temp + Math.pow(2,7-j));
sub[1]=temp;
}			
else if(7 < subnet && subnet < 16)
{
for(j = 0; j<(subnet-8); j++)
temp = (int) (temp + Math.pow(2,7-j));
sub[1]=255;
sub[2]=temp;
}
else if(15 < subnet && subnet < 24)
{
for(j = 0; j<(subnet-16); j++)
temp = (int) (temp + Math.pow(2,7-j));
sub[1]=255;
sub[2]=255;
sub[3]=temp;
}
else
System.out.println("Subnetting not possible");
break;
case 2:
for(i=0;i<2;i++)
{
first[i]=oc[i];
last[i]=oc[i];
}
for(i=2;i<4;i++)
{
first[i]=0;
last[i]=255;
}
sub[1]=255;
if(subnet < 8)
{
for(j = 0; j<subnet; j++)
temp = (int) (temp + Math.pow(2,7-j));
sub[2]=temp;
}			
else if(7 < subnet && subnet < 16)
{
for(j = 0; j<(subnet-8); j++)
temp = (int) (temp + Math.pow(2,7-j));
sub[2]=255;
sub[3]=temp;
}
else
System.out.println("Subnetting not possible");
break;
case 3:
for(i=0;i<3;i++)
{
first[i]=oc[i];
last[i]=oc[i];
}
first[3]=0;
last[3]=255;
sub[1]=255;
sub[2]=255;
if(0 <= subnet && subnet < 8) 
{
for(j = 0; j<subnet; j++)
temp = (int) (temp + Math.pow(2,7-j));
sub[3]=temp;
} 
else System.out.println("Subnetting not possible");
break;
}
for(i=0;i<cls;i++)
defm[i]=255;
if(cls!=0)
{
System.out.print("First IP:");
System.out.println(first[0]+"."+first[1]+"."+first[2]+"."+first[3]);
System.out.print("Last IP:");
System.out.println(last[0]+"."+last[1]+"."+last[2]+"."+last[3]);
System.out.print("Default Mask:");
System.out.println(defm[0]+"."+defm[1]+"."+defm[2]+"."+defm[3]);
System.out.println("Subnet Mask: "+sub[0]+"."+sub[1]+"."+sub[2]+"."+sub[3]);
}
else
System.out.println("Class D and Class E IP Addresses are for future purpose");
}	
}
