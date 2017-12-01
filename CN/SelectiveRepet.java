package cn;


import java.util.Scanner;

public class SelectiveRepet {
	public static void main(String main[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of frames:\t");
        int n=sc.nextInt();
       // boolean flag=true;
        boolean f[]=new boolean[n],f1[]=new boolean[n];
        System.out.println("Enter window size\t");
        int m=sc.nextInt();
        if(m>(int)Math.pow(2,(int)Math.ceil(Math.log(n)/Math.log(2))-1))
        {
        	System.out.println("Invalid window size re-enter size of window:\t");
        	m=sc.nextInt();
        }
        String frames[]=new String[n];
        for(int i=0;i<n;i++)
        {
        	System.out.print("Enter data for frame "+(i+1)+":\t");
        	frames[i]=sc.next();
        }	
        //sr is the start of window
        //sn is the offset
        int sn,sr,j,c=0;
        sn=sr=j=0;
        while(c<frames.length)
        {
        	
        	System.out.println("\nEnter receiver state option for " + sn + " :\t1]data received properly.\t2]data lost.\t3]ack lost.\t4]error in data");
        	int option =sc.nextInt();
        	System.out.println("sn: "+sn+"\tsr: "+sr);
        	System.out.println("Current Sender window:\t");
        	for(int a=0,i=sr;a<m;a++)
        	{
        		System.out.print(i+"\t");
        		i=(i+1)%n;
        	}
        	System.out.println();
        	System.out.println("Current Receiver window:\t");
        	for(int a=0,i=j;a<m;a++)
        	{
        		System.out.print(i+"\t");
        		i=(i+1)%n;
        	}
        	System.out.println();
        	
        	 if(Math.abs(sn-sr)<m)
        	 {
        		 System.out.println("Sending data "+sn+"\tdata: "+frames[sn]);
         		for(int k=0;k<10;k++)
	        	{
	        		System.out.print("...\t");
	        		try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        	System.out.println();
        	 }
        	switch(option)
        	{
        	case 1: if(Math.abs(sn-sr)<m)
        			{	
        						System.out.println("Data received properly sending ack:");
					        	for(int k=0;k<10;k++)
					        	{
					        		System.out.print("...\t");
					        		try {
										Thread.sleep(50);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					        	}
					        	System.out.println();
					        	int ack=sn;
					        	if(sr==j&&!f[sr])
					        	{
					        		sr=(sr+1)%n;
					        		j=(j+1)%n;
					        	}
					        	sn=(sn+1)%n;
					        	System.out.println("Received acknowledgement "+ack);
					        	c++;
					        	f1[ack]=true;
			        		
        			}
        	else
        	{
        		for(int k=sr,count=0;count<m;count++)
        		{
        			if(!f1[k])
        			{
        				
           			 System.out.println("Resending data "+k+" for no ack\tdata: "+frames[k]);
    	         		for(int l=0;l<10;l++)
    		        	{
    		        		System.out.print("...\t");
    		        		try {
    							Thread.sleep(50);
    						} catch (InterruptedException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    		        	}
    		        	System.out.println();
    		        	System.out.println("Data already received");
           			/*	c++;
           	*/
        			}
        			else
		        			{
		        				if(!f[k])
		        				k=(k+1)%n;
		        			else
		        			{
		        				 System.out.println("Resending data "+k+" for negative ack\tdata: "+frames[k]);
		        	         		for(int l=0;l<10;l++)
		        		        	{
		        		        		System.out.print("...\t");
		        		        		try {
		        							Thread.sleep(50);
		        						} catch (InterruptedException e) {
		        							// TODO Auto-generated catch block
		        							e.printStackTrace();
		        						}
		        		        	}
		        		        	System.out.println();
		        		        	System.out.println("Data received properly sending ack:");
						        	for(int l=0;l<10;l++)
						        	{
						        		System.out.print("...\t");
						        		try {
											Thread.sleep(50);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						        	}
						        	System.out.println();
		        		        	System.out.println("Received acknowledgement "+k);
		        		        	k=(k+1)%n;
		        		        	/*f1[k]=true;
		        		        	*/
		        	       	}
		        		}	
        				c++;
		        		j=sr=sn;
        		        
        		}
        	}
        		break;
        	case 2: System.out.println("Data lost");
        			f[sn]=true;
        			System.out.println("Sending negative ack "+sn);
        			sn=(sn+1)%n;
        		break;
        	case 3:System.out.println("Ack lost for "+sn);
				f1[sn]=true;
				f[sn]=true;
				sn=(sn+1)%n;
        		break;
        	case 4:
        		break;
        		default:System.out.println("Invalid option selected");
        	}
        	
        }
	}
}
