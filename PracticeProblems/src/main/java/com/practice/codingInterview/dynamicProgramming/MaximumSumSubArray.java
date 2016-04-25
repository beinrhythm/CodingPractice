package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 3/12/15.
 */
public class MaximumSumSubArray {
    public static int findSum(int[] array) {

        if (array != null && array.length > 1) {
            int maxEndingHere = array[0];
            int maxSoFar = array[0];

            for (int i = 1; i < array.length; i++) {
                maxEndingHere = Math.max(array[i], array[i] + maxEndingHere);
                if(maxEndingHere > maxSoFar ){
                    System.out.println("maxEndingHere " + maxEndingHere + " Index = " + i + " value = "+array[i]);
                }else{
                    System.out.println("maxSoFar " +maxSoFar + " Index = " + i + " value = "+array[i]);
                }
                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }
            return maxSoFar;
        }

        return 0;
    }

    public static void main(String[] args) {

        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findSum(a));
    }
}
