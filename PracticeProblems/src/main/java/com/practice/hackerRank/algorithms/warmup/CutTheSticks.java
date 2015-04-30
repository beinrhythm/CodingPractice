package com.practice.hackerRank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by abhi.pandey on 3/21/15.
 */
public class CutTheSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] input = new int[length];

        for (int i = 0; i < length; i++) {
            input[i] = in.nextInt();
        }
        CutTheSticks.solution(input);

    }

    static void solution(int[] input) {
        if (input.length == 0) {
            return;
        }
        if (input != null && input.length > 0) {
            int min = findMin(input);

            int count = 0;
            int nextLength = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] != 0) {
                    int diff = input[i] - min;
                    if (diff >= 0) {
                        count++;
                    }
                    if (diff > 0) {
                        nextLength++;
                    }

                    input[i] = input[i] - min;
                }
            }
            System.out.println(count);

            int[] newInput = new int[nextLength];

            int j = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] != 0) {
                    newInput[j] = input[i];
                    j++;
                }
            }

            solution(newInput);
        }
    }

    private static int findMin(int[] input) {
        int min = input[0];
        for (int i = 1; i < input.length; i++) {
            min = Math.min(min, input[i]);

        }
        return min;
    }

}
