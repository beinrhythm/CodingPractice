package com.practice.miscellaneous;

import java.util.HashSet;

/**
 * Created by abhi.pandey on 4/4/16.
 */
public interface TwoSum {
    /**
     * Stores @param input in an internal data structure.
     */
    void store(int input);

    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    boolean test(int val);
}

class TwoSumImpl implements TwoSum {
    HashSet<Integer> list = new HashSet<>();

    @Override
    public void store(int input) {
        list.add(input);
    }

    @Override
    public boolean test(int val) {
        for (Integer i : list) {
            if (list.contains(val - i)) {
                return true;
            }
        }
        return false;
    }


}

class runner {
    public static void main(String[] args) throws java.lang.Exception {
        TwoSumImpl obj = new TwoSumImpl();
        obj.store(1);
        obj.store(-2);
        obj.store(3);
        obj.store(6);

        System.out.println("test val " + 4 + " result " + obj.test(4));
        System.out.println("test val " + -1 + " result " + obj.test(-1));
        System.out.println("test val " + 9 + " result " + obj.test(9));
        System.out.println("test val " + 10 + " result " + obj.test(10));
        System.out.println("test val " + 5 + " result " + obj.test(5));
        System.out.println("test val " + 0 + " result " + obj.test(0));

    }
}

