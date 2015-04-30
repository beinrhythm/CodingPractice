package com.practice.codingInterview.recursion;

/**
 * Created by abhi.pandey on 1/5/15.
 */
public class EightQueen {
    private static int[] arrangement = new int[4];

    public static void place(int row){
        if(row ==4) {
            print ();
            return;
        }

        for(int i=0; i<4 ; i++){
            arrangement[row] =i;
            if(check(row)){
                place(row+1);
            }
        }


    }

    private static boolean check(int row) {
        for(int i =0; i<row; i++){
            int diff = Math.abs(arrangement[row]-arrangement[i]);
            return diff==0 || diff==Math.abs(row-i);
        }
        return true;
    }

    private static void print() {
        for(int i= 0; i< arrangement.length; i++){
            System.out.print(arrangement[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueen.place(0);
    }
}
