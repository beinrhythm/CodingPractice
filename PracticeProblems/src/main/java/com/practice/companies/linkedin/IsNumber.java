package com.practice.companies.linkedin;

/**
 * Created by abhi.pandey on 4/5/16.
 */
public class IsNumber {

    /*Inspect each character and check
    1. Each character is number or '.' or '-'
    2. There has to be only '.'
    3. '-' has to appear first
    */
    public static boolean isNumber(String s) {

        char[] sample = s.toCharArray();
        if (sample.length == 0) return false;

        int i = 0;

        boolean dotFlag = false;
        boolean isNumberFlag = true;

        if (sample[i] == '-' || sample[i] == '+' ) {
            i++;
        }

        while (i < sample.length && isNumberFlag) {

            char c = sample[i];
            if (c >= '0' && c <= '9'){
                i++;
            }
            else if (c == '.') {
                if (dotFlag) {
                    isNumberFlag = false;

                } else {
                    dotFlag = true;
                    i++;
                }

            } else {
                //something else than number and dot
                isNumberFlag = false;
            }
        }

        if (!isNumberFlag)
            return false;
        else
            return true;
    }

    public static boolean isNumberRegex(String str) {
        if (str == null) return false;
        return str.split("(^-)?\\d+(\\.)*\\d*").length == 0;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("-12345"));
    }

}
