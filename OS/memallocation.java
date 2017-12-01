package os;

import java.util.Scanner;

public class memallocation {
	static int holes[];
	static boolean available[];
	static int process[];
	static boolean completed[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of holes: ");
			int n=sc.nextInt();
			holes=new int[n];
			available=new boolean[n];
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter the size of "+(i+1)+" hole");
				holes[i]=sc.nextInt();
				available[i]=true;
			}
			System.out.println("Enter the number of processes: ");
			int m=sc.nextInt();
			process=new int[m];
			completed=new boolean[m];
			for(int i=0;i<m;i++)
			{
				System.out.println("Enter the size of "+(i+1)+" process");
				process[i]=sc.nextInt();
				completed[i]=false;
			}
			System.out.println("Enter case 1]first fit 2] best fit 3]worst fit");
			int option =sc.nextInt();
			switch(option)
			{
				case 1:
					for(int j=0;j<m;j++)
						{	for(int i=0;i<n;i++)
							{
								if(available[i])
								{
									if(holes[i]>process[j])
									{
										System.out.println("hole "+holes[i]+" number="+(i+1)+" assigned process" +process[j]);
										holes[i]-=process[j];
										if(holes[i]==0)
											available[i]=false;
										completed[j]=true;
										break;
									}
								}
							}
							if(!completed[j])
								System.out.println("process "+process[j]+" unassigned");
						}
				case 2:for(int j=0;j<m;j++)
				{
					for(int i=0;i<n;i++)
					{
						if(available[i])
						{
							int l,min=9999,minindex=n;
							for(l=0;l<n;l++)
							{
								if(holes[l]-process[j]>0&&holes[l]-process[j]<min)
								{
									min=holes[l]-process[j];
									minindex=l;
								}
							}
							System.out.println("minindex="+minindex);
							if(minindex<n)
							{
								System.out.println("hole "+holes[minindex]+" number="+(minindex+1)+" assigned process" +process[j]);
								holes[minindex]-=process[j];
								if(holes[minindex]==0)
									available[minindex]=false;
								completed[j]=true;
								break;}
						}
					}
					if(!completed[j])
						System.out.println("process "+process[j]+" unassigned");
				}
			}
	}

}
