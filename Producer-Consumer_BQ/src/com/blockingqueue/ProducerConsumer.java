package com.blockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ProducerConsumer {
    public static void main(String []args)
    {
        //thread of producer
        producer p = new producer();
        p.start();

        ExecutorService poolProducer = Executors.newSingleThreadExecutor();
        poolProducer.execute(p);

        //intialise the number of consumer thread
        final int consumerThread = 5;

        //create n number of thread
        ExecutorService poolConsumer = Executors.newCachedThreadPool();

        // creating multiple consumer thread
        for (int i = 0; i < consumerThread; i++) {
            // consumer thread
            Consumer c = new Consumer();
            c.start();
            poolConsumer.execute(c);
        }
    }
}





