package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 8/6/15.
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        int array[] = {-1, 3, -4, 5, 1, -6, 2, 1};
        int array2[] = {1082132608, 0, 1082132608};
        int array3[] = new int[0];

        System.out.println(EquilibriumIndex.solution(array2));
    }

    public static int solution(int[] A) {

        if (A != null && A.length > 0 ) {
            long sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }

            long targetSum;
            long leftSum = A[0];
            long tempSum = 0;
            for (int i = 1; i < A.length; i++) {
                targetSum = sum;
                targetSum = (targetSum - A[i]);
                tempSum += A[i];
                if (targetSum % 2 == 0) {
                    targetSum /= 2;
                    if (targetSum == leftSum) return i;
                }

                leftSum += A[i];

            }

            if (tempSum == 0) return 0;
        }
        return -1;
    }
}
