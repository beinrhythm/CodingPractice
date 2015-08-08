package com.practice.miscellaneous;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhi.pandey on 10/27/14.
 */
public class FindMaxOccurrences {

    public static List<String> getMaxOccurredWords(String text, int numberOfWords) {
        try {
            if (text == null || text.isEmpty() || text.trim().isEmpty()) {
                throw new NullPointerException("The text passed is empty or null");
            }

            if (numberOfWords <= 0) {
                throw new IllegalArgumentException("Number of words has to be greater than zero");
            }

            String[] words = text.trim().split("[ \"\" \n\t\r.,;:!?(){}]");


            Map<String, Integer> mapOfWords = new HashMap<String, Integer>();

            //Count words and hash it, which will end up in the hashmap mapOfWords having key as word and count as value, Time complexity O(n)
            for (String word : words) {
                int count = 1;

                if (mapOfWords.containsKey(word)) {
                    count = mapOfWords.get(word);
                    count++;
                }
                mapOfWords.put(word, count);
            }

            //Traversing through the hashmap mapOfWords to find the most frequently occurred word, Time complexity O(n)
            int maxOccurrence = 0;
            for (String key : mapOfWords.keySet()) {
                int occurrence = mapOfWords.get(key);
                if (occurrence > maxOccurrence) {
                    maxOccurrence = occurrence;

                }
            }


            // then create the array listOfWords of that size+1. The array will contain the list containing the words occurred with same frequency
            List[] listOfWords = new ArrayList[maxOccurrence + 1];

            /*The frequency will be the index of the array listOfWords and that index will hold a list containing the words occurred with same frequency
                Traverse the hashmap again and use the number of occurrences of words as array index,
                if the index is empty, create a list listOfWordsWithSameOccurrences else append it in the list, Time complexity O(n)*/
            for (String key : mapOfWords.keySet()) {
                int occurrence = mapOfWords.get(key);
                if (listOfWords[occurrence] == null) {
                    List<String> listOfWordsWithSameOccurrences = new ArrayList<String>();
                    listOfWordsWithSameOccurrences.add(key);
                    listOfWords[occurrence] = listOfWordsWithSameOccurrences;
                } else {
                    listOfWords[occurrence].add(key);

                }
            }

            //finally just traverse the array from the end, and collect the numberOfWords, Time complexity O(n).
            List<String> output = new ArrayList<String>(numberOfWords);

            for (int i = listOfWords.length - 1; i >= 0 && numberOfWords > 0; i--) {
                List<String> temp = listOfWords[i];
                if (temp != null && numberOfWords > 0) {

                    for (int j = 0; j < temp.size() && numberOfWords > 0; j++) {
                        output.add(temp.get(j));
                        --numberOfWords;
                    }
                }
            }
            // Total time complexity O(n)

            for (String s : output) {
                System.out.println(s);
            }
            return output;


        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("The arguments passed are not valid");
    }


    public static void main(String[] args) throws IOException{
        String filePath = "/Users/abhi.pandey/Documents/testFolder/test3.txt";
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        FindMaxOccurrences.getMaxOccurredWords(content, 10);
    }

}


