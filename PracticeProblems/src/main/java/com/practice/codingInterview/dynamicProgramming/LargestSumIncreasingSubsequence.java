package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 12/27/14.
 */
public class LargestSumIncreasingSubsequence {
    public static int find(int[] array) {
        int[] L = new int[array.length];
        L[0] = array[0];
        for (int i = 1; i < L.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && L[j] + array[i] > L[i]) {
                   L[i] = L[j]+ array[i];
                }
            }
        }
        int maxi = 0;
        for (int i = 0; i < L.length; i++) {
            if (L[i] > maxi) {
                maxi = L[i];
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] sample = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] sample2 = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(LargestSumIncreasingSubsequence.find(sample));
        System.out.println(LargestSumIncreasingSubsequence.find(sample2));
    }
}
