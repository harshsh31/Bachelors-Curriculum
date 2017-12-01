package os;

import java.util.Random;
import java.util.Scanner;

public class DiningPhilosopher {
	static int chopsticks[];
	static boolean eating[];
	public static void print()
	{
		for(int i=0;i<chopsticks.length;i++)
		{
			if(eating[i])
				System.out.println("Philosopher "+(i+1)+" is eating");
			else
				System.out.println("Philosopher "+(i+1)+" is thinking");
		}
	}
	
	public static void stop()
	{
		//randomly philosophers stop eating
		Random r=new Random();
		for(int i=count();i>=1;)
		{
			int a=r.nextInt(chopsticks.length);
			if(eating[a])
			{
				System.out.println("Philosopher "+(a+1)+" stops eating");
				eating[a]=false;
				chopsticks[a]=chopsticks[(a+1)%chopsticks.length]=1;
				i--;
				/*try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		}
	}
	
	public static int count()
	{
		int i=0;
		for(int j=0;j<eating.length;j++)
		{
			if(eating[j])
			{
				i++;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of philosophers: ");
			int n=sc.nextInt();
			chopsticks=new int[n];
			eating=new boolean[n];
			for(int i=0;i<n;i++)
			{
				chopsticks[i]=1;
				//1 is for available
				eating[i]=false;
				//all philosophers are thinking
			}
			for(int i=0;i<n;i++)
			{
				Random r=new Random();
				for(int j=count();j<n/2;)
				{
					int a=r.nextInt(n);
					System.out.println(a);
					if(!eating[a])
					{
						System.out.print("Philosopher "+(a+1)+" wants to eat");
						if(chopsticks[a]==1&&chopsticks[(a+1)%n]==1)
							{
								System.out.println(" and he starts eating");
								chopsticks[a]=0;
								chopsticks[(a+1)%n]=0;
								eating[a]=true;
								j++;
							}
						else{
								System.out.println(" but he cant eat so he waits ");
							}
					}
					
				try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
				print();
				System.out.println("---------------------------------------------------------------------------------------");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			stop();
			}
	}
}
