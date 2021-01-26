public class Main {

    public static void main(String[] args) {
        MyBlockingQueue customBlockingQueue = new MyBlockingQueue();
        // Creating producer and consumer threads
        Thread producer = new Thread(new Producer(customBlockingQueue));
        Thread consumer1 = new Thread(new Consumer1(customBlockingQueue));
        Thread consumer2 = new Thread(new Consumer2(customBlockingQueue));

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
