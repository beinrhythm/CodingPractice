package com.practice.codingInterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhi.pandey on 12/30/14.
 */
public class SubsetsOfSet {
    static void PrintSubsets(int[] source) {
        int length = source.length;
        int currentSubset = (int) Math.pow(2, source.length) - 1;
        int tmp;
        while (currentSubset > 0) {
            System.out.print("(");
            tmp = currentSubset;
            for (int i = 0; i < length; i++) {
                if ((tmp & 1) > 0)
                    System.out.print(source[i]);
                tmp >>= 1;
            }
            System.out.print(")\n");
            currentSubset--;
        }
    }

    public static ArrayList<ArrayList<Integer>> getSubSets(List<Integer> set) {

        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();
        allSubSets.add(new ArrayList<Integer>());
        for (int i = 0; i < set.size(); i++) {
            int curSize = allSubSets.size();
            for (int j = 0; j < curSize; j++) {
                ArrayList<Integer> cur = new ArrayList<>(allSubSets.get(j));
                cur.add(set.get(i));
                allSubSets.add(cur);
            }
        }


        return allSubSets;
    }


    static ArrayList<ArrayList<Integer>> getSubsets(List<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) {
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<Integer>()); // Empty set
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }


    public static void main(String[] args) {
        Integer[] source = {1, 2, 3};
        int[] source1 = {1, 2, 3};
        //   SubsetsOfSet.PrintSubsets(source1);
        ArrayList<ArrayList<Integer>> results = SubsetsOfSet.getSubSets(Arrays.asList(source));
        for (List<Integer> a : results) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }


    }
}
