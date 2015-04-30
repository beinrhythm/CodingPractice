package com.practice.codingInterview.SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

/**Write a method to sort an array of strings so that all the anagrams are next to each other.
 *
 * Created by abhi.pandey on 1/5/15.
 */
public class AnagramComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return localSort(str1).compareTo(localSort(str2));
    }

    private String localSort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.copyValueOf(arr);
    }
}
