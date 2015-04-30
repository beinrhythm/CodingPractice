package com.practice.codingInterview.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abhi.pandey on 1/5/15.
 */
public class SubSetSum {

    public static void find(final int[] data, int fromIndex,
                            final int[] stack, final int stacklen,
                            final int target) {
        if (target == 0) {
            // exact match of our target. Success!
            print(stack);
            return;
        }

        while (fromIndex < data.length && data[fromIndex] > target) {
            // take advantage of sorted data.
            // we can skip all values that are too large.
            fromIndex++;
        }

        while (fromIndex < data.length && data[fromIndex] <= target) {
            // stop looping when we run out of data, or when we overflow our target.
            stack[stacklen] = data[fromIndex];
            find(data, fromIndex + 1, stack, stacklen + 1, target - data[fromIndex]);
            fromIndex++;

        }

    }

    private static void print(int[] stack) {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 4, 5, 6, 2, 7, 8, 9, 10, 11, 13,
                14, 15};
        Arrays.sort(data);
        //    SubSetSum.printResult(data);


        SubSetSum.find(data, 0, new int[data.length], 0, 15);


    }

}
