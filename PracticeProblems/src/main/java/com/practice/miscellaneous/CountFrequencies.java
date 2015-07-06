package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 7/5/15.
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 * Input: arr[] = {2, 3, 3, 2, 5}
 * Output: Below are frequencies of all elements
 * 1 -> 0
 * 2 -> 2
 * 3 -> 2
 * 4 -> 0
 * 5 -> 1
 */
public class CountFrequencies {
    public static void main(String[] args) {
        int[] input = {2, 3, 3, 2, 5};
        input = CountFrequencies.solve2(input);
        for (int i = 0; i < input.length; i++) {
            int number = i + 1;
            System.out.println(number + " frequency is = " + Math.abs(input[i]));
        }
    }

    public static int[] solve(int[] input) {
        if (input.length > 0) {
            int length = 1;
            for (int i = 0; i < input.length; i++) {
                if (length == input.length) break;
                if (input[i] > 0) {
                    int value = input[i];
                    int temp = input[--value];
                    if (temp < 0) {
                        input[value] = temp - 1;
                        input[i] = 0;
                    } else {
                        input[i] = temp;
                        input[value] = -1;
                        i = -1;
                    }

                } else {
                    length++;
                }

            }

        }

        return input;
    }

    public static int[] solve2(int[] input) {
        int length = input.length;
        int i = 0;
        while (i < length){

            if(input[i] <= 0){
                i++;
                continue;
            }

            int index = input[i] -1;

            int temp = input[index];

            if(temp > 0){
                input[i] = temp;
                input[index] = -1;
            }else{
                input[index] = temp -1;
                input[i] = 0;
            }

        }
        return input;
    }
}
