package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 7/29/14.
 */
public class ServiceLane {
    static int solution(List<Integer> input, Integer... n) {
        int ii = n[0];
        int jj = n[1];
        int vehicle = input.get(ii);

        for (int i = ii; i <= jj; i++) {

            if (vehicle > input.get(i)) {
                vehicle = input.get(i);
            }
        }
        return vehicle;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, T;
        N = in.nextInt();
        T = in.nextInt();
        if (2 <= N  && N <= 100000 && 1 <= T && T <= 1000 ) {
            List<Integer> input = new ArrayList<Integer>();
            for(int i = 0; i<N; i++){
                int inp = in.nextInt();
                if(1 <= inp && inp <= 3) {
                    input.add(inp);
                }
            }
            List<Integer[]> testCases = new ArrayList<Integer[]>();
            for(int i = 0; i<T; i++){
                Integer[] ij = new Integer[2];
                for(int j=0;j<2;j++){
                    ij[j] = in.nextInt();
                }
                if(0 <= ij[0] && ij[0] < ij[1] && ij[1] < N) {
                    testCases.add(ij);
                }
            }

            for(Integer[] n : testCases){
                System.out.println(solution(input, n));
            }
        }

    }

}
