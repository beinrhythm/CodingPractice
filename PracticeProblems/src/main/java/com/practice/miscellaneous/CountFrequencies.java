package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 7/5/15.
 * Given an unsorted array of n integers which can contain integers from 1 to n.
 * Some elements can be repeated multiple times and some other elements can be absent from the array.
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 * Input: arr[] = {2, 3, 3, 2, 5}
 * Output: Below are frequencies of all elements
 * 1 -> 0
 * 2 -> 2
 * 3 -> 2
 * 4 -> 0
 * 5 -> 1
 * http://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/
 */
public class CountFrequencies {
    public static void main(String[] args) {
        int[] input = {2, 3, 3, 2, 5};
        input = CountFrequencies.solve(input);
        for (int i = 0; i < input.length; i++) {
            int number = i + 1;
            System.out.println(number + " frequency is = " + Math.abs(input[i]));
        }
    }


    public static int[] solve(int[] arr) {
        int length = arr.length;
        // Initialize i as 0
        int i = 0;
        //Do following while i < n
        while (i < length) {

            // If this element is already processed, then nothing to do
            if (arr[i] <= 0) {
                i++;
                // continue the loop from beginning
                continue;
            }
            // Find index corresponding to this element, ex: index for 3 is 2
            int elementIndex = arr[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't loose anything.
            int temp = arr[elementIndex];

            if (temp > 0) {
                arr[i] = temp;
                // After storing arr[elementIndex], change it to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            } else {
                // If this is NOT first occurrence of arr[i], then increment its count.
                arr[elementIndex] = temp - 1;
                // And initialize arr[i] as 0 means the element 'i+1' is not seen so far
                arr[i] = 0;
            }

        }
        return arr;
    }
}
