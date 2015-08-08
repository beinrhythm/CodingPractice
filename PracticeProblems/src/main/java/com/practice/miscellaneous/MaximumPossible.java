package com.practice.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhi.pandey on 12/16/14.
 */
public class MaximumPossible {

    public static void solve (int [] input){
        Arrays.sort(input);
        int length = input.length - 1;
        List<Integer> temp = new ArrayList<>();

        for(int i = 0; i<=length; i++){
            if(input[i] <= length-i){
                temp.add(input[i]);
            }
        }

        System.out.println(findMax(temp));
    }

    private static int findMax(List<Integer> temp) {
        if(temp.isEmpty()) return 0;
        int max = temp.get(0);
        for(int i = 1 ; i<temp.size() ; i++){
            if(max < temp.get(i)){
                max = temp.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {1,4,2,1};
        MaximumPossible.solve(input);
         input = new int[]{1, 2, 3, 4};
        MaximumPossible.solve(input);
         input = new int[]{900, 2, 901, 3, 1000};
        MaximumPossible.solve(input);
        input = new int[]{900, 902, 901, 903, 1000};
        MaximumPossible.solve(input);
    }
}
