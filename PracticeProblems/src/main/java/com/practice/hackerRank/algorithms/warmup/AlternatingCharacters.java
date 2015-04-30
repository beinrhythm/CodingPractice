package com.practice.hackerRank.algorithms.warmup;

import java.util.*;

/**
 * Created by abhi.pandey on 2/1/15.
 */
public class AlternatingCharacters {

    static void solution(List<String> testCases) {

        for (String testCase : testCases) {
            int numberOfDeletion = 0;

            char[] test = testCase.toCharArray();
            StringBuilder sb = new StringBuilder();

            char last = test[0];
            sb.append(last);
            for (int i = 1; i < test.length; i++) {
                if(test[i] != last){
                    sb.append(test[i]);
                    last = test[i];
                }else{
                    numberOfDeletion++;
                }

            }

            System.out.println(numberOfDeletion);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        List<String> input = new ArrayList();
        for (int i = 0; i < N; i++) {
            input.add(in.next());
        }

        AlternatingCharacters.solution(input);
    }
}
