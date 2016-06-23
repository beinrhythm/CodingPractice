package com.practice.interviewcake;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewcake.com/question/java/permutation-palindrome
 * Write an efficient function that checks whether any permutation
 * of an input string is a palindrome.
 * Examples:
 * <p/>
 * "civic" should return true
 * "ivicc" should return true
 * "civil" should return false
 * "livci" should return false
 * <p/>
 * Created by abhi.pandey on 12/30/15.
 */

public class PermutationPalindrome {

    public static void main(String[] args) {
        String input = "ivicc";
        System.out.println(new PermutationPalindrome().solution(input));
    }

    private boolean solution(String input) {
        HashMap<Character, Boolean> parityMap = new HashMap<>();
        /*
        First, we iterate through our input string, keeping track of the parity
        As we iterate through the string:
        If we see a character that is not in the hash map, add it with the parity odd.
        If we see a character that is in the hash map, flip its parity.
         */
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (parityMap.containsKey(ch)) {
                if (!parityMap.get(ch)) {
                    parityMap.put(ch, true);
                } else {
                    parityMap.put(ch, false);
                }
            } else {
                parityMap.put(ch, false);
            }
        }
        /*
        Next, we iterate through our parity_map, confirming that each character,
        except the potential middle one, has an even parity.
         */
        boolean oddFlag = false;
        for (Map.Entry<Character, Boolean> entry : parityMap.entrySet()) {

            if (!entry.getValue()) {
                if (oddFlag) return false;
                else oddFlag = true;
            }

        }
        return true;
    }
}
