package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 2/1/15.
 */
public class ACMICPCTeam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, M;
        N = in.nextInt();
        M = in.nextInt();

        List<List<Integer>> input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> row = null;
            for (int j = 0; j < M; j++) {
                row = new ArrayList<>();
                row.add(in.nextInt());
            }
            input.add(row);
        }

        ACMICPCTeam.solution(input);

    }


    public static void solution(List<List<Integer>> input) {
        for (List<Integer> row : input) {
            for (Integer column : row) {
                System.out.println(column);
            }

        }
    }
}
