package com.practice.hackerRank.algorithms.warmup;

import java.util.*;

/**
 * Created by abhi.pandey on 8/1/14.
 */
public class GameOfThrones1 {

    static String solution(String test) {
        String output = "NO";
        HashMap<Character, Integer> mapOfCharacterAndCounts = new HashMap<Character, Integer>();

        char[] testArray = test.toCharArray();
        for (int i = 0; i < testArray.length; i++) {
            Character ch = testArray[i];

            if (mapOfCharacterAndCounts.keySet().contains(ch)) {
                int value = mapOfCharacterAndCounts.get(ch);
                mapOfCharacterAndCounts.put(ch, value+1);
            } else {
                mapOfCharacterAndCounts.put(ch, 1);
            }
        }
        int count = 0;
        for (Character key : mapOfCharacterAndCounts.keySet()) {
            if (mapOfCharacterAndCounts.get(key) % 2 != 0) {
                count++;

            }
        }
        if (count <= 1) {
            output = "YES";
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String testCase;
        testCase = in.next();
        if (1 <= testCase.length() && testCase.length() < Math.pow(10, 5)) {
            System.out.println(solution(testCase));
        }
    }
}
