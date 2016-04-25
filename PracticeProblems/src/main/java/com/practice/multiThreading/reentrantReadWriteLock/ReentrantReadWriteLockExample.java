package com.practice.multiThreading.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by abhi.pandey on 3/2/16.
 */
public class ReentrantReadWriteLockExample {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static String message = "a";

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    if (lock.isWriteLocked()) {
                        System.out.println("I'll take the lock from Write");
                    }
                    lock.readLock().lock();
                    System.out.println("ReadThread " + Thread.currentThread().getId() + " ---> Message is " + message);
                    lock.readLock().unlock();
                }
            }
        };

        Thread t2 = new Thread(){
            public void run() {
                for(int i = 0; i<= 10; i ++) {
                    try {
                        lock.writeLock().lock();
                        message = message.concat("a");
                    } finally {
                        lock.writeLock().unlock();
                    }
                }
            }
        };
        Thread t3 = new Thread(new WriteB());
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }



    static class WriteB implements Runnable {

        public void run() {
            for(int i = 0; i<= 10; i ++) {
                try {
                    lock.writeLock().lock();
                    message = message.concat("b");
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }
}
