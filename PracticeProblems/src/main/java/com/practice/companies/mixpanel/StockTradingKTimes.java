package com.practice.companies.mixpanel;

import java.util.*;

/**
 * Write another function that calculates the maximum profit with the additional constraint
 * that you can only make 4 total trades (2 buys and 2 sells) in the month. Generalized it to K times
 * <p>
 * Created by abhi.pandey on 4/21/16.
 */
public class StockTradingKTimes {

    /**
     * This is slow method but easier to understand.
     * Time complexity is O(k * number of days ^ 2)
     * T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m])) where m is 0...j-1
     */
    public double maxProfitSlowSolution(List<Double> costs, int K) {
        if (costs == null || K == 0 || costs.size() == 0) {
            return 0;
        }
        double T[][] = new double[K + 1][costs.size()];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                double maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, costs.get(j) - costs.get(m) + T[i - 1][m]);
                }
                T[i][j] = Math.max(T[i][j - 1], maxVal);
            }
        }
        printActualSolution(T, costs);
        return T[K][costs.size() - 1];
    }

    /**
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     * <p>
     * Formula is
     * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
     */
    public double maxProfit(List<Double> costs, int K) {
        if (costs == null || K == 0 || costs.size() == 0) {
            return 0;
        }
        double T[][] = new double[K + 1][costs.size()];

        for (int i = 1; i < T.length; i++) {
            double maxDiff = -costs.get(0);
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j - 1], costs.get(j) + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - costs.get(j));
            }
        }
        printActualSolution(T, costs);
        return T[K][costs.size() - 1];
    }

    private void printActualSolution(double T[][], List<Double> costs) {
        int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList<>();
        while (true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (T[i][j] == T[i][j - 1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                double maxDiff = T[i][j] - costs.get(j);
                for (int k = j - 1; k >= 0; k--) {
                    if (T[i - 1][k] - costs.get(k) == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.println("Buy at price " + costs.get(stack.pollFirst()));
            System.out.println("Sell at price " + costs.get(stack.pollFirst()));
        }

    }


    public static void main(String args[]) {
        List<Double> costs = new ArrayList<>();

        StockTradingKTimes stk = new StockTradingKTimes();

        double prices[] = {223600, 220980, 220450, 223480, 226680, 224675, 222424, 223000, 221878, 221510, 223615, 222636,
                222595, 226615, 225451, 225884, 223211, 218860, 221698, 217565};
        for (int i = 0; i < prices.length; ++i) {
            costs.add(prices[i]);
        }

        int numberOfTimes = 2;
        System.out.println("Max profit fast solution " + stk.maxProfit(costs, numberOfTimes));
        System.out.println("Max profit slow solution " + stk.maxProfitSlowSolution(costs, numberOfTimes));

    }
}
