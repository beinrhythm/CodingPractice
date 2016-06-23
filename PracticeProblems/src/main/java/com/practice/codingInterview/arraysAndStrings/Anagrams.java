package com.practice.codingInterview.arraysAndStrings;

import java.util.*;

/**
 * Created by abhi.pandey on 11/24/14.
 */
public class Anagrams {

    /**
     * Write a method to decide if two strings are anagrams or not.
     *
     * @param text1
     * @param text2
     * @return true or false
     */
    private boolean isAnagrams(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text1.trim().isEmpty() || text1.length() <= 1) {
            return false;
        }

        if (text2 == null || text2.isEmpty() || text2.trim().isEmpty() || text2.length() <= 1) {
            return false;
        }

        if (text1.length() != text2.length()) {
            return false;
        }

        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        Arrays.sort(text1Array);
        Arrays.sort(text2Array);
        return (Arrays.equals(text1Array, text2Array));
    }

    public List<List<String>> groupAnagrams(List<String> words) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (words == null || words.size() == 0) {
            return result;
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            String temp = String.valueOf(arr);

            if(!map.containsKey(temp)){
                ArrayList<String> listOfAnagrams = new ArrayList<>();
                listOfAnagrams.add(word);
                map.put(temp, listOfAnagrams);
            }
                map.get(temp).add(word);

            /*if (map.containsKey(temp)) {
                ArrayList<String> tempList = map.get(temp);
                tempList.add(word);
                map.put(temp, tempList);

            } else {

                ArrayList<String> listOfAnagrams = new ArrayList<>();
                listOfAnagrams.add(word);
                map.put(temp, listOfAnagrams);
            }*/
        }

        Iterator iter = map.values().iterator();
        while (iter.hasNext()) {
            ArrayList<String> items = (ArrayList<String>) iter.next();
            result.add(items);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Anagrams().isAnagrams("abc", "aba"));

    }
}
