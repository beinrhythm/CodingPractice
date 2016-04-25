package com.practice.companies.uber;

import java.util.Stack;

/**
 * From a given input array, for each element, find next higher element present in each array.
 * For example {40,50,11,32,55,68,75} output should be {50,55,32,55,68,75,-1}.
 * For element if no higher element is present, print -1.
 * Complexity should be less than O(n^2). You can use data structures and no constraint on space complexity.
 * Created by abhi.pandey on 4/19/16.
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] input = {40, 50, 11, 32, 55, 68, 75};

        computeGreaterElementsArray(input);
    }

    private static int[] computeGreaterElementsArray(int[] input) {
        int[] output = new int[input.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(input[0]);
        for (int i = 1, j = 0; i < input.length && j < output.length; i++, j++) {

            if (stack.peek() != null) {
                while (true) {
                    if (stack.isEmpty() || stack.peek() > input[i]) {
                        break;
                    }
                    int temp = stack.pop();
                    output[j] = input[i];
                    System.out.println("for " + temp + " greater element = " + input[i]);
                }
            }
            stack.push(input[i]);

        }
        return output;
    }

}

