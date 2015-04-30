package com.practice.codingInterview.stacksAndQueues;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 * Created by abhi.pandey on 12/7/14.
 */
public class MyQueue <E>{

    Stack<E> primary, secondary;

    public MyQueue(){
        primary = new Stack<>();
        secondary = new Stack<>();
    }

    public void enQueue(E a){
        primary.push(a);
    }

    public E deQueue(){
        while(!primary.empty()){
            E temp = primary.pop();
            secondary.push(temp);
        }
        E val = secondary.pop();

        while(!secondary.empty()){
            E temp = secondary.pop();
            primary.push(temp);
        }

        return val;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        System.out.println(myQueue.deQueue());
        myQueue.enQueue(5);
        System.out.println(myQueue.deQueue());

    }
}
