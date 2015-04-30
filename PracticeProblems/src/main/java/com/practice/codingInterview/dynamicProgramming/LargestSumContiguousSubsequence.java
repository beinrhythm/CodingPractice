package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 12/26/14.
 */
public class LargestSumContiguousSubsequence {

    public static int findSum(int[] array) {

        if (array != null && array.length > 1) {
            int maxSoFar = array[0];

            int maxEndingHere = array[0];


            for (int i = 1; i < array.length - 1; i++) {

                maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);

                maxSoFar = Math.max(maxEndingHere, maxSoFar);
            }

            return maxSoFar;
        }

        return 0;
    }



    public static int[] findLargestSumArray(int[] array) {

        if (array != null && array.length > 1) {
            int maxSoFar = array[0];

            int maxEndingHere = array[0];

            int startIdx = 0;
            int stopIdx = 0;
            int temp1, temp2;

            for (int i = 1; i < array.length - 1; i++) {

                temp1 = Math.max(array[i], maxEndingHere + array[i]);
                if (temp1 > array[i]) {
                    startIdx = i;
                }
                maxEndingHere = temp1;

                temp2 = Math.max(maxEndingHere, maxSoFar);

                if (temp2 > maxSoFar) {
                    stopIdx = i;
                }
                maxSoFar = temp2;
            }

            int result[] = new int[stopIdx - startIdx + 1];
            int j = 0;

            for (int i = startIdx; i <= stopIdx; i++) {
                result[j] = array[startIdx];
                j++;
            }

            return result;
        }

        return array;
    }

    public static int findSum2(int[] array) {
        int max = 0;
        if (array != null && array.length > 1) {

            int[] DP = new int[array.length];
            DP[0] = array[0];
            for (int i = 1; i < array.length; i++) {
                DP[i] = Math.max(DP[i - 1] + array[i], array[i]);
            }

            for (int i : DP) {
                if (i > max) {
                    max = i;
                }
            }

        }

        return max;
    }


    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(LargestSumContiguousSubsequence.findSum(a));

     //   int result[] = LargestSumContiguousSubsequence.findLargestSumArray(a);
    }
}
