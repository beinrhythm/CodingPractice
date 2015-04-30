package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 2/1/15.
 */
public class SherlockAndSquares {
    static void solution(List<long[]> testCases) {

        for (long[] testCase : testCases) {
            long a = testCase[0];
            long b = testCase[1];
            int numberOfSquares = 0;

            if (a > 0 && b > 0 && a < b) {
                for (int i = 1; i < b; i++) {
                    int square = i * i;
                    if (square >= a && square <= b) {
                        numberOfSquares++;
                    } if(square > b){
                        break;
                    }
                }
            }


            System.out.println(numberOfSquares);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        List<long[]> input = new ArrayList();
        for (int i = 0; i < N; i++) {
            long a = in.nextInt();
            long b = in.nextInt();
            long[] sample = {a, b};
            input.add(sample);
        }


        SherlockAndSquares.solution(input);


    }
}
