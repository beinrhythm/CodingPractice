package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 11/21/14.
 */

    /*
    * Given a string S, you are allowed to convert it to a palindrome by adding 0 or more characters in front of it.
    * Find the length of the shortest palindrome that you can create from S by applying the above transformation.
    * */
public class ShortestPalindrome {


    public int getShortestFrontModdedPalen(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        int definatelyAdd = 0;
        int nonChanges = 0;
        int endPos = str.length() - 1;
        int frontPos = 0;
        while (endPos > frontPos) {
            if (str.charAt(endPos) == str.charAt(frontPos)) {
                nonChanges += 1;
                endPos--;
                frontPos++;
            } else {
                frontPos = 0;
                definatelyAdd += 1 + nonChanges;
                nonChanges = 0;
                endPos--;
            }
        }
        return definatelyAdd + str.length();
    }

    public int getShortestPalindromeLength(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        int count = 0;
        int endPos = str.length() - 1;
        int frontPos = 0;
        StringBuilder sb = new StringBuilder();

        sb.append(str);

        while (!isPalindrome(sb.toString()) && frontPos < endPos) {
            sb.insert(0, str.charAt(++frontPos));
            count++;
        }
        System.out.println(sb.toString());
        return count + str.length();
    }

    private boolean isPalindrome(String str) {
        int endPos = str.length() - 1;
        int frontPos = 0;
        while (endPos > frontPos) {
            if (str.charAt(frontPos++) != str.charAt(endPos--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestPalindrome obj = new ShortestPalindrome();
        obj.notifyAll();
        System.out.println(obj.getShortestFrontModdedPalen("abaa"));
    }
}
