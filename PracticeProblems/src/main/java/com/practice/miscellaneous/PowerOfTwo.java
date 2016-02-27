package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 10/9/15.
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while (n >= 2) {
            if ( n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(-16));
    }
}