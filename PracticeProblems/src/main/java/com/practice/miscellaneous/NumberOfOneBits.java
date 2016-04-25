package com.practice.miscellaneous;

/**
 * Write a function that takes an unsigned integer and returns
 * the number of ’1' bits it has (also known as the Hamming weight).
 * <p/>
 * <p/>
 * Created by abhi.pandey on 3/24/16.
 */
public class NumberOfOneBits {
    public static void main(String[] args) {
        System.out.println(number_of_ones(11));
    }
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 1; i < 33; i++) {
            if (getBit(n, i) == true) {
                count++;
            }
        }
        return count;
    }

    private static boolean getBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static int number_of_ones( int n){
        int count = 0;
        while(n !=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
