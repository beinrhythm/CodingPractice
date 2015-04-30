package com.practice.codingInterview.stacksAndQueues;

import java.util.Stack;

/**
 * Created by abhi.pandey on 12/2/14.
 *
 * How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.
 */
public class MinStack extends Stack<Integer> {

    private Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        if(minStack.isEmpty()){
            minStack.push(value);
        }
        if (!minStack.isEmpty() && minStack.peek() > value) {
            minStack.push(value);
        }
        super.push(value);

    }

    public Integer pop() {
        int value = super.pop();

        if (!minStack.empty() && value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(4);
        ms.push(2);
        ms.push(7);
        ms.push(1);
        ms.push(3);
        ms.push(8);
        System.out.println(ms.min());
        ms.pop();
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());

    }
}
