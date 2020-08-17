package com.blockingqueue;

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
                { // when queue is empty
                    System.out.println("Queue is empty,wait for producer to produce.");
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
