package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 1/3/16.
 */
public class Palindrome {

    public boolean isPalindrome(final String str) {

        char[] temp = str.toCharArray();
        int i =0 ;
        int j= str.length()-1;

        while(i<=j){
            if(temp[i] != temp[j])
                return false;

            i++;j--;

        }
        return true;
    }
    public static void main(String arr[]){
        System.out.println(new Palindrome().isPalindrome("jahaj"));
    }
}
