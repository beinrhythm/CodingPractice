package com.practice.miscellaneous;

/**
 * Problem -
 * I have an array stock_prices_yesterday where:
 * The indices are the time, as a number of minutes past trade opening time, which was 9:30am local time.
 * The values are the price of Apple stock at that time, in dollars.
 * For example, the stock cost $500 at 10:30am, so stock_prices_yesterday[60] = 500.
 * <p/>
 * Write an efficient algorithm for computing the best profit I could have made from 1 purchase and
 * 1 sale of 1 Apple stock yesterday. For this problem, we won't allow "shorting"—you must buy before you sell.
 * <p/>
 * Solution-
 * We walk through the array from beginning to end, keeping track of:
 * our min_price so far
 * our max_profit so far
 * For each time, we check to see if:
 * we have a new min_price, or
 * buying at the current min_price and selling at the current_price would give a new max_profit.\
 * O(n) time (we're only looping through the array once) and O(1) space.
 * <p/>
 * Created by abhi.pandey on 3/10/15.
 */
public class AppleStock {

    static void solution(int[] input) {
        int maxProfit = 0;
        int lowestSoFar = input[0];
        for (int i = 1; i < input.length; i++) {
            lowestSoFar = Math.min(lowestSoFar, input[i]);
            maxProfit = Math.max(maxProfit, (input[i] - lowestSoFar));
        }
        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        int[] sample = {2, 1, 8, 5, 4, 0, 7, 5};
        solution(sample);
    }
}
