package os;

import java.util.Scanner;
import java.util.Vector;

public class optimal {

	static int a[];
	static Vector<Integer > v=new Vector<Integer>();
	public static boolean check(int x)
	{
		for(int i=0;i<a.length;i++)
		{
			if(x==a[i])
				return true;
		}
		return false;
	}
	public static void print()
	{
		System.out.print("[ ");
		for (int i=0;i<a.length;i++)
			System.out.print(a[i]+"\t");
		System.out.print(" ]");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of pages: ");
			int n=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				System.out.println("Enter page "+(i+1)+" entry");
				v.add(sc.nextInt());
			}
			System.out.println("Enter the frame size: ");
			int m=sc.nextInt();
			a=new int[m];
			int pf=m;
			
			for(int i=0;i<m;i++)
			{
				a[i]=v.get(i);
				System.out.print(v.get(i)+"\t");
				print();
				System.out.println("\tfault");
			}
			for(int i=m;i<n;i++)
			{
				if(check(v.get(i)))
				{
					System.out.print(v.get(i)+"\t");
					print();
					System.out.println("\thit");
				}
				else
				{
					int max=-1,k,value=-1;
					for(int j=0;j<m;j++)
					{
						for(k=i;k<n;k++)
						{
							if(a[j]==v.get(k))
							{
							//	System.out.println("k="+k);
								break;
							}
						}
						if(k>max)
							{
								max=k;
								value=a[j];
							}
					}
					for(int j=0;j<m;j++)
					{
						if(a[j]==value&&value!=-1)
						{
							a[j]=v.get(i);
							System.out.print(v.get(i)+"\t");
							print();
							System.out.println("\tfault");
							pf++;
							break;
						}
						
					}
				}
			}
	}

}
