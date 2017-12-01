package os;

import java.util.Random;
import java.util.Vector;

public class ProducerConsumer {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CubbyHole c=new CubbyHole();
		CubbyHole ch=new CubbyHole();
		Producer producer=new Producer(c,1);
		Consumer consumer=new Consumer(c,1);
		Thread t1=new Thread(producer);
		Thread t2=new Thread(consumer);
		producer =new Producer(ch, 2);
		consumer=new Consumer(ch,2);
		t1.start();
		t2.start();
		Thread t3=new Thread(producer);
		Thread t4=new Thread(consumer);
		t3.start();
		t4.start();
	}
}
class CubbyHole
{
	private	Vector<Integer> content=new Vector<Integer>();
	private boolean available=false;
	public synchronized int getContent() 
	{
		while(!available)
		{
			try{
				wait();
			}catch(InterruptedException e){ }
		}
		int i=content.get(0);
		content.remove(0);
		available=false;
		notify();
		return i;
	}
	public synchronized void putContent(int i)
	{
		while(content.size()>=10)
		{
			try
			{
				wait();
			}catch(InterruptedException e){	}
		}
		content.add(i);
		available=true;
		notify();
	}
}
class Producer implements Runnable
{
	CubbyHole ch;
	int index;
	public Producer() {
		// TODO Auto-generated constructor stub
	}
	public Producer(CubbyHole ch,int i)
	{
		this.ch=ch;
		index=i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random=new Random();
		for(int i=0;i<=10;i++)
		{
			int r=random.nextInt(100);
			ch.putContent(r);
			System.out.println("Producer #"+index+" produces data: "+r);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
class Consumer implements Runnable
{
	CubbyHole ch;
	int index;
	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	Consumer(CubbyHole ch,int i){
		this.ch=ch;
		index=i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random=new Random();
		for(int i=0;i<=10;i++)
		{
			try {
			Thread.sleep(random.nextInt(2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			int x=ch.getContent();
			System.out.println("Consumer #"+index+" gets data: "+x);
		}
	}	
}