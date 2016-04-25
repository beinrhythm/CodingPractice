package com.practice.codingInterview.arraysAndStrings;

/**
 * Created by abhi.pandey on 11/24/14.
 */
public class UniqueCharacters {

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you can not use additional data structures?
     * @param input
     * @return
     */
    private boolean hasAllUniqueCharacters(String input){
        if(input == null  ||  input.isEmpty() || input.trim().isEmpty() || input.length() <= 1 ){
            return false;
        }


        char[] inputArray = input.toCharArray();

        boolean[] booleanArray = new  boolean[256];
        for(char a : inputArray){
            int val = a;
            if( booleanArray[val] != true) {
                booleanArray[val] = true;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueCharacters().hasAllUniqueCharacters(""));

    }
}
