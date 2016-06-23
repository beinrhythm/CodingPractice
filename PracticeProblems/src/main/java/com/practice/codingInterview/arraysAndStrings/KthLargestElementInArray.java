package com.practice.codingInterview.arraysAndStrings;


import java.util.PriorityQueue;

/**
 * Created by abhi.pandey on 5/8/16.
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(find(a, 2));
    }

    public static int find(int[] a, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i : a) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }
}
