package com.practice.codingInterview.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhi.pandey on 12/26/14.
 */
public class MinCoinChange {
    private Integer[] coins = {1, 2, 3};

    private List<Integer> coinsList = Arrays.asList(coins);

    public int minCoins(int sum) {
        if(sum<=0) return 0;
        int min = minCoins(sum- coins[0]);

        for(int i=1; i<coins.length; i++){
            min = Math.min(min, minCoins(sum-coins[i]));
        }

        return min+1;
    }

    public int minCoins2(int sum){
        int numCoins;
        int minCoins = sum;
        if(coinsList.contains(sum)){
           return 1;
        }
        else{

            for (int i = 0; i < coins.length; i++) {
                numCoins = 1+ minCoins2(sum-coins[i]);
                if(numCoins<minCoins){
                    minCoins = numCoins;
                }
            }
        return minCoins;
        }
    }

    public static void main(String[] args) {

        System.out.println(new MinCoinChange().minCoins2(5));
    }

}
