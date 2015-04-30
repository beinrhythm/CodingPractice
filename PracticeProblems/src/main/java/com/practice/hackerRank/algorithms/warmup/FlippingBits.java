package com.practice.hackerRank.algorithms.warmup;

/**
 * Created by abhi.pandey on 1/25/15.
 */
public class FlippingBits {
    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 0, 0, 1, 0};
        //We can achieve this using modified Kadane's algorithm for finding max sum sub-array.
        if (arr != null && arr.length > 1) {
            int maxDifference = 0;
            int fsIndex = 0;
            int feIndex = 0;
            int onesToFlip = 0;
            int totalOnes = 0;

            int currentDifference = 0;
            int currentStart = 0;
            int currentOnesToFlip = 0;
            int zeroCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    currentDifference -= 1;
                    zeroCount++;
                } else {
                    currentDifference += 1;
                    currentOnesToFlip++;
                    totalOnes++;
                }
                if (currentDifference < maxDifference) {
                    maxDifference = currentDifference;
                    fsIndex = currentStart;
                    feIndex = i;
                    onesToFlip = currentOnesToFlip;
                } else if (currentDifference > 0) {
                    currentDifference = 0;
                    currentStart = i + 1;
                    currentOnesToFlip = 0;
                }

            }
            if (zeroCount != 0)
                System.out.println(feIndex - fsIndex + 1 - onesToFlip + totalOnes - onesToFlip);
            else
                System.out.println("No zeros to flip, total number of ones" + totalOnes);
        }
    }
}
