package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/8/14.
 */
public class IsFibo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T;
        T = in.nextInt();
        if (1 <= T && T <= Math.pow(10, 5)) {
            List<Long> n = new ArrayList<Long>();
            for (int i = 0; i < T; i++) {
                long N = in.nextLong();
                if (1 <= N && N <= Math.pow(10, 10))
                    n.add(N);
            }
            solution(n);
        }


    }

    private static void solution(List<Long> n) {
        for (Long num : n) {

            long a = 0;
            long b = 1;
            long c;
            while (true) {
                c = a + b;
                if (c == num) {
                    System.out.println("IsFibo");
                    break;
                }
                if (c > num) {
                    System.out.println("IsNotFibo");
                    break;
                }
                a = b;
                b = c;
            }

        }
    }
}
