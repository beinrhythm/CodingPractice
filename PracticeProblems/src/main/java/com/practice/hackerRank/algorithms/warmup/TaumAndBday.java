package com.practice.hackerRank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by abhi.pandey on 3/22/15.
 */
public class TaumAndBday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long tests = in.nextLong();

        long b, w, x, y, z;
        for (long i = 0; i < tests; i++) {
            b = in.nextLong();
            w = in.nextLong();
            x = in.nextLong();
            y = in.nextLong();
            z = in.nextLong();
            TaumAndBday.solution(b, w, x, y, z);

        }
    }

    public static void solution(long b, long w, long x, long y, long z) {
        long count = 0;

        if (x > y && x > z || z == y) {
            if (x >= (y + z)) {
                count = b * (y + z) + w * y;
            } else {
                count = b * x + w * y;
            }
        } else if (y > x && y > z || z == x) {
            if (y >= (x + z)) {
                count = b * x + w * (x + z);
            } else {
                count = b * x + w * y;
            }
        } else {
            count = b * x + w * y;
        }

        System.out.println(count);

    }
}
