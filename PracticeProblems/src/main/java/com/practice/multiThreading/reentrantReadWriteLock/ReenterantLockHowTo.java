package com.practice.multiThreading.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by abhi.pandey on 1/7/15.
 */
public class ReenterantLockHowTo {
    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public int getCount() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread() + " gets count " + count);
            return count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReenterantLockHowTo rl = new ReenterantLockHowTo();
        Thread t1 = new Thread("T1"){

            @Override
           public void run(){
                System.out.println(rl.getCount());
           }
        };

        t1.start();


    }

}
