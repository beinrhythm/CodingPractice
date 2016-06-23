package com.practice.companies.uber;

/**
 *  You have a sorted array of integers.
 *  Find the element where the array index is equal to the value of the corresponding element.
 *  Or return that no such element exists.
 * Created by abhi.pandey on 5/11/16.
 */
public class SearchNumberEqualIndexSortedArray {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, 3, 6, 8, 9, 10};
        System.out.println(search(a));
    }

    public static int search(int[] a) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {

            int m = l + (r - l) / 2;
            if (a[m] == m) return a[m];

            if (a[m] > m) {
                // go left
                r = m - 1;

            } else {
                // go right
                l = m + 1;
            }
        }
        return -1;
    }
}
