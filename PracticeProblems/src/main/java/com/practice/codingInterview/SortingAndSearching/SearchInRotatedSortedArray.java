package com.practice.codingInterview.SortingAndSearching;

/**
 * Created by abhi.pandey on 1/5/15.
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] array, int start, int end, int target) {

        while (start <= end) {
            int middle = start + end / 2;

            if(target==array[middle]){
                return middle;
            }
            else if (array[start] < array[middle]){

                if(target > array[middle]) start = middle + 1;

                else if(target >= array[start]) end= middle -1 ;

            }

            else{

            }


        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        SearchInRotatedSortedArray.search(array, 0, array.length - 1, 5);
    }
}
