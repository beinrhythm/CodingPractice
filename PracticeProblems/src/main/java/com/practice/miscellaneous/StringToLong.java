package com.practice.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhi.pandey on 12/3/14.
 */
public class StringToLong {
    private static final Map<Character, Integer> mapOfCharactersToNumbers = new HashMap<>();

    static {
        mapOfCharactersToNumbers.put('1', 1);
        mapOfCharactersToNumbers.put('2', 2);
        mapOfCharactersToNumbers.put('3', 3);
        mapOfCharactersToNumbers.put('4', 4);
        mapOfCharactersToNumbers.put('5', 5);
        mapOfCharactersToNumbers.put('6', 6);
        mapOfCharactersToNumbers.put('7', 7);
        mapOfCharactersToNumbers.put('8', 8);
        mapOfCharactersToNumbers.put('9', 9);
    }

    public static Long ToLong(String value) {
        value = value.trim().replaceAll("\\s+", "");

        if (value == null) {
            throw new NumberFormatException("null");
        }
        long result = 0;
        boolean negative = false;
        int i = 0, len = value.length();
        char digit;
        if (len > 0) {

            char firstChar = value.charAt(0);
            int j = len - 1;
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;

                } else if (firstChar != '+')
                    throw new NumberFormatException(value);

                if (len == 1)
                    throw new NumberFormatException(value);
                i++;
                j--;
            }


            while (i < len) {
                digit = value.charAt(i++);
                if (digit < 0) {
                    throw new NumberFormatException(value);
                }
                if(!mapOfCharactersToNumbers.containsKey(digit) ){
                    throw new NumberFormatException(value);
                }
                result += mapOfCharactersToNumbers.get(digit) * Math.pow(10, j--);
            }

        }

        if (negative) {
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        String val = "1234123412341";
        System.out.println(StringToLong.ToLong(val));
        System.out.println(Long.parseLong(val));
    }
}
