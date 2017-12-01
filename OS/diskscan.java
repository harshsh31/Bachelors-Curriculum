package os;

import java.util.Arrays;
import java.util.Scanner;

public class diskscan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the locactions to visit: ");
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the "+(i+1)+" location: ");
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+"\t");
		System.out.println();
		System.out.println("Enter current locatiton: ");
		int totalhead=0,i,curr=sc.nextInt();
		for(i=0;curr>a[i];i++);
		System.out.println("Enter 1]scan   2]c-scan");
		//System.out.println(i);
		switch(sc.nextInt())
		{		
		case 1:	if(i==0)
				{
					int current=curr;
					for(int j=0;j<n;j++)
					{
						System.out.println("moving to location "+a[j]);
						totalhead+=Math.abs(a[j]-current);
						current=a[j];
					}
				}
				else
				{
					int current =curr;
					for(int j=i-1;j>=0;j--)
					{
						System.out.println("moving to location "+a[j]);
						totalhead+=Math.abs(a[j]-current);
						current=a[j];
					}
					for(int j=i;j<n;j++)
					{
						System.out.println("moving to location "+a[j]);
						totalhead+=Math.abs(a[j]-current);
						current=a[j];
					}
				}
		System.out.println("Total head movement: "+totalhead);
			break;
		case 2:
			break;
		}
	}

}
