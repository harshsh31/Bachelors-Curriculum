package os;

import java.util.Arrays;
import java.util.Scanner;

public class fifs implements Comparable<fifs>{
	int burst,arrival,wait=0,turnaround=0,service=0;
	public fifs() 
	{
		
	}
	fifs(int a,int b)
	{
		burst=b;
		arrival=a;
	}
	public String toString()
	{
		return arrival+"\t\t"+burst+"\t\t"+wait+"\t\t"+turnaround+"\t\t"+service;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of processes:\t");
		int n=sc.nextInt();
		fifs a[]=new fifs[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter arrival and burst time of process "+(i+1));
			a[i]=new fifs(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(a);
		a[0].turnaround=a[0].wait+a[0].burst;
		for(int i=1;i<n;i++)
		{
			a[i].service+=a[i-1].service+a[i-1].burst;
			a[i].wait=a[i].service-a[i].arrival;
			a[i].turnaround=a[i].wait+a[i].burst;
		}
		System.out.println("Process\t\tArrival\t\tBurst\t\tWait\t\tTAT\t\tService");
		int avgw=0,avgt=0;
		for(int i=0;i<n;i++)
			{
				avgw+=a[i].wait;
				avgt+=a[i].turnaround;
				System.out.println("P"+i+"\t\t"+a[i]);
			}
		System.out.println("Average TurnAround:\t"+(avgt*1.0/n)+"\nAverage Wait:\t"+(avgw*1.0/n));
	}
	@Override
	public int compareTo(fifs x)
	{
		if(this.arrival==x.arrival)
			return 0;
		else if(this.arrival>x.arrival)
			return 1;
		else
			return -1;
	}
}
