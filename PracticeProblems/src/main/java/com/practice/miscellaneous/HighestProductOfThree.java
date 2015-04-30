package com.practice.miscellaneous;

/**
 * Problem -
 * Given an array_of_ints, find the highest_product you can get from three of the integers.
 * The input array_of_ints will always have at least three integers.
 * 
 * Solution-
 * We use a greedy approach to solve the problem in one pass. At each iteration we keep track of:
 * 
 * highest_product_of_3
 * highest_product_of_2
 * highest
 * lowest_product_of_2
 * lowest
 * 
 * When we reach the end, the highest_product_of_3 is our answer. We maintain the others because they're necessary for
 * keeping the highest_product_of_3 up to date as we walk through the array. At each iteration, the highest_product_of_3 is the highest of:
 * 
 * the current highest_product_of_3
 * current * highest_product_of_two
 * current * lowest_product_of_two (if current and lowest_product_of_two are both low negative numbers, this product is a high positive number).
 *
 * O(n) time and O(1) additional space.
 *
 * Created by abhi.pandey on 3/10/15.
 */
public class HighestProductOfThree {
    static void solution(int[] input) {
        if (input.length < 2) {
            System.out.println("Error");
        } else {
            int highest = Math.max(input[0], input[1]);
            int lowest = Math.min(input[0], input[1]);

            int highest_product_of_2 = input[0] * input[1];
            int lowest_product_of_2 = input[0] * input[1];

            int highest_product_of_3 = input[0] * input[1] * input[2];


            for (int i = 2; i < input.length; i++) {
                highest_product_of_3 = max(highest_product_of_3, highest_product_of_2 * input[i], lowest_product_of_2 * input[i]);
                highest_product_of_2 = max(highest_product_of_2, highest * input[i], lowest * input[i]);
                lowest_product_of_2 = min(lowest_product_of_2, highest * input[i], lowest * input[i]);
                highest = Math.max(highest, input[i]);
                lowest = Math.min(lowest, input[i]);
            }


            System.out.println(highest_product_of_3);
        }
    }

    private static int min(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else {
            if (b <= a && b <= c) {
                return b;
            } else {
                return c;
            }
        }
    }

    private static int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else {
            if (b >= a && b >= c) {
                return b;
            } else {
                return c;
            }
        }
    }

    public static void main(String[] args) {
        int[] sample = {1, 10, -5, 1, -100};
        solution(sample);
    }
}
