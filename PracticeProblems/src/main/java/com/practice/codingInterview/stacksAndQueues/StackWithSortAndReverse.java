package com.practice.codingInterview.stacksAndQueues;

import java.util.Stack;

/**
 * Created by abhi.pandey on 12/7/14.
 */
public class StackWithSortAndReverse extends Stack {


    public static Stack<Integer> sort(Stack<Integer> s) {
        if (s.isEmpty()) {
            return s;
        } else {
            int a = s.pop();
            sort(s);
            insertForSort(s, a);
        }
        return s;
    }

    private static void insertForSort(Stack<Integer> s, int a) {
        if(s.isEmpty()){
            s.push(a);
            return;
        }else{
            int o = s.pop();
            if(o < a){
                insertForSort(s,o);
                s.push(a);
            }else {
                insertForSort(s, a);
                s.push(o);
            }
        }
    }

    public static Stack<Integer> reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return s;
        } else {
            int a = s.pop();
            reverse(s);
            insert(s,a);
        }
        return s;
    }

    private static void insert(Stack<Integer> s, int a) {
        if(s.isEmpty()){
            s.push(a);
            return;
        }else{
            int o = s.pop();
            insert(s,a);
            s.push(o);
        }
    }



    public static void main(String[] args) {
        Stack<Integer> original = new Stack<>();
        original.push(1);
        original.push(2);
        original.push(3);
        original.push(4);
        original.push(5);
        Stack<Integer> reverse = StackWithSortAndReverse.reverse(original);

        Stack<Integer> sorted = StackWithSortAndReverse.sort(original);

    }
}
