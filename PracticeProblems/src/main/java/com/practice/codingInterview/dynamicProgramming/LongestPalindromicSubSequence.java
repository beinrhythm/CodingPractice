package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 12/28/14.
 */
public class LongestPalindromicSubSequence {
    public static int find(String arr) {

        return findRecursive(arr, 0, arr.length() - 1);

    }

    private static int findRecursive(String arr, int i, int j) {

        //base case 1 : Every single character is a palindrome of length 1
        if (i == j) {
            return 1;
        }
        // base case 2 : Else if there are only two characters and both are same
        else if (arr.charAt(i) == arr.charAt(j) && j == i + 1) {
            return 2;
        }
        // If the first and last characters match
        else if (arr.charAt(i) == arr.charAt(j)) {
            return findRecursive(arr, i + 1, j - 1) + 2;
        }
        // If the first and last characters do not match
        return Math.max(findRecursive(arr, i + 1, j), findRecursive(arr, i, j - 1));
    }

    private static int findDP(char[] p, int n) {

        int m[][] = new int[n][n];

        int i, j, k, L, q;

    /* m[i,j] = Minimum number of scalar multiplications needed to compute
       the matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is
       p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L = 2; L < n; L++) {
            for (i = 1; i <= n - L + 1; i++) {
                j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }


    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        System.out.println(LongestPalindromicSubSequence.find(s));
    }
}
