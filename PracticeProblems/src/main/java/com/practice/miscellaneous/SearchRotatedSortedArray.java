package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 2/10/16.
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = { 1 , 2};
        System.out.println(findTarget(a, a.length, 2));
        System.out.println(findRotationPoint(a, a.length));
    }

    public static int findTarget(int[] arr, int N, int key) {

        int L = 0;
        int R = N - 1;

        while (L <= R) {
            int M = L + (R - L) / 2;

            if (arr[M] == key) return M;
            //if bottom half is sorted
            if (arr[L] <= arr[M]) {

                if (arr[L] <= key && key < arr[M]) {
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            } // the upper half is sorted
            else {
                if (arr[M] <= key && key < arr[L]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
        }
        return -1;
    }

    public static int findRotationPoint(int[] a, int N) {
        int L = 0;
        int R = N - 1;

        while (L <= R) {
            if (L == R) return L;
            int M = L + (R - L) / 2;

            if (a[M] > a[R]) {
                L = M + 1;
            } else {
                R = M;
            }
        }

        return L;
    }
}
