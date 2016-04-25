package com.practice.multiThreading.delayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by abhi.pandey on 4/5/16.
 */
public class Client {
    private DelayQueue<Job> queue;

    public Client(DelayQueue<Job> queue) {
        this.queue = queue;
    }

    public void addTask(Runnable job, long delay, TimeUnit timeUnit) {
        queue.put(new Job(job, delay, timeUnit));
    }

}
