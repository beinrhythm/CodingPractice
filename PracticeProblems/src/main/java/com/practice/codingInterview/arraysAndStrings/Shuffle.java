package com.practice.codingInterview.arraysAndStrings;

import java.util.Random;

/**
 * Created by abhi.pandey on 12/24/14.
 */
public  class Shuffle {

    public int[] shuffle(int[] input){
        if(input.length <=1 ) return null;

        int length = input.length;
        Random rand = new Random();
        int random;
        for(int i = 0 ; i< length-1 ; i++){
            random = rand.nextInt(length);
            int temp = input[random] ;
            input[random]=  input[i];
            input[i] = temp;
        }

        return input;

    }

    public static void main(String[] args) {
        Shuffle s = new Shuffle();

        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        int j = 10;
        while (j >0) {
            int[] output = s.shuffle(input);
            for (int i : output) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            j--;
        }
    }

}
