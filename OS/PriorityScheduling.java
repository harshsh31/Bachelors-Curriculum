package os;

import java.util.Arrays;
import java.util.Scanner;

public class PriorityScheduling implements Comparable<PriorityScheduling>{
	int burst,priority,wait=0,turnaround=0,service=0;
	public PriorityScheduling() 
	{
		
	}
	PriorityScheduling(int a,int b)
	{
		burst=b;
		priority=a;
	}
	public String toString()
	{
		return burst+"\t\t"+priority+"\t\t"+wait+"\t\t"+turnaround;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of processes:\t");
		int n=sc.nextInt();
		PriorityScheduling a[]=new PriorityScheduling[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter priority and burst time of process "+(i+1));
			a[i]=new PriorityScheduling(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(a);
		a[0].turnaround=a[0].wait+a[0].burst;
		for(int i=1;i<n;i++)
		{
			a[i].wait=a[i-1].turnaround;
			a[i].turnaround=a[i].wait+a[i].burst;
		}
		System.out.println("Process\t\tBurst\t\tPrt\t\tWait\t\tTAT");
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
	public int compareTo(PriorityScheduling x)
	{
		if(this.priority==x.priority)
			return 0;
		else if(this.priority>x.priority)
			return -1;
		else
			return +1;
	}
}
