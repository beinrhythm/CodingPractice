package com.practice.miscellaneous;

import java.util.*;

/**
 * Summarize the gaps in a sorted array that should ideally contain consecutive numbers from 1 to K.
 * For example when K=100, the array [3, 4, 5, 7, 75, 76] should give "1-2, 6, 8-74, 77-100" as output.
 * <p>
 * Created by abhi.pandey on 5/9/16.
 */
public class FindMissingNumbers {
    public static void main(String[] args) {
        int[] sample = {3, 4, 5, 7, 75, 76};
        int k = 100;
        findMissingNumbers2(sample, k);
    }

    public static void findMissingNumbers2(int[] a, int k) {
        int min, max;
        int j = 1, i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < a.length && j <= k) {
            if (a[i] != j) {
                min = j;
                j++;
            } else {
                max = j-1;
            }

        }
    }

    private static List<Integer> findMissingNumbers(int[] input, int k) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> inputSet = new HashSet<Integer>();

        for (int e : input) {
            inputSet.add(e);

        }
        for (int i = 1; i <= k; i++) {
            if (!inputSet.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static String findRangeOfMissingNumbers(int[] input, int k) {
        List<Integer> result = findMissingNumbers(input, k);

        List<LinkedHashSet<Integer>> endResult = new ArrayList<>();
        int j = 1;
        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        int i = 0;
        temp.add(result.get(i));
        while ((i + 1) < result.size() && j <= k) {
            if (result.get(i) != j) {
                temp.add(result.get(i - 1));
                endResult.add(temp);
                temp = new LinkedHashSet<>();
                temp.add(result.get(i));
                j = result.get(i);
            }
            i++;
            j++;
        }
        temp.add(result.get(i));
        endResult.add(temp);
        System.out.println(endResult);
        StringBuilder sb = new StringBuilder();
        for (Set<Integer> set : endResult) {
            for (int num : set) {
                sb.append(num).append("-");
            }
            sb.append(",");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}
