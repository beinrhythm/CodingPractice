package com.practice.hackerRank.algorithms.warmup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/3/14.
 */
public class FillingJars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger N = in.nextBigInteger();
        BigInteger M = in.nextBigInteger();
        List<List<BigInteger>> inputs = new ArrayList<List<BigInteger>>();

        if (0 <= N.compareTo(BigInteger.valueOf(3)) && N.compareTo(BigInteger.valueOf(10000000)) <= 0 &&
                0 <= M.compareTo(BigInteger.ONE) && M.compareTo(BigInteger.valueOf(100000)) <= 0) {
            for (BigInteger i = BigInteger.valueOf(0);
                 i.compareTo(M) < 0;
                 i = i.add(BigInteger.ONE)) {

                List<BigInteger> input = new ArrayList<BigInteger>();
                for (int j = 0; j < 3; j++) {
                    input.add(in.nextBigInteger());
                }
                inputs.add(input);
            }

            System.out.println(solution(inputs, N));
        }
    }

    private static BigInteger solution(List<List<BigInteger>> inputs, BigInteger N) {

        BigInteger sum = BigInteger.ZERO;
        for (List<BigInteger> input : inputs) {
            BigInteger a = input.get(0);
            BigInteger b = input.get(1);
            BigInteger k = input.get(2);
            sum = sum.add((b.subtract(a).add(BigInteger.ONE)).multiply(k));

        }

        BigInteger avg = sum.divide(N);
        return avg;
    }
}
