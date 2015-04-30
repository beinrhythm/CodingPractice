package com.practice.hackerRank.algorithms.warmup;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by abhi.pandey on 8/4/14.
 */
public class SherlockAndTheBeast {

    static BigInteger wrongSolution(int digits) {
        BigInteger number = BigInteger.valueOf(-1);
        List<Integer> result;
        int length = digits;
        if (digits > 2) {
            result = new ArrayList<Integer>(digits);
            int numberOfFives = 3;
            int numberOfThrees = 5;
            List<Integer> setOfFives = new ArrayList<Integer>(Collections.nCopies(3, 5));
            List<Integer> setOfThrees = new ArrayList<Integer>(Collections.nCopies(5, 3));
            while ((digits - numberOfFives) % 5 == 0 || digits > numberOfThrees) {
                digits -= numberOfFives;

                result.addAll(setOfFives);
            }
            while ((digits - numberOfThrees) % 3 == 0 && digits > 0) {
                digits -= numberOfThrees;

                result.addAll(setOfThrees);
            }
            System.out.println(result);
            if (result.size() == length) {
                number = BigInteger.ZERO;
                int j = 0;
                for (int i = result.size() - 1; i >= 0; i--) {
                    number = number.add(BigInteger.valueOf((long) (Math.pow(10, j) * result.get(i))));
                    j++;
                }

            }
        }

        return number;
    }

    static void solution1(int totalDigits) {

        int int3 = 0;
        int int5 = totalDigits;

        boolean answerSet = false;
        int i = 1;

        while (true) {
            if ((int5 >= 0 && int5 % 3 == 0) && (int3 >= 0 || int3 % 5 == 0)) {
                answerSet = true;
                break;
            } else {
                if (int5 < 0 || int3 > totalDigits) {
                    break;
                }
                int5 = totalDigits - i * 5;
                int3 = i * 5;
                i++;
            }

        }

        if (answerSet) {
            StringBuilder sb = new StringBuilder();
            if (int5 != 0) {
                for (int j = 0; j < int5; j++)
                    sb.append("5");
            }
            if (int3 != 0) {
                for (int j = 0; j < int3; j++)
                    sb.append("3");
            }
            System.out.println(sb);
        } else {
            System.out.println("-1");
        }

    }

    static void solution2(int totalDigits) {

        int count5 = totalDigits;
        int count3 = 5;
        int digits = totalDigits;
        int i = 1;
        while (true) {
            if (count5 % 3 != 0 && count3 % 5 == 0 && digits > 0) {
                digits -= count3;
                count3 *= i;
                count5 = digits;
                i++;
            } else {
                break;
            }
        }
        if (count5 == totalDigits || count5 < 0) {
            count3 = 0;
        }
        if (count5 < 0) {
            count5 = 0;
        }

        if (count3 == 0 && count5 == 0) {
            System.out.println("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count5; j++) {
                sb.append("5");
            }
            for (int j = 0; j < count3; j++) {
                sb.append("3");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        if (1 <= N && N <= 20) {
            List<Integer> testCases = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                int input = in.nextInt();
                if (1 <= input && input <= 100000) {
                    testCases.add(input);

                }
            }
            for (int testCase : testCases) {
                solution2(testCase);
            }
        }

    }
}
