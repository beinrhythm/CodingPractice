package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 8/7/14.
 */
public class SherlockAndGCD {

    static void solution(List<Integer> input) {
        String ans = "NO";
        int num = 2;
        if (input.size() > 0) {
            ans = recursive(input);
        }
        System.out.println(ans);

    }

    private static String recursive(List<Integer> input) {
        if(input.size()==1 && input.get(0)>1){
           return "YES";
        }
        int[] arr = new int[input.size()];

        for(int i = 0; i < input.size(); i++) {
            if (input.get(i) != null) {
                arr[i] = input.get(i);
            }
        }
        recursive(arr);
        return "NO";
    }

    private static void recursive(int[] array) {
        int numOfSubsets = 1 << array.length;

        for(int i = 0; i < numOfSubsets; i++)
        {
            int pos = array.length - 1;
            int bitmask = i;

            StringBuilder sb = new StringBuilder();
            sb.append("{");

            while(bitmask > 0)
            {
                if((bitmask & 1) == 1)
                   sb.append(array[pos]+",");
                bitmask >>= 1;
                pos--;
            }
            sb.append("}");
            System.out.println(sb);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T;
        T = in.nextInt();
        if (1 <= T && T <= 10) {
            List<List<Integer>> testCases = new ArrayList<List<Integer>>(T);
            for (int i = 0; i < T; i++) {
                int N = in.nextInt();
                if (1 <= N && N <= 100) {
                    List<Integer> test = new ArrayList<Integer>(N);
                    for (int j = 0; j < N; j++) {
                        int num = in.nextInt();
                        if (1 <= num && num <= 100000) {
                            test.add(num);
                        }
                    }
                    testCases.add(test);
                }

            }

            for (List n : testCases) {
                solution(n);
            }
        }

    }
}
