package com.practice.codingInterview.arraysAndStrings;

import sun.lwawt.LWComponentPeer;

/**
 * Created by abhi.pandey on 12/17/14.
 */
public class Sorting {
    private int length;
    private int[] sample;

    public int[] mergeSort(int[] array) {
        // if the array has more than 1 element, we need to split it and merge the sorted halves
        if (array.length > 1) {
            // number of elements in sub-array 1
            // if odd, sub-array 1 has the smaller half of the elements
            // e.g. if 7 elements total, sub-array 1 will have 3, and sub-array 2 will have 4
            int firstHalfLength = array.length / 2;
            // we initialize the length of sub-array 2 to
            // equal the total length minus the length of sub-array 1
            int secondHalfLength = array.length - firstHalfLength;
            // declare and initialize the two arrays once we've determined their sizes
            int firstHalfArray[] = new int[firstHalfLength];
            int secondHalfArray[] = new int[secondHalfLength];
            // copy the first part of 'array' into 'arr1', causing arr1 to become full
            for (int i = 0; i < firstHalfLength; i++)
                firstHalfArray[i] = array[i];
            // copy the remaining elements of 'array' into 'arr2', causing arr2 to become full
            for (int i = firstHalfLength; i < firstHalfLength + secondHalfLength; i++)
                secondHalfArray[i - firstHalfLength] = array[i];
            // recursively call mergeSort on each of the two sub-arrays that we've just created
            // note: when mergeSort returns, arr1 and arr2 will both be sorted!
            // it's not magic, the merging is done below, that's how mergesort works :)
            firstHalfArray = mergeSort(firstHalfArray);
            secondHalfArray = mergeSort(secondHalfArray);

            // the three variables below are indexes that we'll need for merging
            // [i] stores the index of the main array. it will be used to let us
            // know where to place the smallest element from the two sub-arrays.
            // [j] stores the index of which element from arr1 is currently being compared
            // [k] stores the index of which element from arr2 is currently being compared
            int i = 0, j = 0, k = 0;
            // the below loop will run until one of the sub-arrays becomes empty
            // in my implementation, it means until the index equals the length of the sub-array
            while (firstHalfArray.length != j && secondHalfArray.length != k) {
                // if the current element of arr1 is less than current element of arr2
                if (firstHalfArray[j] < secondHalfArray[k]) {
                    // copy the current element of arr1 into the final array
                    array[i] = firstHalfArray[j];
                    // increase the index of the final array to avoid replacing the element
                    // which we've just added
                    i++;
                    // increase the index of arr1 to avoid comparing the element
                    // which we've just added
                    j++;
                }
                // if the current element of arr2 is less than current element of arr1
                else {
                    // copy the current element of arr1 into the final array
                    array[i] = secondHalfArray[k];
                    // increase the index of the final array to avoid replacing the element
                    // which we've just added
                    i++;
                    // increase the index of arr2 to avoid comparing the element
                    // which we've just added
                    k++;
                }
            }
            // at this point, one of the sub-arrays has been exhausted and there are no more
            // elements in it to compare. this means that all the elements in the remaining
            // array are the highest (and sorted), so it's safe to copy them all into the
            // final array.
            while (firstHalfArray.length != j) {
                array[i] = firstHalfArray[j];
                i++;
                j++;
            }
            while (secondHalfArray.length != k) {
                array[i] = secondHalfArray[k];
                i++;
                k++;
            }
        }
        // return the sorted array to the caller of the function
        return array;
    }


    public void sort(int[] sample) {
        if (sample == null || sample.length == 0) return;
        length = sample.length;
        this.sample = sample;
      //  quickSort(0, length - 1);
        //insertionSort();
        mergeSort(sample);

    }

   /* private void quickSort(int lowerIndex, int upperIndex) {

        int i = lowerIndex;
        int j = upperIndex;

        int pivot = sample[(i + j) / 2];

        while (i <= j) {

            while (sample[i] < pivot)
                i++;

            while (pivot < sample[j])
                j--;

            if (i <= j) {
                swap(i, j);

                i++;
                j--;
            }
        }


        if (i < upperIndex) {
            quickSort(i, upperIndex);
        }

        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }

    }*/

    private void quickSort(int lowerIndex, int upperIndex) {
        int l = lowerIndex;
        int u = upperIndex;
        int pivot = sample[(l + u) / 2];

        while (l <= u) {
            while (sample[l] < pivot) {
                l++;
            }

            while (pivot < sample[u]) {
                u--;
            }

            if (l <= u) {
                swap(l, u);
                l++;
                u--;
            }
        }

        if (l < upperIndex) {
            quickSort(l, upperIndex);
        }

        if (lowerIndex < u) {
            quickSort(lowerIndex, u);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < length; i++)
            for (int j = i; j > 0; j--) {
                if (sample[j] < sample[j - 1]) {
                    swap(j, j - 1);
                }
            }
    }

    private void swap(int i, int j) {
        int temp = sample[i];
        sample[i] = sample[j];
        sample[j] = temp;
    }

    public static void main(String[] args) {
        Sorting s = new Sorting();
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        s.sort(input);
        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

}
