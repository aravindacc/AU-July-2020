package com.blockingqueue;

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
                {	// when queue is full
                    System.out.println("Queue is full. wait for consumer to consume");
                    try {
                        Queue.lock.wait();
                    } catch(InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            try {
                Thread.sleep(1);
            }catch (Exception e) {
            }
        }
    }
}
