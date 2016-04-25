package com.practice.codingInterview.SortingAndSearching;

/**
 * http://articles.leetcode.com/searching-element-in-rotated-array/
 * <p>
 * Created by abhi.pandey on 2/10/16.
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {6, 7, 8, 9, 1, 2, 3, 4, 5};
        System.out.println(findTarget(a, a.length, 2));
        System.out.println(findRotationPoint(a, a.length));
    }

    /*
    Find the middle value of the array a.
    If a[0] < a[mid], then all values in the first half of the array are sorted.
    If a[mid] < a[last], then all values in the second half of the array are sorted.
    Take the sorted half, and check whether your value lies within it (compare to the maximum idx in that half).
    If so, just search that half.
    If it doesn't, it must be in the unsorted half. Take that half and repeat this process, determining which half of that half is sorted, etc.
     */
    public static int findTarget(int[] a, int N, int key) {

        int L = 0;
        int R = N - 1;

        while (L <= R) {
            //Find the middle value of the array a.
            int M = L + (R - L) / 2;

            if (a[M] == key) return M;
            // If a[0] < a[mid], then all values in the first half of the array are sorted. left half is sorted
            if (a[L] <= a[M]) {

                if (key < a[M]) {// check whether your value lies within it (compare to the maximum idx in that half).
                    R = M - 1; //  If so, just search that half.
                } else {
                    L = M + 1; // If it doesn't, it must be in the unsorted half. Take that half and repeat this process, determining which half of that half is sorted, etc.
                }
            } // If a[mid] < a[last], then all values in the second half of the array are sorted.
            else {
                if (key < a[L]) {
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
