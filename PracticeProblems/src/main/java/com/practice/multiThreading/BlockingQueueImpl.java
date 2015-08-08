package com.practice.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhi.pandey on 12/19/14.
 */
public class BlockingQueueImpl {
    private int limit;

    BlockingQueueImpl(int limit) {
        this.limit = limit;
    }

    Queue<Integer> q = new LinkedList<>();

    public synchronized void enqueue(int val) throws InterruptedException {
        while (q.size() == limit) {
            wait();
        }
        if (q.size() == 0) {
            notifyAll();
        }
        q.add(val);

    }

    public synchronized void dequeue() throws InterruptedException {
        while (q.size() == 0) {
            wait();
        }
        if (q.size() == limit) {
            notifyAll();
        }
        q.remove(0);
    }

    public static void main(String[] args) {
        final BlockingQueueImpl blockingQueue = new BlockingQueueImpl(10);
        Thread t1 = new Thread("T1") {
            public void run() {
                try {
                    blockingQueue.enqueue(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

    }


}
