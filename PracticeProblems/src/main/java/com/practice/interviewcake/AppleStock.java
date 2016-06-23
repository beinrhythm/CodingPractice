package com.practice.interviewcake;

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

    static int getMaxProfit(int[] stockPricesYesterday) {


        // make sure we have at least 2 prices
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

        // we'll greedily update minPrice and maxProfit, so we initialize
        // them to the first price and the first possible profit
        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy /and/ sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be /negative/--we'd return 0!
        for (int i = 1; i < stockPricesYesterday.length; i++) {
            int currentPrice = stockPricesYesterday[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);


        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] sample = {2, 3, 8, 5, 4, 0, 6, 1, 22, 15};
        int[] sample2 = {15, 9, 6, 4, 3};
        System.out.println(getMaxProfit(sample));
        System.out.println(getMaxProfit2(sample2));
    }

    static int getMaxProfit2(int[] input) {

        int maxProfit = input[1] - input[0];
        int lowestSoFar = input[0];
        for (int i = 1; i < input.length; i++) {
            maxProfit = Math.max(maxProfit, (input[i] - lowestSoFar));
            lowestSoFar = Math.min(lowestSoFar, input[i]);
        }
        return maxProfit;
    }
}
