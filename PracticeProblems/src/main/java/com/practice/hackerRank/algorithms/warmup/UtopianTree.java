package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 7/27/14.
 */
public class UtopianTree {

    static int solution(int n) {
        int height= 1;
        for(int i = 0; i< n ; i++){
            if((i+1)%2==0){
                height++;
            }
            else{
                height*=2;
            }
        }
        return height;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases;
        testCases = in.nextInt();
        List<Integer> input = new ArrayList<Integer>();
        for(int i = 0; i<testCases; i++){
            input.add(in.nextInt());
        }

        for(Integer n : input){
            System.out.println(solution(n));
        }

    }
}
