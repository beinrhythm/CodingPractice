package com.practice.hackerRank.algorithms.warmup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/24/14.
 */
public class AngryChildren {
    static void solution(List<BigInteger> input, int K) {
        int i = 0;
        int result = input.get(K - 1).subtract(input.get(0)).intValue();
        while (K < input.size()) {
            int temp = input.get(K - 1).subtract(input.get(i++)).intValue();
            if (temp < result) {
                result = temp;
            }
            K++;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, K;
        N = in.nextInt();
        K = in.nextInt();
        if (1 <= N && N <= Math.pow(10, 5) && 1 <= K && K <= N) {
            List<BigInteger> testCases = new ArrayList<BigInteger>(N);
            BigInteger n;
            for (int i = 0; i < N; i++) {
                n = in.nextBigInteger();
                testCases.add(n);
            }
            Collections.sort(testCases);
            solution(testCases, K);
        }
    }
}

