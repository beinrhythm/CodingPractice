package com.practice.codingInterview.dynamicProgramming;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhi.pandey on 12/27/14.
 */
public class LongestIncreasingSubsequence {

    /**
     * O(nlogn) solution
     *
     * @param n
     * @return
     */
    public static List<Integer> lis(List<Integer> n) {
        List<Node<Integer>> pileTops = new ArrayList<Node<Integer>>();
        // sort into piles
        for (int x : n) {
            Node<Integer> node = new Node<Integer>();
            node.value = x;
            int i = Collections.binarySearch(pileTops, node);
            if (i < 0) i = ~i;
            if (i != 0)
                node.pointer = pileTops.get(i - 1);
            if (i != pileTops.size())
                pileTops.set(i, node);
            else
                pileTops.add(node);
        }
        // extract LIS from nodes
        List<Integer> result = new ArrayList<Integer>();
        for (Node<Integer> node = pileTops.size() == 0 ? null : pileTops.get(pileTops.size() - 1);
             node != null; node = node.pointer)
            result.add(node.value);
        Collections.reverse(result);
        return result;
    }

    private static class Node<E extends Comparable<? super E>> implements Comparable<Node<E>> {
        public E value;
        public Node<E> pointer;

        public int compareTo(Node<E> y) {
            return value.compareTo(y.value);
        }
    }

    /*
     O(n*n) solution
     */

    public static void find(int[] array) {
        int[] DP = new int[array.length];
        for (int i = 0; i < DP.length; i++) {
            DP[i] = 1;
        }
        for (int i = 1; i < DP.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && DP[j] + 1 > DP[i]) {
                    DP[i] = DP[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < DP.length; i++) {
            if (DP[i] > max) {
                max = DP[i];
            }
        }
        System.out.println(max);


    }

    public static void main(String[] args) {
        int[] sample = {2, 7, 3, 4, 9, 8, 12, 13, 11, 15};
        List<Integer> d = Arrays.asList(3, 2, 6, 4, 5, 1);
        //   System.out.println(LongestIncreasingSubsequence.lis(d));
        d = Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15);

        int[] s = {2, 6, 4, 3, 5, 7, 8, 1};
        LongestIncreasingSubsequence.find(s);
    }
}
