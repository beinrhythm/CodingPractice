package com.practice.interviewcake;

import java.util.HashMap;
import java.util.Stack;

/**
 * Let's say:
 * <p>
 * '(', '{', '[' are called "openers."
 * ')', '}', ']' are called "closers."
 * Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.
 * <p>
 * Examples:
 * <p>
 * "{ [ ] ( ) }" should return true
 * "{ [ ( ] ) }" should return false
 * "{ [ }" should return false
 * <p>
 * Created by abhi.pandey on 5/7/16.
 */
public class BracketValidator {
    private HashMap<Character, Character> openersMaps = new HashMap<>();
    private HashMap<Character, Character> closersMap = new HashMap<>();

    public static void main(String[] args) {
        BracketValidator bv = new BracketValidator();
        bv.initialize();
        String sample1 = "{[a](b)}";
        String sample2 = "{[(])}";
        String sample3 = "{[a}";

        System.out.println(bv.validate(sample1));
        System.out.println(bv.validate(sample2));
        System.out.println(bv.validate(sample3));
    }

    private boolean validate(String sample) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sample.length(); i++) {
            char ch = sample.charAt(i);
            if (openersMaps.containsKey(ch)) {
                stack.push(ch);
            } else if (closersMap.containsKey(ch)) {
                if (stack.peek().equals(closersMap.get(ch))) {
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0) return true;
        else {
            return false;
        }
    }

    private void initialize() {
        openersMaps.put('(', ')');
        openersMaps.put('{', '}');
        openersMaps.put('[', ']');
        closersMap.put(')', '(');
        closersMap.put('}', '{');
        closersMap.put(']', '[');
    }
}
