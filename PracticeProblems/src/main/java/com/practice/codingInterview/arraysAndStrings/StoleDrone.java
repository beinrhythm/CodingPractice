package com.practice.codingInterview.arraysAndStrings;

/**
 * Created by abhi.pandey on 7/8/15.
 */
public class StoleDrone {
    public static void main(String[] args) {
        int[] input = {4, 5, 6, 2, 5, 6, 2,  7, 1, 1, 4};
        System.out.println(solve(input));
    }

    public static int solve (int[] input){
        int output = 0;
        for (int i : input) {
            output ^= i;
        }
        return  output;
    }
}
