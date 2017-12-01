package hackerrank;

import java.util.Scanner;

public class Subnet 
{
	
	static int val[]=new int[4];
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String ip,c="";
		boolean oor=true;
		System.out.println("Enter IP address");
		ip=sc.next();
		String a[];
		a=ip.split("\\.");	
		if(a.length==4)
			{
			for(int i=0;i<a.length;i++)
			{
				//System.out.println(a[i]);
				val[i]=Integer.parseInt(a[i]);
				//System.out.print(val[i]+"\t");
				if(val[i]>255||val[i]<0)
					{
						System.out.println("Invalid IP");
						
					}
				
			}	
			if(val[0]<=126&&val[0]>=1)
				c="A";
			else if(val[0]<=191&&val[0]>=128)
				c="B";
			else if(val[0]<=223&&val[0]>=192)
				c="C";
			else if(val[0]<=239&&val[0]>=224)
				{
					c="D";
					oor=false;
				}
			else if(val[0]<=255&&val[0]>=240)
				{
					c="E";
					oor=false;
					System.out.println("This class is reserved for future use");
				}
			else if((val[0]==255&&val[1]==255&&val[2]==255&&val[3]==255)||val[0]==0||val[3]==0||val[0]==127)
				{
					c="special";
					oor=false;
				}
			else {
				System.out.println("Out of range");
				oor=false;
			}
			System.out.println("IP address belongs to class:\t" + c);
			if(oor)
			{
				System.out.println("Enter number of more networks required:\t");
				int n=sc.nextInt();
				switch(c)
				{
				case "A": int n_id=8;
					n=(int)Math.ceil((Math.log(n)/Math.log(2)));
					System.out.println(n+" more bits of host id added to network id to make " +(int)Math.pow(2,n) + " subnets");
					n_id+=n;
					int h_id=32-n_id;
					System.out.println("Total bits in network id:\t"+n_id+"\nTotal number of bits in host id:\t"+h_id+"\n therefore range of networks:\t0-"+(int)Math.pow(2,n_id)+"\nThe range of hosts:\t0-"+(int)Math.pow(2,h_id));
					System.out.println("Subnet mask:\t");
					String smask="";
					
					int mod=n_id%8;
					int octets=n_id/8;
					for(int i=0;i<octets;i++)
						smask="255."+smask;
					smask+=(int)((Math.pow(2, mod)-1)*(Math.pow(2,8-mod)))+".";
					for(int i=octets+1;i<4;i++)
						smask+="0.";
					System.out.println(smask);
					break;
				case "B":  n_id=16;
					n=(int)Math.ceil((Math.log(n)/Math.log(2)));
					System.out.println(n+" more bits of host id added to network id to make " +(int)Math.pow(2,n) + " subnets");
					n_id+=n;
					h_id=32-n_id;
					System.out.println("Total bits in network id:\t"+n_id+"\nTotal number of bits in host id:\t"+h_id+"\n therefore range of networks:\t0-"+(int)Math.pow(2,n_id)+"\nThe range of hosts:\t0-"+(int)Math.pow(2,h_id));
					System.out.println("Subnet mask:\t");
					 smask="";
					
					 mod=n_id%8;
					 octets=n_id/8;
					for(int i=0;i<octets;i++)
						smask="255."+smask;
					smask+=(int)((Math.pow(2, mod)-1)*(Math.pow(2,8-mod)))+".";
					for(int i=octets+1;i<4;i++)
						smask+="0.";
					System.out.println(smask);
					break;
				case "C": n_id=24;
					n=(int)Math.ceil((Math.log(n)/Math.log(2)));
					System.out.println(n+" more bits of host id added to network id to make " +(int)Math.pow(2,n) + " subnets");
					n_id+=n;
					h_id=32-n_id;
					System.out.println("Total bits in network id:\t"+n_id+"\nTotal number of bits in host id:\t0-"+h_id+"\n therefore range of networks:\t0-"+(int)Math.pow(2,n_id)+"\nThe range of hosts:\t"+(int)Math.pow(2,h_id));
					System.out.println("Subnet mask:\t");
					 smask="";
					
					 mod=n_id%8;
					 octets=n_id/8;
					for(int i=0;i<octets;i++)
						smask="255."+smask;
					smask+=(int)((Math.pow(2, mod)-1)*(Math.pow(2,8-mod)))+".";
					for(int i=octets+1;i<4;i++)
						smask+="0.";
					System.out.println(smask);
					break;
				default: System.out.println("error");
				}
			}
		}
		else
		{
			System.out.println("Invalid ip address");
		}
	}
}
