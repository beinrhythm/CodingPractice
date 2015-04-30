package com.practice.hackerRank.algorithms.warmup;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by abhi.pandey on 2/1/15.
 */
public class LonelyInteger {
    static int lonelyinteger(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            int count;
            if (!map.containsKey(i)) {
                count = 1;

            } else {
                count = map.get(i);
                count++;
            }
            map.put(i, count);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }

}
