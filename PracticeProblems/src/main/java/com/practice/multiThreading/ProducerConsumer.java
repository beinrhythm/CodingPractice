package com.practice.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhi.pandey on 12/22/14.
 */
public class ProducerConsumer {

    private final Queue<Integer> queue;
    int limit = 10;

    public ProducerConsumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    synchronized public void producer(int value) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(value);
    }

    synchronized public int consumer() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        if (queue.size() == limit) {
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

  /*  private Queue<Integer> queue;
    private int limit;

    public ProducerConsumer(Queue<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    synchronized public void producer(int val) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }

        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(val);
    }

    synchronized public int consumer() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        if (queue.size() == limit) {
            notifyAll();
        }
        return queue.remove();
    }

    public static void main(String[] args) {

        Queue q = new LinkedList();
        final ProducerConsumer pc = new ProducerConsumer(q, 10);
        Thread t1 = new Thread("T1") {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println("Producing - "+ i);
                        pc.producer(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread("T2") {
            public void run() {
                try {
                    System.out.println("Consuming - " + pc.consumer());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();
    }
*/}
