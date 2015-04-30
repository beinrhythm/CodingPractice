package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/2/14.
 */
public class ChocolateFeast {

    static int solution(List<Integer> input) {
        int N = input.get(0);
        int C = input.get(1);
        int M = input.get(2);
        int numberOfChocolates = 0;
        int D, R;

        if (2 <= N && N <= Math.pow(10, 5) && 1 <= C && C <= N && 2 <= M && M <= N) {
            D = N / C;
            R = 0;
            while (D != 0) {
                numberOfChocolates += D;
                if ((D+R) / M < 1) break;
                int temp = R;
                R = (D + R) % M;
                D = (D + temp) / M;
            }
        }
        return numberOfChocolates;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<List<Integer>> inputs = new ArrayList<List<Integer>>();

        for (int i = 0; i < T; i++) {
            List<Integer> input = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++) {
                input.add(in.nextInt());
            }
            inputs.add(input);
        }
        for (List<Integer> input : inputs) {
            System.out.println(solution(input));
        }
    }

}
