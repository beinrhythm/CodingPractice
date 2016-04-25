package com.practice.codingInterview.arraysAndStrings;

import java.util.Arrays;

/**
 * Created by abhi.pandey on 11/24/14.
 */
public class Anagrams {

    /**
     * Write a method to decide if two strings are anagrams or not.
     * @param text1
     * @param text2
     * @return true or false
     */
    private boolean isAnagrams(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text1.trim().isEmpty() || text1.length() <= 1) {
            return false;
        }

        if (text2 == null || text2.isEmpty() || text2.trim().isEmpty() || text2.length() <= 1) {
            return false;
        }

        if (text1.length() != text2.length()) {
            return false;
        }

        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        Arrays.sort(text1Array);
        Arrays.sort(text2Array);
        return (Arrays.equals(text1Array, text2Array));
    }

    public static void main(String[] args) {
        System.out.println(new Anagrams().isAnagrams("abc", "aba"));

    }
}
