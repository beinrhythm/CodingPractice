package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 12/29/14.
 */
public class RopeCut {

   static int  maxProd(int n)
    {
        // n equals to 2 or 3 must be handled explicitly
        if (n == 2 || n == 3) return (n-1);

        // Keep removing parts of size 3 while n is greater than 4
        int res = 1;
        while (n > 4)
        {
            n -= 3;
            res *= 3; // Keep multiplying 3 to res
        }
        return (n * res); // The last part multiplied by previous parts
    }

    public static void main(String[] args) {
        System.out.println(RopeCut.maxProd(13));
    }
}
