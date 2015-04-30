package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 2/28/15.
 */
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();

            List<Integer> input = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                input.add(in.nextInt());
            }

            AngryProfessor.solution(input, M);

        }
    }

    public static void solution(List<Integer> studentTime, int studentsNeeded) {

        for (Integer st : studentTime) {
            if(st <= 0){
                studentsNeeded--;
            }
        }

        if (studentsNeeded > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
