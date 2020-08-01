

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueue {
	public static void main(String []args)
	{
		// producer thread
		producer p = new producer();
		p.start();
		// create pool of single thread run at a time 
		ExecutorService poolProducer = Executors.newSingleThreadExecutor();
		poolProducer.execute(p);
		
		// define number of consumer thread to create
		final int numberOfProducerThread = 5;
		
		// create pull for consumer, can create n number of thread
		ExecutorService poolConsumer = Executors.newCachedThreadPool();
		
		// creating multiple consumer thread
		for (int i = 0; i < numberOfProducerThread; i++) {
			// consumer thread
			Consumer c = new Consumer();
			c.start();
			poolConsumer.execute(c);
		}
	}
}


// blocking queue
class Queue 
{
	// queue 
	private static List<Integer> queue =  new ArrayList<Integer>();
	// limit of queue
	private static final int max_size = 10;
	
	// provide number of element in queue
	private static int number = 0;
	
	// provide value added in queue
	private static int value = 0;
	// locking object
	public static Object lock =  new Object();
	
	// inserting into queue
	static boolean put()
	{
		// insert only when number of element is not greater than max size
		if(number <= max_size)
		{
			queue.add(value);
			System.out.println("adding value "+(value++) +" in queue at "+number++);
			lock.notifyAll();
			return true;
		}
		return false;
	}
	
	// deleting queue from front 
	static boolean take()
	{
		// delete only when number of element if greater than 0
		if(number > 0)
		{
			int value = queue.remove(0);
			System.out.println("Poping value "+value+" in queue at "+(--number));
			lock.notify();
			return true;
		}
		return false;
	}	
}

// producer thread
class producer extends Thread
{
	public void run()
	{
		while(true)
		{
			synchronized (Queue.lock) {
				System.out.print(this.getName()+" - "); // thread name
				
				if(!Queue.put())
				{	// execute when adding in queue is failed
					System.out.println("Queue is full. Waiting for pop.");
					try {
						Queue.lock.wait();
					} catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}

			try {
				Thread.sleep(3);
			}catch (Exception e) {
			}
		}
	}
}


//consumer thread
class Consumer extends Thread
{
	public void run()
	{
		while(true)
		{
			synchronized (Queue.lock) {
				System.out.print(this.getName()+" - ");
				if(!Queue.take())
				{ // execute when poping from queue failed 
					System.out.println("Queue is empty. Waiting for push.");
					try {
						Queue.lock.wait();
					} catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			
			try {
				Thread.sleep(10);
			}catch (Exception e) {
			}
		}
	}
}