package com.practice.multiThreading;

/**
 * Created by abhi.pandey on 11/23/14.
 */
public class Lock {

    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int lockedCount = 0;



    public synchronized void lock() throws InterruptedException {

        Thread lockingThread = Thread.currentThread();
        while(isLocked && lockedBy!=lockingThread){
            this.wait();
        }

        isLocked = true;
        lockedCount++;
        lockedBy = lockingThread;
    }

    public  synchronized  void unlock(){
        if(Thread.currentThread()==lockedBy)
        isLocked = false;
        this.notifyAll();
        lockedCount--;
    }

}
