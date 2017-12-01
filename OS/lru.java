package os;

import java.util.Scanner;
import java.util.Vector;

public class lru {

	public static void print(int a[])
	{
		System.out.print("[");
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+"\t");
		System.out.println("]");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of pages:");
			int n=sc.nextInt();
			Vector<Integer> v=new Vector<Integer>();
			for(int i=0;i<n;i++)
			{	
				System.out.print("Enter the page "+(i+1)+" :\t");
				v.add(sc.nextInt());
			}
			System.out.println("Enter the frame size");
			int m=sc.nextInt();
			int a[]=new int[m];
			int pf=m;
			boolean fault;
			for(int i=0;i<m;i++)
			{
				a[i]=v.get(i);
				System.out.print("PF\t");
				print(a);
			}
			for(int i=m;i<n;i++)
			{
				int lru=i-m;
				fault = true;
				for(int j=0;j<m;j++)
				{
					if(a[j]==v.get(i))
					{
						fault=false;
						break;
					}
				}
				if(fault)
				{
					pf++;
					int j=0;
					for(;j<m;j++)
					{
						if(a[j]==v.get(lru))
							break;
					}
					a[j]=v.get(i);
					System.out.print("PF\t");
					print(a);
				}
				else
				{
					System.out.print("hit\t");
					print(a);
				}
			}
			System.out.println("Total page faults:\t"+pf+"\n pf ratio:\t"+(pf*1.0/n*100)+" %");
	}
}
