package com.practice.codingInterview.stacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high,
 * it might topple. Therefore, in real life, we would likely start
 * a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks, and should
 * create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically
 * to a single stack (that is, pop() should return the same values as
 * it would if there were just a single stack).
 * <p/>
 * Created by abhi.pandey on 12/6/14.
 */
public class SetOfStacks<E> {
    private ArrayList<MyStack> stacks = new ArrayList<MyStack>();
    private int CAPACITY = 5;

    public void push(E v) {
        MyStack last = getLast();
        if (last != null && CAPACITY > 0) {
            last.push(v);
            CAPACITY--;
            stacks.add(last);
        } else {
            if (last != null) {
                stacks.add(last);
            }
            MyStack<E> s = new MyStack<E>();
            CAPACITY = 5;
            s.push(v);
            CAPACITY--;
            stacks.add(s);
        }
    }

    public E pop() {
        MyStack<E> last = getLast();
        if (last != null) {
            E value = last.pop();
            if (last.size() > 0)
                stacks.add(last);
            return value;
        }
        return null;
    }

    private MyStack getLast() {
        if (stacks.isEmpty()) {
            return null;
        }
        int length = stacks.size();
        MyStack last = stacks.get(length - 1);
        stacks.remove(last);
        return last;
    }

    /**
     * function popAt(int index) which performs a pop operation on a specific sub-stack.
     *
     * @param index
     * @return
     */
    private E popAt(int index) {
        return leftShift(index, true);
    }

    private E leftShift(int index, boolean removeTop) {
        MyStack<E> stack = stacks.get(index);
        E removed_item;
        if (removeTop) removed_item = stack.pop();
        else removed_item = stack.removeBottom();
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            E v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    public static void main(String[] args) {
        SetOfStacks<Integer> stack = new SetOfStacks();
        stack.pop();
        stack.push(10);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
class MyStack<E> extends Stack<E>{
    public E top, bottom;
    public E removeBottom() {

        return null;
    }
}
