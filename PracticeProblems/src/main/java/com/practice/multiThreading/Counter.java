package com.practice.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * Created by abhi.pandey on 10/22/14.
 */
class Counter {
    private Lock lock;
    private AtomicInteger count = new AtomicInteger(0) ;
    public Counter(Lock myLock){
        this.lock = myLock;
    }
    public final AtomicInteger getCount(){
        lock.lock();
        try{
            this.count.incrementAndGet();
        }finally {
            lock.unlock();
        }

        return this.count;
    }
}