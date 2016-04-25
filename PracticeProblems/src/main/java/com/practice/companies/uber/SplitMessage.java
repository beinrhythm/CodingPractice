package com.practice.companies.uber;

import java.util.ArrayList;

/**
 * Created by abhi.pandey on 4/19/16.
 */
public class SplitMessage {
    private static ArrayList<String> GetChunks(String message, int messageLimit) throws Exception {
        ArrayList<String> result = new ArrayList();
        int mbX = 0, mbY = -1;
        do {
            mbX = mbY + 1;
            mbY = mbX + messageLimit;
            while (mbY >= mbX && mbY < message.length() && message.charAt(mbY--) != ' ') ;
            if (mbY < mbX) throw new Exception("Cannot chunk.");
            if (mbY >= message.length()) mbY = message.length();
            result.add(message.substring(mbX, mbY - mbX));
        } while (mbY >= message.length() - 1);
        return result;
    }

    public static void main(String[] args) throws Exception {
        String message;
        int charLmit;
        message = "Hi Srinivas, your Uber is arriving now! And this is a bigger text";
        charLmit = 25;
        ArrayList<String> result = GetChunks(message, charLmit);
        for(String item : result) {
            System.out.println("Length = " + item.length() + " : " +item  );
        }
        System.out.println(result.toString());
    }
}
