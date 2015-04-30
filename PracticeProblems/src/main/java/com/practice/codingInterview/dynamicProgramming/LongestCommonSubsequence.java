package com.practice.codingInterview.dynamicProgramming;


/**
 * Created by abhi.pandey on 12/27/14.
 */
public class LongestCommonSubsequence {

    public static void commonSubsequence(String A, String B) {

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int[][] C = new int[A.length()][B.length()]; // Length of LCS of sequence A[1...i] and B[1....j]

        char[][] S = new char[A.length()][B.length()];// Position of LCS

        //initialize C to NxM matrix , each entry contains 0
        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                C[i][j] = 0;
            }
        }
        for (int i = 1; i < A.length(); i++) {
            for (int j = 1; j < B.length(); j++) {
                if (a[i] == b[j]) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    S[i][j] = 's';
                } else if (C[i][j - 1] > C[i - 1][j]) {
                    C[i][j] = C[i][j - 1];
                    S[i][j] = 'j';
                } else {
                    C[i][j] = C[i - 1][j];
                    S[i][j] = 'i';
                }
            }
        }
        printLCS(S, a, a.length - 1, b.length - 1);
    }

    private static void printLCS(char[][] s, char[] a, int i, int j) {
        if (i == 0 || j == 0) return;

        if (s[i][j] == 's') {
            printLCS(s, a, i - 1, j - 1);
            System.out.print(a[i]);
        } else if (s[i][j] == 'j') {
            printLCS(s, a, i, j - 1);
        } else {
            printLCS(s, a, i - 1, j);
        }
    }

    private static void printMatrix(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        String A = " ACCGGGTTAC";//to simplify notation first character is ignored
        String B = " AGGACCA";

        LongestCommonSubsequence.commonSubsequence(A, B);


    }
}
