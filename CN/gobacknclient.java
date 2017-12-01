package cn;


import java.util.Scanner;

public class gobacknclient {
	public static void main(String main[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of frames:\t");
        int n=sc.nextInt();
        boolean flag=true;
        System.out.println("Enter window size\t");
        int m=sc.nextInt();
        if(m>n-1)
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
        	System.out.println("SN = "+sn+" SR = "+sr);
    		System.out.println("\nEnter receiver state option for " + sn + " :\t1]data received properly.\t2]data lost.\t3]ack lost.\t");
        	int option=sc.nextInt();
        	System.out.println("Current Sender Window :");
        	for(int i=sr;i<sr+m;i++)
        	{
        		System.out.print(i+" ");
        	}
        	System.out.println();
        	System.out.println("Current Receiver Window :");
        	System.out.println(j);
			System.out.println("Sending data "+sn/*+"\tdata: "+frames[sn]*/);
		        	
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
		      
		    switch(option)
		    {
		    case 1:
		    	sn=(sn+1)%n;
		    	if(flag)	
		    	{
		    		System.out.println("\nData "+ j +" properly received receiver sending acknowledgement");
		    		int ack=j;
		    		j=(j+1)%n;
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
			    	
			    	System.out.println("\nAck "+ ack +" received");
			    	c++;
			    	sr=sn;
			    	
			    	
		    	}
		    	if(sn-sr==-1)
	    		{
		    		
	    			sn=sr;
	    			System.out.println("\nRetransmitting data window ");
	    			flag=true;
	    		}
		    	break;
		    case 2:
		    	System.out.println("\nData lost "+sn);
		    	sn=(sn+1)%n;
		    	flag=false;
		    	break;
		    case 3:	System.out.println("\nData "+ j +" properly receiver sending acknowledgement");
		    	int ack=j;
		    	j=(j+1)%n;
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
		    	c++;
		    	System.out.println("\nAck "+ ack +" lost");
		    	sn=(sn+1)%n;
		    	break;
		    case 4:
		    	break;
		    default: System.out.println("Incorrect option selected");
		    
		    }	
        }
	}
}
