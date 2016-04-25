package com.practice.codingInterview.arraysAndStrings;

/**
 * Created by abhi.pandey on 3/5/16.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String input = "dog is good";
        System.out.println(reverse(input));
    }

    private static String reverse(String input) {
        char[] wholeReverseString = doWholeReveresString(input.toCharArray(), 0, input.length());

        int start = 0;
        int end;

        while ((end = find(wholeReverseString, ' ', start)) != -1) {
            doWholeReveresString(wholeReverseString, start, end);
            start = end + 1;
        }

        doWholeReveresString(wholeReverseString, start, input.length());

        return new String(wholeReverseString);
    }

    private static int find(char[] arr, char c, int start) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == c) return i;
        }

        return -1;
    }

    private static char[] doWholeReveresString(char[] input, int startIndex, int stopIndex) {
        int start = startIndex;
        int last = stopIndex - 1;
        if (input.length > 0) {
            while (start <= last) {
                char temp = input[start];
                input[start] = input[last];
                input[last] = temp;
                start++;
                last--;
            }
        }
        return input;
    }
}
