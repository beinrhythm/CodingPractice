package com.practice.hackerRank.algorithms.arraysAndSorting;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/24/14.
 */
public class MarkAndToys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long N, K;
        N = in.nextLong();
        K = in.nextLong();
        if (1 <= N && N <= Math.pow(10, 5) && 1 <= K && K <= Math.pow(10, 9)) {
            List<Long> testCases = new ArrayList<Long>();
            Long n;
            for (long i = 0; i < N; i++) {
                n = in.nextLong();
                testCases.add(n);
            }
            Collections.sort(testCases);
            solution(testCases, K);
        }
    }

    private static void solution(List<Long> testCases, Long k) {

        long count = 0;
        int i = 0;
        while (k > 0 && k > testCases.get(i)) {
            k = k - testCases.get(i++);
            count++;
        }
        System.out.println(count);
    }
}
