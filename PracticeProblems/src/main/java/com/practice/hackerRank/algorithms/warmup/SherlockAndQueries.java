package com.practice.hackerRank.algorithms.warmup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/24/14.
 */
public class SherlockAndQueries {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N, M;

        N = in.nextInt();
        M = in.nextInt();
        int[] A = new int[N], B = new int[M], C = new int[M];

        if (1 <= N && N <= Math.pow(10, 5) && 1 <= M && M <= Math.pow(10, 5)) {
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                C[i] = in.nextInt();
            }
            solution(A, B, C);
        }
    }

    private static void solution(int[] A, int[] B, int[] C) {
        int M = B.length;
        int N = A.length;
        for(int i = 0 ; i<M; i++){
            for(int j = 0; j<N; j++){
                if(j%B[i]==0){
                    A[j] = A[j]*C[i];
                }
            }
        }

        for(int i = 0; i< N ; i++){
            System.out.println(A[i]);
        }
    }
}
