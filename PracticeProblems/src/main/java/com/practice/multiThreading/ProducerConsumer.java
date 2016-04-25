package com.practice.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhi.pandey on 12/22/14.
 */
public class ProducerConsumer<T> {

    private final Queue<T> queue;
    private final int MAX_SIZE = 10;

    public ProducerConsumer(Queue<T> queue) {
        this.queue = queue;
    }

    synchronized public void producer(T value) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(value);
    }

    synchronized public T consumer() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        if (queue.size() == MAX_SIZE) {
            notifyAll();
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        final ProducerConsumer pc = new ProducerConsumer(q);
        Thread t1 = new Thread("T1") {
            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    System.out.println("Producing " + i);
                    try {
                        pc.producer(i);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread("T2") {
            @Override
            public void run() {
                while (true)
                    try {
                        System.out.println("Consuming " + pc.consumer());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }

        };

        t1.start();
        t2.start();
    }

 }
