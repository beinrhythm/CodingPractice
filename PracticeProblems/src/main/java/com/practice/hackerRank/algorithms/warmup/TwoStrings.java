package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 2/27/15.
 */
public class TwoStrings {


        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            int N = in.nextInt();
        List<List<String>> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<String> input = new ArrayList<>();
            input.add(in.next());
            input.add(in.next());
            inputs.add(input);
        }

        new TwoStrings().solution2(inputs);

    }

    public void solution(List<List<String>> inputs) {
        for (List<String> input : inputs) {
            if (input.size() == 2) {
                String first = input.get(0);
                String second = input.get(1);
                boolean success = false;

                if (first.length() > second.length()) {
                    char[] secondCharArray = second.toCharArray();
                    for (int i = 0; i < secondCharArray.length; i++) {
                        if (first.contains(String.valueOf(secondCharArray[i]))) {
                            success = true;
                            break;
                        }
                    }
                } else {
                    char[] firstCharArray = first.toCharArray();
                    for (int i = 0; i < firstCharArray.length; i++) {
                        if (second.contains(String.valueOf(firstCharArray[i]))) {
                            success = true;
                            break;
                        }
                    }
                }

                if (success) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public void solution2(List<List<String>> inputs) {
        for (List<String> input : inputs) {
            if (input.size() == 2) {
                String first = input.get(0);
                String second = input.get(1);
                boolean success = false;

                boolean hasLetter[] = new boolean[256];

                char[] firstCharArray = first.toCharArray();

                for (int i = 0; i < firstCharArray.length; i++) {
                    hasLetter[firstCharArray[i]] = true;
                }

                char[] secondCharArray = second.toCharArray();

                for (int i = 0; i < secondCharArray.length; i++) {
                    if (hasLetter[secondCharArray[i]] == true) {
                        success = true;
                        break;
                    }
                }
                if (success) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }


        }
    }
}
