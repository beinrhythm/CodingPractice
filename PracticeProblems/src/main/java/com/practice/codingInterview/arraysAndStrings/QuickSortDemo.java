package com.practice.codingInterview.arraysAndStrings;

import java.util.Arrays;

/**
 * Created by abhi.pandey on 8/31/14.
 */
public class QuickSortDemo {

    public static void main(String args[]) {
        // unsorted integer array
        int[] unsorted = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Unsorted array :" + Arrays.toString(unsorted));
        QuickSort algorithm = new QuickSort();
        // sorting integer array using quicksort algorithm
        algorithm.sort(unsorted);
        // printing sorted array
        System.out.println("Sorted array :" + Arrays.toString(unsorted));
    }
}

class QuickSort {

    private int input[];
    private int length;

    public void sort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        this.input = numbers;
        length = numbers.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int low, int high) {

        int i = low;
        int j = high;
        int pivot = input[(i + j) / 2];

        while (i <= j) {

            while (input[j] > pivot) {
                j--;
            }

            while (input[i] < pivot) {
                i++;
            }

            if (i <= j) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }


        }

        if(low<j) {
            quickSort(low, j);
        }

        if(i<high) {
            quickSort(i, high);
        }


    }


}



