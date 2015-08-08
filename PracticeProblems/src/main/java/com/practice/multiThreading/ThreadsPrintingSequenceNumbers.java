package com.practice.multiThreading;

import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by abhi.pandey on 10/21/14.
 */
public class ThreadsPrintingSequenceNumbers {

    public static void main(String args[]) {
        final Counter myCounter = new Counter(new ReentrantLock());

        Runnable r = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 1000) {
                    System.out.printf("Count at thread %s is %d %n", Thread.currentThread().getName(), myCounter.getCount().intValue());
                    i++;
                }

            }
        };

        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        Thread t3 = new Thread(r, "T3");

        t1.start();
        t2.start();
        t3.start();
    }


}
