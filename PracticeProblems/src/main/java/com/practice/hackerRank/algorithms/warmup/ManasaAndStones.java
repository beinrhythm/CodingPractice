package com.practice.hackerRank.algorithms.warmup;

import java.util.*;

/**
 * Created by abhi.pandey on 8/3/14.
 */
public class ManasaAndStones {
    static Set<Integer> solution(List<Integer> input) {
        int N = input.get(0);
        int a = input.get(1);
        int b = input.get(2);
        SortedSet<Integer> output = new TreeSet<Integer>();
        output.add(a);
        output.add(b);

        for(int i = 2; i< N; i++){
            Iterator<Integer> it =  output.iterator();
            SortedSet<Integer> temp = new TreeSet<Integer>();
            while (it.hasNext()){
                int num = it.next();
                it.remove();
                temp.add(num+a);
                temp.add(num+b);

            }
            output.addAll(temp);
        }
        return  output;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        List<List<Integer>> inputs = new ArrayList<List<Integer>>();

        for (int i = 0; i < T; i++) {
            List<Integer> input = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++) {
                input.add(in.nextInt());
            }
            inputs.add(input);
        }
        for (List<Integer> input : inputs) {
            for(Integer o : solution(input)){
                System.out.print(o + "\t");
            }
            System.out.println();
        }
    }

}
