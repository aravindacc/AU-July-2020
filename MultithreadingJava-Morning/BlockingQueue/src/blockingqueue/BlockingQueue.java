package blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of consumer threads to be created: ");
        int n = scan.nextInt();
        
        ThreadBlockingQueue tbq = new ThreadBlockingQueue();
        Thread putThread = new Thread(()->tbq.put());
        putThread.start();
        
        ExecutorService takeThread = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            takeThread.submit(new Runnable() {
                public void run() {
                    tbq.take();
                }
            });
        }
        takeThread.shutdown();
        takeThread.awaitTermination(1000, TimeUnit.SECONDS);

//        Thread takeThread[] = new Thread[n];
//        for (int i = 0; i < takeThread.length; i++) {
//            takeThread[i] = new Thread(() -> {tbq.take();});
//            takeThread[i].start();
//        }
    }
}

class ThreadBlockingQueue{
    private int maxSize = 5;
    private int minSize = 0;
    private List<Integer> list = new ArrayList<>();
    private int number = 0;
	
    public synchronized void put() {
        while(true) {
            if(list.size() == maxSize) {
                System.out.println("Queue is full. No task is taken by any of the consumer.");
                try {
                    wait();
                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " produced " + number);
                list.add(number++);
                notifyAll();
            }
        }
    }
	
    public synchronized void take() {
        while(true) {
            if(list.size() == minSize) {
                System.out.println("Queue is empty. There is no task present in the Queue.");
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting.");
                    wait();
                } catch(InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " consumed " + list.remove(--number));
                notify();
            }
        }
    }	
}