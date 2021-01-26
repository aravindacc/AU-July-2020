import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	
	public static void main(String[] args) {
		Q q = new Q();
		Thread t1 = new Thread(() -> q.put());
		Thread t2 = new Thread(() -> q.take());
		Thread t3 = new Thread(() -> q.take());
		Thread t4 = new Thread(() -> q.take());
		Thread t5 = new Thread(() -> q.take());
		Thread t6 = new Thread(() -> q.take());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class Q{
	Queue<Integer> q=new LinkedList<>();
	private int maximumSize=10;
	private int minimum=0;
	private Object lock=new Object();
	private int number=0;
	
	public void put() {
		synchronized(lock) {
			while(true)
			{
				if(q.size()==maximumSize) {
					System.out.println("Queue is full.");
					try {
						lock.wait();
					} catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					System.out.println("Producer produce NUMBER="+number+" and adding into the queue");
					q.add(number);
					number++;
					lock.notifyAll();
				}
				try {
					Thread.sleep(500);
				} catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public void take() {
		synchronized(lock) {
			while(true) {
				if (q.size() == minimum) {
					System.out.println("Queue is empty");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Consumer "+Thread.currentThread().getName()+" Consumer consumes the number=" + q.remove() + " from the queue.");
					lock.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
/*OUTPUT:-
"C:\Program Files\Java\jdk1.8.0_231\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\lib\idea_rt.jar=58646:C:\Program Files\JetBrains\IntelliJ IDEA 2020.1.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_231\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_231\jre\lib\rt.jar;C:\Users\SHASHANK GOYAL\Downloads\accoliteTraining\out\production\accoliteTraining" BlockingQueue
Producer produce NUMBER=0 and adding into the queue
Producer produce NUMBER=1 and adding into the queue
Producer produce NUMBER=2 and adding into the queue
Producer produce NUMBER=3 and adding into the queue
Producer produce NUMBER=4 and adding into the queue
Producer produce NUMBER=5 and adding into the queue
Producer produce NUMBER=6 and adding into the queue
Producer produce NUMBER=7 and adding into the queue
Producer produce NUMBER=8 and adding into the queue
Producer produce NUMBER=9 and adding into the queue
Queue is full.
Consumer Thread-4 Consumer consumes the number=0 from the queue.
Consumer Thread-5 Consumer consumes the number=1 from the queue.
Consumer Thread-3 Consumer consumes the number=2 from the queue.
Consumer Thread-2 Consumer consumes the number=3 from the queue.
Consumer Thread-1 Consumer consumes the number=4 from the queue.
Consumer Thread-2 Consumer consumes the number=5 from the queue.
Consumer Thread-3 Consumer consumes the number=6 from the queue.
Consumer Thread-5 Consumer consumes the number=7 from the queue.
Consumer Thread-4 Consumer consumes the number=8 from the queue.
Producer produce NUMBER=10 and adding into the queue
Producer produce NUMBER=11 and adding into the queue
Producer produce NUMBER=12 and adding into the queue
Producer produce NUMBER=13 and adding into the queue
Producer produce NUMBER=14 and adding into the queue
Producer produce NUMBER=15 and adding into the queue
Producer produce NUMBER=16 and adding into the queue
Producer produce NUMBER=17 and adding into the queue
Producer produce NUMBER=18 and adding into the queue
Queue is full.
Consumer Thread-4 Consumer consumes the number=9 from the queue.
Consumer Thread-5 Consumer consumes the number=10 from the queue.
Consumer Thread-3 Consumer consumes the number=11 from the queue.
Consumer Thread-2 Consumer consumes the number=12 from the queue.
Consumer Thread-1 Consumer consumes the number=13 from the queue.
Consumer Thread-2 Consumer consumes the number=14 from the queue.
Consumer Thread-3 Consumer consumes the number=15 from the queue.
Consumer Thread-5 Consumer consumes the number=16 from the queue.
Consumer Thread-4 Consumer consumes the number=17 from the queue.
Producer produce NUMBER=19 and adding into the queue
Producer produce NUMBER=20 and adding into the queue
Producer produce NUMBER=21 and adding into the queue
Producer produce NUMBER=22 and adding into the queue
Producer produce NUMBER=23 and adding into the queue
Producer produce NUMBER=24 and adding into the queue
Producer produce NUMBER=25 and adding into the queue
Producer produce NUMBER=26 and adding into the queue
Producer produce NUMBER=27 and adding into the queue
Queue is full.
Consumer Thread-4 Consumer consumes the number=18 from the queue.
Consumer Thread-5 Consumer consumes the number=19 from the queue.
Consumer Thread-3 Consumer consumes the number=20 from the queue.
Consumer Thread-2 Consumer consumes the number=21 from the queue.
Consumer Thread-1 Consumer consumes the number=22 from the queue.
Consumer Thread-2 Consumer consumes the number=23 from the queue.
Consumer Thread-3 Consumer consumes the number=24 from the queue.

Process finished with exit code -1

 */