package com.practice.miscellaneous;

/**
 * Given two sorted arrays A, B of size m and n respectively.
 * Find the k-th smallest element in the union of A and B.
 * You can assume that there are no duplicate elements.
 * http://www.capacode.com/searching/k-th-element-of-two-sorted-arrays/#
 * <p/>
 * Created by abhi.pandey on 10/11/15.
 */
public class KthSmallestInTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 10};
        int[] b = {1, 3, 5, 7, 9};
        System.out.println(solution(a, b, 1));
    }

    /**
     * Complexity O(k)
     *
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int solution(int[] a, int[] b, int k) {
        int lenA = a.length;
        int lenB = b.length;
        int result = -1;
        if (k <= (lenA + lenB)) {
            int i = 0, j = 0;
            while (k > 0 && i < lenA && j < lenB) {
                if (a[i] < b[j]) {
                    result = a[i++];
                } else if (a[i] > b[j]) {
                    result = b[j++];
                } else {
                    result = a[i];
                    i++;
                    j++;
                }
                k--;
            }
            if (k > 0) {
                if (i == lenA) {
                    result = b[--k + j];
                }

                if (j == lenB) {
                    result = a[--k + i];
                }
            }
        }
        return result;
    }

    public static int solutionEfficient(int[] a, int[] b, int sizeA, int sizeB, int k) {
        if (sizeA > sizeB) {
            return solutionEfficient(b, a, sizeA, sizeB, k);
        }
        if (sizeA == 0 && sizeB > 0) {
            return b[k - 1];
        }
        if (k == 1) {
            return Math.min(a[0], b[0]);
        }

        int i = Math.min(sizeA, k/2);
        int j = Math.min(sizeB, k/2);

        if(a[i-1] < b[j-1]){

        }
        return 0;
    }
}
