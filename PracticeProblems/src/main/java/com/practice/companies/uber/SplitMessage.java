package com.practice.companies.uber;

import java.util.ArrayList;

/**
 * Created by abhi.pandey on 4/19/16.
 */
public class SplitMessage {
    private static ArrayList<String> GetChunks(String message, int messageLimit) throws Exception {
        ArrayList<String> result = new ArrayList<>();
        String[] listOfTotalWords = getListOfWords(message);
        StringBuilder sb = new StringBuilder();
        int bufferLimit = messageLimit;
        for (int i = 0; i < listOfTotalWords.length; i++) {
            String currentWord = listOfTotalWords[i];
            sb.append(currentWord).append(" ");
            bufferLimit = bufferLimit - currentWord.length() - 1;

            if (i + 1 < listOfTotalWords.length) {
                String nextWord = listOfTotalWords[i + 1];
                if (bufferLimit < nextWord.length()) {
                    result.add(sb.toString());
                    bufferLimit = messageLimit;
                    sb = new StringBuilder();
                }
            }
        }
        result.add(sb.toString());
        return result;
    }

    private static String[] getListOfWords(String message) {

        String[] listOfWords = message.split(" ");

        return listOfWords;
    }

    public static void main(String[] args) throws Exception {
        String message;
        message = "Hi Sivasrinivas, your Uber is arriving now! And this is a bigger text";
        int charLmit = 25;
        ArrayList<String> result = GetChunks(message, charLmit);
        for (String item : result) {
            System.out.println("Length = " + item.length() + " : " + item);
        }
        System.out.println(result.toString());
    }
}
