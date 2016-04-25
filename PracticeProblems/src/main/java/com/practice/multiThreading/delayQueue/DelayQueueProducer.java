package com.practice.multiThreading.delayQueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * Created by abhi.pandey on 3/1/16.
 */
public class DelayQueueProducer {

    // Creates an instance of blocking queue using the DelayQueue.
    private BlockingQueue queue;

    private final Random random = new Random();

    public DelayQueueProducer(BlockingQueue queue) {
        super();
        this.queue = queue;
    }

    private Thread producerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {

                    // Put some Delayed object into the DelayQueue.
                    int delay = random.nextInt(10000);
                    DelayObject object = new DelayObject(
                            UUID.randomUUID().toString(), delay);

                    System.out.printf("Put object = %s%n", object);
                    queue.put(object);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }, "Producer Thread");

    public void start(){
        this.producerThread.start();
    }

}