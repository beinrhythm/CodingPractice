package com.practice.codingInterview.dynamicProgramming;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * http://www.programcreek.com/2014/03/leetcode-house-robber-java/
 * Created by abhi.pandey on 5/15/16.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {50, 1, 1, 100, 500, 600};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        int ifRobbedPrevious = 0;   // max mo   ney can get if rob current house
        int ifDidntRobPrevious = 0; // max money can get if not rob current house

        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
        for (int i = 0; i < nums.length; i++) {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
            int currRobbed = ifDidntRobPrevious + nums[i];

            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

            // Update values for the next round
            ifDidntRobPrevious = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
    }

    /**
     * Let  M(k)M(k)  be the amount of money at the  kk th house, and  P(k)P(k)
     * be the maximum amount of money he can make if we consider only the first  kk  houses.  Then we have:
     * P(0)=0P(0)=0
     * P(1)=M(1)P(1)=M(1)
     * P(k)=max(P(k−2)+M(k),P(k−1))P(k)=max(P(k−2)+M(k),P(k−1))
     * (first case=rob the  kk th house, and some combination of the first  k−2k−2 ,
     * second case=don't rob  kk th house, and rob some combination of the first  k−1k−1 ).
     * Keep track of these decisions.
     *
     * @param amountPerHouse
     * @return
     */
    private static int robdp(int[] amountPerHouse) {

        if (amountPerHouse == null || amountPerHouse.length == 0) {
            return 0;
        }

        int houses = amountPerHouse.length;

        if (houses == 1) {
            return amountPerHouse[0];
        } else if (houses == 2) {
            return Math.max(amountPerHouse[0], amountPerHouse[1]);
        }

        int[] dp = new int[amountPerHouse.length];
        dp[0] = 0;
        dp[1] = amountPerHouse[0];

        for (int i = 2; i < houses; i++) {
            dp[i] = Math.max(dp[i - 2] + amountPerHouse[i], dp[i - 1]);
        }

        return dp[houses - 1];
    }


}
