import java.util.*;

class paritycheck
{
 public static void main(String args[])
 {
  int c=0;
  String res;
  System.out.println("Enter input message");
  Scanner t = new Scanner(System.in);
  String ipm=t.next();
  char msg[]=ipm.toCharArray();
  System.out.println("Sending message to receiver");
  
  for(int i=0;i<msg.length;i++)
  {
   if(msg[i]=='1')
   	c++;
  }
  if(c%2==0)
  {
  	res=ipm.concat("0");
  	System.out.println("Message accepted\n");
  	System.out.println(res);
  }
  else
  {
  	res=ipm.concat("1");
  	System.out.println("Message rejected\n");
  	System.out.println(res);
  }
 }
}
