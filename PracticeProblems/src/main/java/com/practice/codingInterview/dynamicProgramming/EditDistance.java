package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 12/27/14.
 */
public class EditDistance {

    public static int findRecursive(char[] A, int lengthOfA, char[] B, int lengthOfB) {
        if (lengthOfA == -1) return lengthOfB;
        if (lengthOfB == -1) return lengthOfA;


        int cost = 0;

        if (A[lengthOfA] != B[lengthOfB]) {
            cost = 1;
        }

        return min((findRecursive(A, lengthOfA - 1, B, lengthOfB - 1) + cost), //replacement needed or not
                (findRecursive(A, lengthOfA, B, lengthOfB - 1) + 1), // addition
                (findRecursive(A, lengthOfA - 1, B, lengthOfB) + 1)); //deletion


    }

    /**
     * if x == y, then dp[i][j] == dp[i-1][j-1]
     * if x != y, and we insert y for word1, then dp[i][j] = dp[i][j-1] + 1
     * if x != y, and we delete x for word1, then dp[i][j] = dp[i-1][j] + 1
     * if x != y, and we replace x with y for word1, then dp[i][j] = dp[i-1][j-1] + 1
     * When x!=y, dp[i][j] is the min of the three situations.
     * <p/>
     * Initial condition:
     * dp[i][0] = i, dp[0][j] = j
     *
     * @param A
     * @param b
     * @return
     */
    public static int findIterative(String A, String b) {
        int lenA = A.length();
        int lenB = b.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[lenA + 1][lenB + 1];


        for (int i = 0; i < lenA; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < lenB; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < lenA; i++) {
            char c1 = A.charAt(i);

            for (int j = 0; j < lenB; j++) {
                char c2 = b.charAt(j);
                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = min(replace, insert, delete);
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[lenA  ][lenB];

    }

    public static int find(String A, String B) {
        if (A != null && B != null) {
            char[] a = A.toCharArray();
            char[] b = B.toCharArray();

            int[][] dp = new int[a.length][b.length];

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    dp[i][j] = 0;
                }

            }

            int count = 0;

            for (int i = 1; i < a.length; i++) {
                for (int j = 1; j < b.length; j++) {
                    if (a[i] != b[j]) {
                        count = 1;
                    } else {
                        count = 0;
                    }

                    int replace = dp[i - 1][j - 1];
                    int insert = dp[i - 1][j];
                    int delete = dp[i][j - 1];

                    dp[i][j] = min(replace, insert, delete) + count;
                }
            }

            return dp[a.length - 1][b.length - 1];
        }
        return 0;
    }

    private static int min(int a, int b, int c) {
        if (a < b && a < c) return a;
        else if (b < c && b < a) return b;
        else return c;

    }

    public static void main(String[] args) {
        String a = "kitten";
        String b = "sitten";
        System.out.println(EditDistance.find(a, b));
        // System.out.println(EditDistance.findRecursive(a.toCharArray(), a.length() - 1, b.toCharArray(), b.length() - 1));

    }
}
