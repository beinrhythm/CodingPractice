package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 2/3/15.
 */
public class NumberToWord {

    public static void main(String[] args) {

        NumberToWord s = new NumberToWord();
        System.out.println(s.convert(29));
    }

    private static final String[] FIRST_TWENTY = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static final String[] TENS = {
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    public final static String ZERO = "zero";


    public String convert(int number) {

        StringBuffer str = new StringBuffer();

        if (number < 100 && number >= 0) {
            if (number == 0) {
                str.append(ZERO);
                return str.toString();
            }

            if (number < 20) {
                str.append(FIRST_TWENTY[number] + " ");

                return str.toString();
            }

            String numStr = Integer.toString(number);

            char[] chars = numStr.toCharArray();

            if (chars.length == 2) {
                str.append(TENS[Integer.parseInt(Character.toString(chars[0]))] + " ");

                str.append(FIRST_TWENTY[Integer.parseInt(Character.toString(chars[1]))] + " ");

                return str.toString();
            }

        }

        return str.toString();
    }
}
