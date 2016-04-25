package com.practice.codingInterview.recursion;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi.pandey on 12/30/14.
 */
public class SubsetsOfSet<T> {
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

    public ArrayList<ArrayList<T>> getSubSets(T[] set) {
        ArrayList<ArrayList<T>> result = new ArrayList<>();

        ArrayList<T> emptySet = new ArrayList<T>();
        result.add(emptySet);

        for (T element : set) {
            int curSize = result.size();
            for (int i = 0; i < curSize; i++) {
                ArrayList<T> current = new ArrayList<>(result.get(i));
                current.add(element);
                result.add(current);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        Integer[] source = {1, 2, 3};
        int[] source1 = {1, 2, 3};
        String sample = "abc";
        //    SubsetsOfSet.PrintSubsets(source1);
        ArrayList<ArrayList> results = new SubsetsOfSet().getSubSets(source);
        printResults(results);
        results = new SubsetsOfSet().getSubSets(ArrayUtils.toObject(sample.toCharArray()));
        printResults(results);


    }

    private static void printResults(ArrayList<ArrayList> results) {
        for (List a : results) {
            for (Object b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
}
