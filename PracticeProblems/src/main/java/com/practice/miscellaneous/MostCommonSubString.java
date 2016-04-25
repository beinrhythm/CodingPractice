package com.practice.miscellaneous;

import java.util.HashMap;

/**
 * Created by abhi.pandey on 4/20/16.
 */
public class MostCommonSubString {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();
        int m = in.nextInt();
        String input = in.next();*/
        System.out.println(findOccurrencesOfMostCommonSubstring(1, 5, 26, "aoaoa"));
    }

    /* Given an input string of size n, return the number of occurrences
     * of the most common substring between lengths k,l.
     */
    public static int findOccurrencesOfMostCommonSubstring(int k, int l, int m, String input) {
        HashMap<String, Integer> substringMap = new HashMap<>();
        if (k < 0 || l > input.length()) return 0;

        int maxOccurrences = 1;

        // 1. Build every legal substring with lengths between k and l
        // 2. Place into map
        // 3. Increment count associated with the substring
        // 4. Determine if it is most common
        // 5. Return count for most common
        int inputLen = input.length();

        // i serves as our left-bound for the substrings
        for (int i = 0; i < inputLen; ++i) {

            // j serves as our right-bound for the substrings
            // 1. At each right-bound, create the longest legal substring that we can without
            //    walking past the end of the string.
            // 2. Insert it into the map.
            // 3. Update maxOccurrences
            // 4. When we're finished, return maxOccurrences.
            for (int j = k; j <= l && i + j < inputLen; ++j) {
                if (i < j) {
                    String current = input.substring(i, j);
                    if (countUniqueCharacters(current) <= m) {

                        // If 'current' isn't in the map, it will insert a value
                        // of 0. This means we can simply increment currentValue
                        // regardless of it being present in the map or not,
                        // and we'll achieve correct behavior in both cases.
                        if (!substringMap.containsKey(current)) {
                            substringMap.put(current, 0);
                        } else {
                            substringMap.put(current, substringMap.get(current) + 1);
                        }
                        int currentValue = substringMap.get(current);

                        maxOccurrences = (++currentValue > maxOccurrences) ? currentValue : maxOccurrences;
                    }
                }
            }
        }

        return maxOccurrences;
    }

    private static int countUniqueCharacters(String input) {
        boolean[] isItThere = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < input.length(); i++) {
            isItThere[input.charAt(i)] = true;
        }

        int count = 0;
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i] == true) {
                count++;
            }
        }

        return count;
    }


}
