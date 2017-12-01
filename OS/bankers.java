package os;

import java.util.Scanner;

public class bankers {

	static  int need[][];
	static int available[];
	static  int allocated[][];
	 static int max[][];
	
	 public static void print()
	 {
		 System.out.println("\nmax matrix\n");
			for (int i=0;i<max.length;i++)
		 {
			 for(int j=0;j<available.length;j++)
				 System.out.print(max[i][j]+"\t");
			 System.out.println();
		 }
		 System.out.println("\nallocated matrix\n");
			for (int i=0;i<max.length;i++)
		 {
			 for(int j=0;j<available.length;j++)
				 System.out.print(allocated[i][j]+"\t");
			 System.out.println();
		 }
		 System.out.println("\nneed matrix\n");
			
		 for (int i=0;i<max.length;i++)
		 {
			 for(int j=0;j<available.length;j++)
				 System.out.print(need[i][j]+"\t");
			 System.out.println();
		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of resources:");
		int n=sc.nextInt();
		System.out.println("Enter the number of processes");
		int m=sc.nextInt();
		System.out.println("Enter the available matrix");
		available=new int[n];
		for(int i=0;i<n;i++)
		{
			available[i]=sc.nextInt();
		}
	 	need=new int[m][n];
		allocated=new int[m][n];
		max=new int[m][n];
		System.out.println("Enter the max matrix");
		for(int i=0;i<m;i++)
		{
			max[i]=new int [n];
			for (int j=0;j<n ;j++)
			{
				max[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the allocated matrix");
		for(int i=0;i<m;i++)
		{
			allocated[i]=new int [n];
			need[i]=new int[n];
			for (int j=0;j<n ;j++)
			{
				allocated[i][j]=sc.nextInt();
				need[i][j]=max[i][j]-allocated[i][j];
			}
		}
		print();
		
		}
	

}
