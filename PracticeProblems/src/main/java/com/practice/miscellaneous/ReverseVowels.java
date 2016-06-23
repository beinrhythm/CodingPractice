package com.practice.miscellaneous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhi.pandey on 5/14/16.
 */
public class ReverseVowels {
    private static Set<Character> set;

    public static void main(String[] args) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
        set = new HashSet<>(Arrays.asList(vowels));
        String input = "leetcode";
        System.out.println(reverse(input));
    }

    private static String reverse(String input) {

        char[] ch = input.toCharArray();

        int i = 0, j = ch.length - 1;

        while (i <= j) {
            while (!set.contains(ch[i])) {
                i++;
            }

            while (!set.contains(ch[j])) {
                j--;
            }

            if(i<j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }else{
                break;
            }
        }

        return new String(ch);
    }
}
