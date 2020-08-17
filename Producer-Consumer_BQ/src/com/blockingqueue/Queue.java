package com.blockingqueue;

import java.util.ArrayList;
import java.util.List;

class Queue {
    // initialise queue
    private static List<Integer> queue =  new ArrayList<Integer>();
    // finalise queue size
    private static final int max_size = 10;

    // total element present in queue
    private static int curCount = 0;

    // item to be added in queue
    private static int curItem = 0;
    // new Object lock variable
    public static Object lock =  new Object();

    // queue insertion
    static boolean put()
    {

        if(curCount <= max_size)
        {
            queue.add(curItem);
            curCount+=1;
            curItem+=1;
            lock.notifyAll();
            return true;
        }
        return false;
    }

    // queue deletion
    static boolean take()
    {
        //delete only when queue is not empty
        if(curCount > 0)
        {
            int value = queue.remove(0);
            curCount-=1;
            lock.notify();
            return true;
        }
        return false;
    }
}
