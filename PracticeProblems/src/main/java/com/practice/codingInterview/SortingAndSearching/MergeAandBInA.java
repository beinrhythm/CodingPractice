package com.practice.codingInterview.SortingAndSearching;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 *
 * Created by abhi.pandey on 1/5/15.
 */
public class MergeAandBInA {

    public static void mergeAandB(int[] A, int[] B, int n, int m) {
        int i = n - 1;
        int j = m - 1;
        int k = A.length-1;

        while(i>=0 && j>=0){
            if(A[i] > B[j]){
                A[k--] = A[i--];
            }else{
                A[k--] = B[j--];
            }
        }

        while(j>=0){
            A[k--] = B[j--];
        }



        for (int l = 0; l < A.length; l++) {
            System.out.println(A[l]);
        }
    }

    public static void main(String[] args) {
        int []A = new int[10];
        int []B = new int[5];
        A[0] = 2;A[1] = 4;A[2] = 6;A[3] = 8;A[4] = 10;
        B[0] =1; B[1] =3; B[2] =5; B[3] =7; B[4] =9;

        MergeAandBInA.mergeAandB(A, B, 5, 5);

    }
}
