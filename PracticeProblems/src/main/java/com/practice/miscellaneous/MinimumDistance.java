package com.practice.miscellaneous;


/**
 * Created by abhi.pandey on 8/18/14.
 */
public class MinimumDistance {
    static void solution(int[] input, int a, int b) {
        int p = input.length, q = input.length;
        int minDistance = input.length;
        for (int i = 0; i < input.length; i++) {

            if (input[i] == a) {
                p = i;
            }

             if (input[i] == b) {
                q = i;
            }
            minDistance = Math.min(Math.abs(p - q), minDistance);
        }


        System.out.println(minDistance);

    }

    public static void main(String[] args) {
        int[] sample = {2, 1, 8, 5, 4, 0, 7, 5};

        solution(sample, 2, 5);

    }
}
