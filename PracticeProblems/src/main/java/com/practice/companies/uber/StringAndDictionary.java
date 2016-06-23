package com.practice.companies.uber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * For a given string and dictionary, how many sentences can you make from the string, such that all the words are contained in the dictionary.
 * <p/>
 * eg: for given string -> "appletablet"
 * "apple", "tablet"
 * "applet", "able", "t"
 * "apple", "table", "t"
 * "app", "let", "able", "t"
 * <p/>
 * "applet", {app, let, apple, t, applet} => 3
 * "thing", {"thing"} -> 1
 * <p/>
 * <p/>
 * Created by abhi.pandey on 4/8/16.
 */
public class StringAndDictionary {

    private static Set<String> dict = getDictionary();

    public static void main(String[] args) {
        String input = "iworkatabc";
        String input2 = "leetcode";
        Set<List<String>> answers = test(input2, new ArrayList<String>());
        System.out.println(TryToSegment(input2));
        if (answers.size() == 0) System.out.println(input2 + " : not a valid sentence");
        else {
            System.out.println("Total answers " + answers.size());
            for (List<String> list : answers) {
                for (String word : list) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }

    private static Set<String> getDictionary() {
        if (dict == null) {
            dict = new HashSet<>();
            dict.add("i");
            dict.add("like");
            dict.add("sam");
            dict.add("sung");
            dict.add("samsung");
            dict.add("mobile");
            dict.add("ice");
            dict.add("cream");
            dict.add("icecream");
            dict.add("man");
            dict.add("go");
            dict.add("mango");
            dict.add("app");
            dict.add("apple");
            dict.add("applet");
            dict.add("t");
            dict.add("a");
            dict.add("let");
            dict.add("able");
            dict.add("tablet");
            dict.add("work");
            dict.add("at");
            dict.add("uber");
            dict.add("leet");
            dict.add("code");
        }
        return dict;
    }

    private static Set<List<String>> test(String input, List<String> path) {
        Set<List<String>> result = new HashSet<>();
        if (input.length() > 0) {
            for (int i = 1; i <= input.length(); i++) {
                String prefix = input.substring(0, i);

                if (dict.contains(prefix)) {
                    path.add(prefix);
                    result.addAll(test(input.substring(i), new ArrayList<>(path)));
                }
            }
        } else {
            result.add(path);
        }
        return result;
    }

    public static boolean TryToSegment(String s) {
        if (dict.contains(s)) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                return  TryToSegment(s.substring(i));
            }
        }
        return false;
    }
}

