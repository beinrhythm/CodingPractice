package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 8/8/15.
 */

/**
 * Search for Intersection Between Two Sorted Arrays of Integers
 * Example- there are two sorted arrays of integers such as array(1, 3, 6, 9, 10) and array(-2, 0, 4, 6, 12).
 * Search for the intersection between these arrays. The intersection is 6 at index 2 and index 3 in the example arrays.
 */
public class IntersectionSortedArray {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 6, 9, 10};
        int[] array2 = { -2, 0, 4, 6, 12};
        System.out.println(solution(array1, array2));

    }

    public static int solution(int[] array1, int[] array2) {
        if (array1 != null && array2 != null && array1.length > 0 && array2.length > 0) {

            int len1 = array1.length;
            int len2 = array2.length;
            int i = 0, j = 0;

            while (i < len1 && j < len2) {

                if (array1[i] == array2[j]) return array1[i];

                if (array1[i] < array2[j]) i++;

                else j++;
            }
        }
        return -1;
    }
}
