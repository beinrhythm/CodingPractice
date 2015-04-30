package com.practice.codingInterview.arraysAndStrings;

/**
 * Created by abhi.pandey on 11/27/14.
 */
public class Problem7 {
    private boolean isRotation(String text1, String text2) {

        if (text1 == null || text1.isEmpty() || text1.trim().isEmpty() || text1.length() <= 1) {
            return false;
        }

        if (text2 == null || text2.isEmpty() || text2.trim().isEmpty() || text2.length() <= 1) {
            return false;
        }

        if(text1.length()!=text2.length()){
            return false;
        }

        if(text1.equals(text2)){
            return true;
        }

        if (isSubString((text1 + text1), text2)) {
            return true;
        }



        return false;


    }

    private boolean isSubString(String text, String pattern) {
        if (text == null || text.isEmpty() || text.trim().isEmpty() || text.length() <= 1) {
            return false;
        }

        if (pattern == null || pattern.isEmpty() || pattern.trim().isEmpty() || pattern.length() <= 1) {
            return false;
        }
        if (text.contains(pattern)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem7().isRotation("abhishek", "abhishek"));
    }
}
