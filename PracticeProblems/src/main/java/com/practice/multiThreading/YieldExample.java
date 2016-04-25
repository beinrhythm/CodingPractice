package com.practice.multiThreading;

/**
 * Created by abhi.pandey on 3/7/16.
 */
public class YieldExample {
    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++)
                {
                    System.out.println("I am Producer : Produced Item " + i);
                }
            }

        });

        Thread consumer = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++)
                {
                    System.out.println("I am Consumer : Consumed Item " + i);
                }
            }

        });
        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority
        producer.start();
        consumer.start();
    }


}
