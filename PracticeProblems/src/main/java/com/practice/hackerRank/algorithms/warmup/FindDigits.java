package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/3/14.
 */
public class FindDigits {

    static int solution(Long num) {
        Long number = num;
        List<Integer> digits = new ArrayList<Integer>();
        List<Integer> output = new ArrayList<Integer>();
        while (num != 0) {
            digits.add((int) (num % 10));
            num = num / 10;
        }
        for (int d : digits) {
            if (d != 0) {
                if (number % d == 0) {
                    output.add(d);
                }
            }
        }

        return output.size();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases;
        testCases = in.nextInt();
        List<Long> input = new ArrayList<Long>();
        if (1 <= testCases && testCases <= 15) {
            for (int i = 0; i < testCases; i++) {
                long num = in.nextLong();
                if (0 < num && num < Math.pow(10, 10)) {
                    input.add(num);
                }
            }
        }

        for (Long n : input) {
            System.out.println(solution(n));
        }

    }
}
