package com.practice.projectEuler;

/**
 * Created by abhi.pandey on 7/24/14.
 */
public class Problem1 {

    static int solution(int n) {
        int sum = 0;
        for(int i = 1; i < n; i++){
            if(i%3==0 || i%5==0){
                sum+=i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(1000));
    }
}
