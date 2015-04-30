package com.practice.codingInterview.stacksAndQueues;

/**
 * Created by abhi.pandey on 12/2/14.
 *
 * Describe how you could use a single array to implement three stacks.
 */
public class ThreeStacks {

    private int stackCapacity = 10;
    private int[] singleArray = new int[3 * stackCapacity];

    private int[] topIndex = {-1, -1, -1};

    public void push(int stackIdx, int value) {
        --stackIdx;
        int index = topIndex[stackIdx] + stackIdx * stackCapacity + 1;
        topIndex[stackIdx] = topIndex[stackIdx] + 1;
        singleArray[index] = value;


    }

    public int pop(int stackIdx) {
        int value = 0;
        if(!isEmpty(stackIdx)) {
            --stackIdx;
            int index = stackIdx * stackCapacity + topIndex[stackIdx];
            value = singleArray[index];
            topIndex[stackIdx] = topIndex[stackIdx] - 1;
            singleArray[index] = 0;
        }
        return value;
    }

    private boolean isEmpty(int stackIdx) {
        return topIndex[--stackIdx] == -1;


    }

    private int peek(int stackIdx){
        int value = 0;
        if(!isEmpty(stackIdx)) {
            --stackIdx;
            int index = stackIdx * stackCapacity + topIndex[stackIdx];
            value =  singleArray[index];
        }
        return  value;
    }

    public static void main(String[] args) {
        ThreeStacks t = new ThreeStacks();
        System.out.println(t.peek(1));
        t.push(1, 4);
        System.out.println(t.isEmpty(1));
        Long.valueOf("123");
        Long.parseLong("124");
       /* t.push(1, 4);
        t.push(1, 2);
        t.push(1, 3);
        t.push(2, 11);
        t.push(2, 13);
        t.push(2, 15);
        System.out.println(t.pop(1));
        System.out.println(t.pop(2));
        t.push(1, 9);
        t.push(2, 19);
        System.out.println(t.pop(2));
        System.out.println(t.pop(1));*/
    }

}
