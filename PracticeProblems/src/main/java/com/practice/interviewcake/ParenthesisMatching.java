package com.practice.interviewcake;

/**
 * "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."
 * Write a function that, given a sentence like the one above, along with the position of an opening parenthesis,
 * finds the corresponding closing parenthesis.
 * Example: if the example string above is input with the number 10 (position of the first parenthesis),
 * the output should be 79 (position of the last parenthesis).
 * Created by abhi.pandey on 5/15/16.
 */
public class ParenthesisMatching {
    public static void main(String[] args) {
        String input = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        int openingIndex = 57;
        System.out.println(getClosingIndex(input, openingIndex));
    }

    /*
    We simply walk through the the string, starting at our input opening parenthesis position.
    As we iterate, we keep a count of how many additional "(" we find as open_nested_parens. When we find a ")"
    we decrement open_nested_parens. If we find a ")" and open_nested_parens is 0, we know that ")"
    closes our initial "(", so we return its position.
     */
    private static int getClosingIndex(String input, int openingIndex) {
        int numberOfOpenParenthesis = 0;

        for (int i = 0 + openingIndex; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                numberOfOpenParenthesis++;

            } else if (input.charAt(i) == ')') {
                if (numberOfOpenParenthesis == 1) {
                    return i;
                } else {
                    numberOfOpenParenthesis--;
                }
            }
        }
        return -1;
    }

}
