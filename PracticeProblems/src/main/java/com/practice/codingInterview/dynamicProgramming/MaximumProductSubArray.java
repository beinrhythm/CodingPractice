package com.practice.codingInterview.dynamicProgramming;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * Created by abhi.pandey on 4/22/16.
 */
public class MaximumProductSubArray {

    public static void main(String[] args) {

        int a[] = {6, -3, -10, 0, 2};
        System.out.println(findProdContiguous(a));
        System.out.println(findProdNonContiguous(a));
    }

    /*
    This is similar to maximum subarray. Instead of sum, the sign of number affect the product value.
    When iterating the array, each element has two possibilities: positive number or negative number.
    We need to track a minimum value, so that when a negative number is given, it can also find the maximum value.
    We define two local variables, one tracks the maximum and the other tracks the minimum.
     */
    public static int findProdContiguous(int[] A) {
        if (A != null && A.length > 1) {

            int maxEndingHere = A[0];
            int minEndingHere = A[0];
            int maxSoFar = A[0];

            for (int i = 1; i < A.length; i++) {
                int temp = maxEndingHere;
                maxEndingHere = Math.max(Math.max(A[i] * maxEndingHere, A[i]), A[i] * minEndingHere);
                minEndingHere = Math.min(Math.min(A[i] * minEndingHere, A[i]), A[i] * minEndingHere);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            return maxSoFar;
        }
        return 0;
    }

    public static int findProdNonContiguous(int[] array) {

        if (array != null && array.length > 1) {
            int maxProdEndingHere = array[0];
            int maxProdSoFar = array[0];

            for (int i = 1; i < array.length; i++) {
                maxProdEndingHere = Math.max(array[i], array[i] * maxProdEndingHere);
                maxProdSoFar = Math.max(maxProdEndingHere, maxProdSoFar);
            }
            return maxProdSoFar;
        }

        return 0;
    }
}
