package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 12/22/14.
 */
public class FloydsTriangle {
    public void run(int level){
        int number = 1;

        for(int i = 1 ; i<= level;i++){
            for(int j = 1; j<= i ; j++ ){
                System.out.print(number++);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new FloydsTriangle().run(5);
    }


}
