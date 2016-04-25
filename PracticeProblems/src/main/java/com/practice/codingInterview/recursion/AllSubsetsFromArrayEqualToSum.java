package com.practice.codingInterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all subsets of an int array whose sums equal a given target
 * For example:
 * Target sum is 15 and int array is { 1, 3, 4, 5, 6, 15 }.
 * 15 = 1+3+5+6
 * 15 = 4+5+6
 * 15 = 15
 * Created by abhi.pandey on 3/6/16.
 */
public class AllSubsetsFromArrayEqualToSum {


    public static void main(String[] args) {
        Integer[] DATA = {5, 6, 4, 1, 3, 15};

        Integer[] DATA2 = {1, 3, 14, 4, 15, 12, 6, 11, 8, 9, 10, 7, 13,
                2, 5};

        Integer[] DATA3 = {3, 34, 4, 12, 5, 2};


        new AllSubsetsFromArrayEqualToSum().populateSubset(DATA3, 9);

    }

    public void populateSubset(Integer[] data, int target) {
        Arrays.sort(data);
//        populateSubsetHelper(data, 0, new Integer[data.length], 0, target);
        populateSubsetHelper(data, target, -1, new ArrayList<Integer>());
    }

    private void populateSubsetHelper(final Integer[] data, int fromIndex,
                                      final Integer[] stack, final int stacklen,
                                      final int target) {
        if (target == 0) {
            // exact match of our target. Success!
            printResult(Arrays.asList(Arrays.copyOf(stack, stacklen)));
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
            populateSubsetHelper(data, fromIndex + 1, stack, stacklen + 1, target - data[fromIndex]);
            fromIndex++;
        }
    }

    private static void printResult(List<Integer> output) {
        for (int s : output) {
            System.out.print(s + ",");
        }
        System.out.println();
    }

    private static void populateSubsetHelper(Integer[] a, int sum, int index, List<Integer> list) {
        if (sum == 0) {
            printResult(list);
            return;
        }
        for (int i = index + 1; i < a.length; i++) {
            if (a[i] <= sum) {
                list.add(a[i]);
                populateSubsetHelper(a, sum - a[i], i, list);
                list.remove(list.size() - 1); // This is backtracking.
            }
        }
    }
}
