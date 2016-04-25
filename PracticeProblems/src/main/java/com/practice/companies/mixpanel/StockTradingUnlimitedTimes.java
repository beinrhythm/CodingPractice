package com.practice.companies.mixpanel;

/**
 * Here is a list of the daily closing prices for Berkshire Hathaway (BRK­A) stock during January 2015
 * <p>
 * [223600, 220980, 220450, 223480, 226680, 224675, 222424, 223000, 221878, 221510, 223615, 222636,
 * 222595, 226615, 225451, 225884, 223211, 218860, 221698, 217565]
 * Imagine you have built a time machine and you write down these numbers at the end of the month,
 * and then jump back in time to the beginning of the month. You are now going to use your time travel
 * powers to make a huge profit on the stock market!
 * <p>
 * Write a function that computes the maximum profit you could make trading on this series of prices.
 * You can buy and sell the stock as many times as you want and there is no fee to buy or sell,
 * but you can only own 1 share of the stock at a time (i.e. you must sell before you can buy again).
 * <p>
 * Created by abhi.pandey on 4/21/16.
 */
public class StockTradingUnlimitedTimes {

    /*This is like accumulating the profit I get every day.
     Although this alg. by pass the exact days I buy and sell, but it answers the max profit I potentially get
     We can scan the array once, and find all pairs of elements that are in ascending order.
     */
    public int maxProfit(int costs[]) {

        // return 0 if array is null of we have just one element in the array of prices.
        if (costs == null || costs.length <= 1) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < costs.length; i++) {
            int diff = costs[i] - costs[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        StockTradingUnlimitedTimes stu = new StockTradingUnlimitedTimes();
        int prices[] = {223600, 220980, 220450, 223480, 226680, 224675, 222424, 223000, 221878, 221510, 223615, 222636,
                222595, 226615, 225451, 225884, 223211, 218860, 221698, 217565};
        System.out.println(stu.maxProfit(prices));
    }
}
