package com.practice.codingInterview.SortingAndSearching;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given k sorted arrays of size n each, merge them and print the sorted output
 * <p/>
 * Created by abhi.pandey on 3/13/16.
 */
public class NWayMerge {
    public static void main(String[] args) {
        int[][] arrays = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}
        };
        int[] output = getSortedArrays(arrays);

        for (int element : output) {
            System.out.print(element + " ");
        }

    }

    static int[] getSortedArrays(int[][] arrays) {
        int k = arrays.length;
        int n = arrays[0].length;
        int[] output = new int[k * n];

        doMergeSortOfArrays(arrays, k, n, output);

        return output;
    }

    static void doMergeSortOfArrays(int[][] arrays,
                                    int k,
                                    int n,
                                    int[] output) {
        ElementSort esort = new ElementSort();
        //Step 1- create a priority queue
        PriorityQueue<ArrayElement> pq = new PriorityQueue<ArrayElement>(k, esort);

        /*
        Step 2-  Iterate through each array A and
        enqueue the pair (nextNumberIn(A), A) using the first value as priority key
         */

        for (int i = 0; i < k; i++) {
            pq.add(new ArrayElement(arrays[i][0], i, 0));
        }

        int count = 0;
        int totalElements = k * n;
        boolean[] finished = new boolean[k];

        /*
        Step 3 - While queue not empty
        dequeue head (m, A) of queue
        Insert m into result array
        if A not empty
        enqueue (nextNumberIn(A), A)
        */
        while (count < totalElements && !pq.isEmpty()) {
            ArrayElement delArrEle = pq.poll();
            int delElement = delArrEle.element;
            int delArrIndex = delArrEle.arrIndex;
            int delNextIndex = delArrEle.nextIndex;

            output[count] = delElement;
            count++;

            if (delNextIndex + 1 == n) {
                finished[delArrIndex] = true;
            }

            if ((delNextIndex + 1) < n || finished[delArrIndex] == false) {
                pq.add(new ArrayElement(arrays[delArrIndex][delNextIndex + 1], delArrIndex, delNextIndex + 1));
            }
        }
    }
}

class ElementSort implements Comparator<ArrayElement> {
    public int compare(ArrayElement ae1,
                       ArrayElement ae2) {
        return ae1.element - ae2.element;
    }
}

class ArrayElement {
    public int element;
    public int arrIndex;
    public int nextIndex;

    ArrayElement(int element,
                 int arrIndex,
                 int nextIndex) {
        this.element = element;
        this.arrIndex = arrIndex;
        this.nextIndex = nextIndex;
    }
}
