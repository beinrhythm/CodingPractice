package com.practice.projectEuler;

/**
 * Created by abhi.pandey on 7/29/14.
 */
public class Problem2 {

    static int solution(int n) {
        int sum = 0;
        int a = 1;
        int b = 1;
        int c;
        while(true){
            c = a+b;
            if(c%2==0){
                sum+=c;
            }
            a=b;
            b=c;
            if(sum>n) break;
        }
            return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(4000000));
    }
}
