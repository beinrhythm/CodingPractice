package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/1/14.
 */
public class HalloweenParty {

    static long solution(long input) {
        long pieces;
        long half = input / 2;

        if (input % 2 == 0) {
            pieces = half * half;
        } else {
            pieces = half * (half + 1);
        }
        return pieces;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        if (1 <= N && N <= 10) {
            List<Long> testCases = new ArrayList<Long>();
            for (int i = 0; i < N; i++) {
                long input = in.nextInt();
                if (2 <= input && input <= Math.pow(10, 7)) {
                    testCases.add(input);
                }
            }
            for (Long n : testCases) {
                System.out.println(solution(n));
            }
        }

    }
}
