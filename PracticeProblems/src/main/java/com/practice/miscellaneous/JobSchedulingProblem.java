package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 1/31/15.
 */
public class JobSchedulingProblem {
    private boolean schedule(int i, int[] need, int[] capacity) {
        if(i>=need.length) return true;

        for(int k = 0; k < capacity.length; ++k) {
            if(capacity[k] > need[i]){
                capacity[k]  -= need[i];
                if(schedule(i+1, need, capacity)) return true;
                capacity[k] += need[i];
            }
        }



        return false;
    }

    public boolean schedule(int[] need, int[] capacity) {
        return getSum(capacity) >= getSum(need) && schedule(0, need, capacity);
    }

    private int getSum(int[] sample) {
        int sum = 0;
        for (int i : sample) {

            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] c = { 8, 16, 8, 32 };
        int []n = {18, 4, 8, 4, 6, 6, 8, 8 };
        System.out.println(new JobSchedulingProblem().schedule(n, c));
    }
}
