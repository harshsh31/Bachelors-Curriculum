package cn;

import java.util.*;
import java.io.*;
class Node
{
	int[] dist=new int[20];
int[] from=new int[20];
}
public class dvr
{
	static Scanner sc=new Scanner(System.in);
	
	static Node[] rt;
	static int[][] costmat;
	public static void main(String args[])
	{
		int nodes,count=0;
		System.out.println("Enter the number of nodes:");
		nodes=sc.nextInt();
		rt = new Node[nodes];
		costmat=new int[nodes][nodes];
		
		System.out.println("Enter the cost matrix:");
		for(int i=0; i<nodes;i++)
		{	
			rt[i] = new Node();
			for(int j=0;j<nodes;j++)
			{
				System.out.print("a["+i+"]["+j+"]:\t");
				costmat[i][j]=sc.nextInt();
				costmat[i][i]=0;
				rt[i].dist[j]=costmat[i][j];
				rt[i].from[j]=j;

			}
		}
		

			count=0;
			for(int i=0;i<nodes;i++)
				for(int j=0;j<nodes;j++)
					for(int k=0;k<nodes;k++)
						if(rt[i].dist[j]>costmat[i][k]+rt[k].dist[j])
						{
							rt[i].dist[j]=rt[i].dist[k]+rt[k].dist[j];
							rt[i].from[j]=k;
							count++;
						}

		for(int i=0;i<nodes;i++){
			System.out.println("For router "+(i+1));
			for(int j=0;j<nodes;j++)
			{
				if(j!=i)
				System.out.println("Node "+(j+1)+" via "+ (rt[i].from[j]+1) +" distance "+rt[i].dist[j]);

			}
			System.out.println();
		}
	}
}