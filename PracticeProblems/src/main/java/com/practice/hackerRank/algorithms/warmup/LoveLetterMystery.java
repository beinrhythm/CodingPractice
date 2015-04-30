package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 7/29/14.
 */
public class LoveLetterMystery {
    static int solution(String input) {
        input = input.toLowerCase();
        int numberOfReductions = 0;
        int length = input.length();
        char[] sample = input.toCharArray();
        int i = 0;
        int j= length-1;

        while(i<=j){
            if(sample[i]!=sample[j]){
                numberOfReductions+= Math.abs( (int) sample[i] - (int) sample[j]);
            }
            i++;
            j--;
        }
        return numberOfReductions;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        if (1 <= N  && N <= 10) {
            List<String> testCases = new ArrayList<String>();
            for (int i = 0; i < N; i++) {
                String input = in.next();
                if(1<= input.length() && input.length()<= Math.pow(10,4)) {
                    testCases.add(input);
                }
            }
            for (String n : testCases) {
                System.out.println(solution(n));
            }
        }

    }
}
