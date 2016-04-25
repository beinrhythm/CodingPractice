package com.practice.companies.linkedin;

import java.util.HashMap;

/**
 * Given string say ABCGRETCABCG and substring length let us take length as 3,
 * find the count of possible substrings, for example in above string ABC => 2 and BCG => 2 ,
 * where CGR and other 3 word length substrings has a count of 1.
 * Created by abhi.pandey on 3/31/16.
 */
public class SubStringCount {
    public static void main(String[] args) {
        getCountOfPossSubstrs("ABCGRETCABCG", 3);
    }

    public static void getCountOfPossSubstrs(String input, int subsLength) {
        HashMap<String, Integer> mapOfSubstringAndCount = new HashMap<>();

        for (int i = 0; i + subsLength <= input.length(); i++) {
            String subString = input.substring(i, i + subsLength);

            if (mapOfSubstringAndCount.containsKey(subString)) {
                mapOfSubstringAndCount.put(subString, mapOfSubstringAndCount.get(subString) + 1);
            } else {
                mapOfSubstringAndCount.put(subString, 1);
            }
        }

        System.out.println(mapOfSubstringAndCount);
    }
}
