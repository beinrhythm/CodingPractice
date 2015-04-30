package com.practice.miscellaneous;

/**
 Problem -
 You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
 Write a function get_products_of_all_ints_except_at_index() that takes an array of integers and returns an array of the products.
 Do not use division in your solution.

 Solution -
 To find the products of all the integers except the integer at each index, we'll go through our array greedily twice.
 First we get the products of all the integers before each index, and then we go backwards to get the products of all
 the integers after each index.
 When we multiply all the products before and after each index, we get our answer—the products of all the integers
 except the integer at each index!

 O(n) time and O(n) space

 *  Created by abhi.pandey on 3/10/15.
 */
public class ProductOfAllOtherNumbers {

    static void solution(int[] input) {
        int productOfAllNumbersExceptAtIndex[] = new int[input.length];
        int product =1;
        for (int i = 0; i < input.length; i++) {
            productOfAllNumbersExceptAtIndex[i] = product;
            product = product * input[i];
        }
        product = 1;
        for (int i = input.length-1; i >=0; i--) {
            productOfAllNumbersExceptAtIndex[i] = productOfAllNumbersExceptAtIndex[i] * product;
            product = product * input[i];

        }
        for (int i = 0; i < productOfAllNumbersExceptAtIndex.length; i++) {
            System.out.print(productOfAllNumbersExceptAtIndex[i]);
            System.out.print(",");
        }
    }

    public static void main(String[] args) {
        int[] sample = {  1, 7, 3, 4};
        solution(sample);
    }
}
