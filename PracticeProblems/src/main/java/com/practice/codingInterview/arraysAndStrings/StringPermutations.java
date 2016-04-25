package com.practice.codingInterview.arraysAndStrings;

import java.util.ArrayList;

/**
 * Created by abhi.pandey on 12/28/14.
 */
public class StringPermutations {
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();

        if (n == 0) System.out.println(prefix);

        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    public static void permutation2(String s) {
        perm2(s.toCharArray(), s.length());
    }


    private static void perm2(char[] array, int length) {
        if (length == 1) {
            System.out.println(array);
            return;
        }

        for (int i = 0; i < length; i++) {
            swap(array, i, length - 1);
            perm2(array, length - 1);
            swap(array, i, length - 1);
        }
    }

    /*
    For example, if our string is “abc”, we would do the following:
    1 Let  first = “a” and let remainder = “bc”
    2 Let list = permute(bc) = {“bc”, “cd”}
    3 Push “a” into each location of “bc” (--> “abc”, “bac”, “bca”) and “cb” (--> “acb”, “cab”, “cba”)
    4 Return our new list
     */
    public static ArrayList<String> getPerms(String s) {
        ArrayList<String> permutations = new ArrayList<>();
        if (s == null) {// error case
            return null;
        } else if (s.length() == 0) {// base case
            permutations.add("");
            return permutations;
        }

        char first = s.charAt(0); // get the first character

        String remainder = s.substring(1);

        ArrayList<String> perms = getPerms(remainder);

        for (String perm : perms) {
            for (int i = 0; i <= perm.length(); i++) {
                String temp = new StringBuilder(perm).insert(i,first).toString();
                permutations.add(temp);
            }

        }

        return permutations;
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c;
        c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
        String a = "a   bc";
        System.out.println(StringPermutations.getPerms(a));
    }
}
