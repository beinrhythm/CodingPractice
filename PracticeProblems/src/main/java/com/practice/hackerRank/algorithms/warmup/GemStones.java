package com.practice.hackerRank.algorithms.warmup;

import java.util.*;

/**
 * Created by abhi.pandey on 7/29/14.
 */
public class GemStones {
    static int solution(List<String> testCases) {
        int numberOfReductions = 0;
        HashMap<Character, Integer> mapOfCharacterAndCounts = new HashMap<Character, Integer>();

        for (String test : testCases) {
            test = removeDuplicates(test);
            char[] testArray = test.toCharArray();
            for (int i = 0; i < testArray.length; i++) {
                Character ch = testArray[i];

                if (mapOfCharacterAndCounts.keySet().contains(ch)) {
                    int value = mapOfCharacterAndCounts.get(ch);
                    mapOfCharacterAndCounts.put(ch, value + 1);
                } else {
                    mapOfCharacterAndCounts.put(ch, 1);
                }
            }
        }

        for (Character key : mapOfCharacterAndCounts.keySet()) {
            if (mapOfCharacterAndCounts.get(key) == testCases.size()) {
                numberOfReductions++;
            }
        }

        return numberOfReductions;
    }

    public static String removeDuplicates(String input) {
        char[] inputArray = input.toCharArray();
        HashSet<Character> uniqueCharacters = new LinkedHashSet<Character>();
        for (int i = 0; i < inputArray.length; i++) {
            uniqueCharacters.add(inputArray[i]);
        }
        StringBuilder sb = new StringBuilder();

        Iterator<Character> it = uniqueCharacters.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        N = in.nextInt();
        if (1 <= N && N <= 100) {
            List<String> testCases = new ArrayList<String>();
            for (int i = 0; i < N; i++) {
                String input = in.next();
                if (1 <= input.length() && input.length() <= 100) {
                    testCases.add(input.toLowerCase());
                }
            }
            System.out.println(solution(testCases));

        }

    }
}
