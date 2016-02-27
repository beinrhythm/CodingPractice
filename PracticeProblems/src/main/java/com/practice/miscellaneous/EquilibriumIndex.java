package com.practice.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi.pandey on 8/6/15.
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        int array[] = {-1, 3, -4, 5, 1, -6, 2, 1};
        int array2[] = {1082132608, 0, 1082132608};
        int array3[] = {0, -1};


        System.out.println(EquilibriumIndex.solution(array));
    }

    public static int solution(int... A) {

        if (A != null && A.length > 0) {
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

    public int solution2(int... arr) {


        long sum = 0;
        long ls = 0;
        List<Integer> res = new ArrayList<Integer>();

        for (int i : arr) {
            sum = sum + i;
        }

        for (int j = 0; j < arr.length; j++) {
            if (j == arr.length - 1 && ls == 0) {
                return j;
            }
            sum = sum - arr[j];
            if (sum == ls) {
                return j;
            }

            ls = ls + arr[j];


        }

        return -1;
    }
}
