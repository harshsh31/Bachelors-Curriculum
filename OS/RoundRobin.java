package os;

import java.awt.Container;
import java.awt.Graphics;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;

public class RoundRobin
{
	int burst,tat=0,wait=0,burst_left,departure=0,index;
	boolean flag=true;
	public static int avgtat,avgwait,sum=0,quantum;
	
	public RoundRobin(int b,int i) {
		// TODO Auto-generated constructor stub
		burst_left=burst=b;
		index=i;
	}
	
	public String toString()
	{
		return "P"+index+"\t"+burst+"\t"+wait+"\t"+tat;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of processes: ");
		int n=sc.nextInt();
		RoundRobin a[]=new RoundRobin[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the burst time for process "+(i+1));
			a[i]=new RoundRobin(sc.nextInt(),i);
		}
		System.out.println("Enter quantum time slice: ");
		quantum=sc.nextInt();
		int c=n;
		Vector<gc> v=new Vector<gc>();
		while(c>0)
		{
			for(int i=0;i<n;i++)
			{	
				if(a[i].flag)
				{
					a[i].wait=sum-a[i].departure;
					if(a[i].burst_left<=quantum)
					{
						sum+=a[i].burst_left;
						v.add(new gc(sum-a[i].burst_left,a[i].burst_left,a[i].index));
						c--;
						a[i].burst_left=0;
						a[i].flag=false;
					}
					else
					{
						sum+=quantum;
						v.add(new gc(sum-quantum,quantum,a[i].index));
					}
					a[i].departure=sum;
				}
			}
		}
		for(int i=0;i<n;i++)
		{	
			a[i].tat=a[i].wait+a[i].burst;
			avgtat+=a[i].tat;
			avgwait+=a[i].wait;
			System.out.println(a[i]);
		}
	}
}

class gc
{
	int index,arrival,execution;
	public gc(int i,int a,int e) {
		// TODO Auto-generated constructor stub
		index=i;
		arrival=a;
		execution=e;
	}
	int getA()
	{
		return  arrival;
	}
	int getE()
	{
		return  execution;
	}
	int getI()
	{
		return  index;
	}
}

class Chart extends JFrame
{
	Vector<gc> v;
	public Chart(Vector v1) {
		// TODO Auto-generated constructor stub
		super("Chart");
		v=v1;
		Container con=getContentPane();
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
}