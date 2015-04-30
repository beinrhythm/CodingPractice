package com.practice.hackerRank.algorithms.warmup;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by abhi.pandey on 8/1/14.
 */
public class MaximizingXOR {
    static int maxXor(int l, int r) {

        int output = 0;
        for (int j = r; j > l ; j--) {
            for (int i = l; i <=  r; i++) {
                int xor = i ^ j;
                if (xor > output) {
                    output = xor;
                }
            }

        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }

}
