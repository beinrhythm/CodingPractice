package com.practice.codingInterview.stacksAndQueues;

import java.util.Stack;

/**
 * Created by abhi.pandey on 12/6/14.
 */
public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int n) {
        this.disks = new Stack<Integer>();
        this.index = n;
    }

    public static void main(String[] args) {
        int n = 5;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);
        towers[0].moveDisks(n, towers[2], towers[1]);
    }

    private void moveDisks(int n, Tower tower, Tower tower1) {

    }

    private void add(int i) {

    }
}
