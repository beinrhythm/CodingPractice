package com.practice.multiThreading.delayQueue;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * https://www.careercup.com/question?id=5140138881449984
 * A server receives requests from different clients...
 * each client send a Runnable job and time on which this job should be run.
 * Write a java program that would accept these jobs and run each job at the required time.
 * Hint: the solution should have a job priority queue to hold the jobs and it should be multithreaded.
 * One thread should accept the tasks, the other one should run the jobs. Also conditions and signalling will be used
 * Created by abhi.pandey on 4/5/16.
 */
public class ClientServerTest {

    private DelayQueue<Job> queue = new DelayQueue<>();
    private Random rand = new Random(System.nanoTime());

    @Test
    public void testMultipleClientProcessTasks() {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    Client client = new Client(queue);
                    client.addTask(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                System.err.println(Thread.currentThread()
                                        .getId() + ": " + e.getMessage());
                            }
                            System.out.println(Thread.currentThread().getId());
                        }
                    }, rand.nextInt(500), TimeUnit.MILLISECONDS);
                }

            });
        }
        exec.submit(new Runnable() {
            @Override
            public void run() {
                Server server = new Server(queue);
                server.processTasks();
            }
        });
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
        }
        //     assert (queue.isEmpty(), true);
        exec.shutdownNow();
    }
}
