package com.practice.codingInterview.recursion;

/**
 * Print All Possible Subsets with Sum equal to a given Number
 * Example N=4 will print
 * 1111
 * 112
 * 121
 * 13
 * 211
 * 22
 * 31
 * 4
 * Created by abhi.pandey on 3/6/16.
 */
public class SubsetWithEqualSum {

    /*
    Loop through i=1 to N.
    Add i to the result and make a recur­sive call to (N-i).
    Base case: when n becomes 0
     */
    public static void print(int n, String x) {
        if (n == 0) {
            System.out.println(x);
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                x = x + i;
                print(n - i, x);
                x = x.substring(0, x.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        print(n, "");

    }

}
