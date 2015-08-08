package com.practice.multiThreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by abhi.pandey on 12/22/14.
 */
public class ProducerConsumerPattern {


    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

    }
}

class Producer implements Runnable {
    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue<Integer> queue) {
        this.sharedQueue = queue;

    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                System.out.println("Produced "+ i);
                sharedQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {
    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.sharedQueue = queue;

    }

    @Override
    public void run() {
       while(true){
           try {
               System.out.println("Consumed "+sharedQueue.take());
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }


    }
}