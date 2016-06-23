package com.practice.interviewcake;

/**
 * Write a function fib() that a takes an integer and returns the nth fibonacci
 * <p>
 * Created by abhi.pandey on 5/7/16.
 */
public class NthFibonacciNumber {
    public static void main(String[] args) throws Exception {
        System.out.println(getNthFiboNumber(-1));
    }

    public static int getNthFiboNumber(int num) throws Exception {
        if (num < 0)
        throw new Exception("Index was negative. No such thing as a negative index in a series.");

        if (num == 0) return 0;

        if (num == 1) return 1;

        int c = 0, a = 0, b = 1;

        for (int i = 2; i <=  num; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
