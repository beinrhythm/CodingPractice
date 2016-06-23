package com.practice.codingInterview.arraysAndStrings;

/**
 * Look last element, then say its count and number.
 * [1], [1,1], [2,1], [1,2,1,1], [1,1,1,2,2,1], [3,1,2,2,1,1]
 * Created by abhi.pandey on 3/24/16.
 */
public class LookAndSay {
    public static void main(String[] args) {

      System.out.println((lookAndSay(7)));
    }

    public static String lookAndSay(int num) {
        String s = "1";
        for (int i = 1; i < num; i++) {
            s = compute(s);
        }
        return s;
    }

    private static String compute(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            result.append(count).append(s.charAt(i));

        }
        return result.toString();
    }
}
