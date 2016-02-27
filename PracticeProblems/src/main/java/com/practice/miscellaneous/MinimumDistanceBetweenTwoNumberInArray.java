package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 10/11/15.
 */
public class MinimumDistanceBetweenTwoNumberInArray {

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 5, 5, 6, 5, 2, 3, 5, 7};

        System.out.println(solutionForTwoDifferentNumbers(a, 5, 5));
    }

    public static int solutionForTwoDifferentNumbers(int[] a, int n, int m) {

        if (n == m) return solutionForTwoSameNumbers(a, n);

        if (a.length < 2) return -1;

        int result = 1;
        int lenA = a.length;

        boolean nfound = false;
        boolean mfound = false;
        int temp = 0;
        for (int i = 0; i < lenA; i++) {

            if (a[i] == n) {

                if (mfound) {
                    result = Math.min(result, temp);
                    temp = 0;
                    mfound = false;
                }
                if (nfound) {
                    temp = 0;
                }
                nfound = true;
            }
            if (a[i] == m) {
                mfound = true;
                if (nfound) {
                    result = Math.min(result, temp);
                    temp = 0;
                    nfound = false;
                }
            }
            temp++;
        }
        return result;
    }

    public static int solutionForTwoSameNumbers(int[] a, int n) {

        if (a.length < 2) return -1;

        int result = -1;
        int lenA = a.length;
        boolean found = false;
        int temp = 0;

        for (int i = 0; i < lenA; i++) {
            if (a[i] == n) {
                if (found) {
                    if (result < 0) {
                        result = temp;
                    } else {
                        result = Math.min(temp, result);
                    }

                } else {
                    found = true;
                }
                temp = 0;
            }
            temp++;
        }

        return result;

    }
}
