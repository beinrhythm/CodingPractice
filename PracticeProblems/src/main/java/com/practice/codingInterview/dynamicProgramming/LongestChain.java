package com.practice.codingInterview.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhi.pandey on 12/28/14.
 */
public class LongestChain {
    public static int find(List<ChainLink> list) {

        Collections.sort(list);

        int[] dp = new int[list.size()];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {

                if (list.get(j).bigger < list.get(i).smaller && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;

                }
            }
        }



        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;


    }

    public static void main(String[] args) {
        List<ChainLink> input = new ArrayList<>();

        input.add(new ChainLink(5, 24));
        input.add(new ChainLink(27, 40));
        input.add(new ChainLink(15, 25));
        input.add(new ChainLink(50, 60));
        System.out.println(LongestChain.find(input));
    }


}

class ChainLink implements Comparable {
    int smaller, bigger;

    public ChainLink(int a, int b) {
        this.smaller = a;
        this.bigger = b;
    }

    @Override
    public int compareTo(Object o) {
        ChainLink link = (ChainLink) o;
        return this.smaller > link.smaller ? 1 : this.smaller < link.smaller ? -1 : 0;
    }
}