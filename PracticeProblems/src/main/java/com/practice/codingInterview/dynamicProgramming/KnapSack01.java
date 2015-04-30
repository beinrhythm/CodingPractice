package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 12/28/14.
 */
public class KnapSack01 {
    public static int find(int W, int wt[], int val[], int n) {
        int K[][] = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (w >= wt[i - 1])
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]],
                                        K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(KnapSack01.find(W, wt, val, n));
    }
}
