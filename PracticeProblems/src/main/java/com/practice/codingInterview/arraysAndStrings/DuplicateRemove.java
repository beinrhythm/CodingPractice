package com.practice.codingInterview.arraysAndStrings;

import java.util.HashSet;

/**
 * Created by abhi.pandey on 11/24/14.
 */
public class DuplicateRemove {
    /**
     * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
     * NOTE: One or two additional variables are fine. An extra copy of the array is not.
     * @param input
     * @return true of false
     */
    private String removeDuplicate(String input){
        if(input == null  ||  input.isEmpty() || input.trim().isEmpty() || input.length() <= 1 ){
            return input;
        }

        char[] inputArray = input.toCharArray();
        HashSet<Character> setOfFoundCharacters = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char a : inputArray){

            if( !setOfFoundCharacters.contains(a)) {
                setOfFoundCharacters.add(a);
                sb.append(a);

            }


        }
        String output = sb.toString();
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new DuplicateRemove().removeDuplicate("aaaaa"));

    }
}
