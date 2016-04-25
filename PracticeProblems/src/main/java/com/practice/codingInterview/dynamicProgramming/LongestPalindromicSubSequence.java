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

    private static int findDP(char[] p) {
        int n = p.length;
        int i, j, cl;
        int L[][] = new int[n][n];  // Create a table to store results of subproblems


        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // http://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (p[i] == p[j] && cl == 2)
                    L[i][j] = 2;
                else if (p[i] == p[j])
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }
        }

        return L[0][n - 1];
    }


    public static void main(String[] args) {
        String s = "41234565434444444";
        System.out.println("Recursive - " + LongestPalindromicSubSequence.find(s));
        System.out.println("Dynamic Programing - " + LongestPalindromicSubSequence.findDP(s.toCharArray()));
    }
}
