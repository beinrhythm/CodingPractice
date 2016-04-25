package com.practice.multiThreading.delayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * Created by abhi.pandey on 3/1/16.
 */
public class DelayQueueTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Creates an instance of blocking queue using the DelayQueue.
        BlockingQueue queue = new DelayQueue();

        // Starting DelayQueue Producer to push some delayed objects to the queue
        new DelayQueueProducer(queue).start();

        // Starting DelayQueue Consumer to take the expired delayed objects from the queue
        new DelayQueueConsumer("Consumer Thread-1", queue).start();

    }

}
