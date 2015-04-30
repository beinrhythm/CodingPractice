package com.practice.codingInterview.recursion;

/**
 * Created by abhi.pandey on 12/29/14.
 */
public class Fibonacci {

    static int fibonacciRecursive(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        else if (n > 1) {
            int s = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);

            return s;
        } else return -1;
    }

    static void fibonacciIterative(int n) {
        if (n < 0) return;

        if (n == 0) System.out.println(0);

        int a = 0, b = 1;
        while (n > 0) {
            int c = a + b;
            System.out.print(c + ",");
            a = b;
            b = c;
            n--;
        }
    }


    public static void main(String[] args) {
        Fibonacci.fibonacciIterative(8);
    }
}
