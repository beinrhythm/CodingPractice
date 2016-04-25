package com.practice.codingInterview.arraysAndStrings;

/**
 * Created by abhi.pandey on 11/25/14.
 */
public class ReplaceSpace {
    /**
     *Write a method to replace all spaces in a string with ‘%20’.
     * @param text1
     * @param text2
     * @return
     */
    private String replaceAll(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text1.trim().isEmpty() || text1.length() <= 1) {
            throw new NullPointerException("The text passed is empty or null");
        }

        if (text2 == null || text2.isEmpty() || text2.trim().isEmpty() || text2.length() <= 1) {
            throw new NullPointerException("The text passed is empty or null");
        }

        char[] text = text1.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char t : text){
            if(t == ' '){
                sb.append(text2);
            }else{
                sb.append(t);
            }
        }

        String output = sb.toString();
        return output;


    }

    public static void main(String[] args) {
        String replaceWith = "%20";
        String text = "hello how are you";
        System.out.println(new ReplaceSpace().replaceAll(text, replaceWith));

    }
}
