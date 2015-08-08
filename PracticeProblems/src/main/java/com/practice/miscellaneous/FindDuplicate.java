package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 4/27/15.
 */
public class FindDuplicate {

    public static void main(String s[]) {

        String str = "12311";

        find(str);

    }

    private static void find(String str) {
        long count = 0;

        for(int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if((count & (1 << c)) == 0) {
                count += (1 << c);

            } else {

                System.out.println("duplicate "+ c);

            }

        }
    }

    private static void find2(String str){

    }
}
