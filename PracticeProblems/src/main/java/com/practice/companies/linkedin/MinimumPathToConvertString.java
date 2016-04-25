package com.practice.companies.linkedin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two valid dictionary words of same length, write a function which returns the minimum number of steps to go from the first to the second word.
 * You can change only one character at a time. Also, the word formed at every step should be a valid dictionary word.
 * <p/>
 * Eg: Provide minimum steps to go from 'cat' to 'dog'
 * <p/>
 * cat --> cot --> dot--> dog in 4 steps
 * Created by abhi.pandey on 4/1/16.
 */
public class MinimumPathToConvertString {
    public static void main(String[] args) {
        new MinimumPathToConvertString().findPathLength("cat", "dog");
    }

    //setup a DAG and use bfs to from the shortest path
    public void findPathLength(String start, String end) {
        {
            Queue<Tuple> graph = new LinkedList<>();
            //sample dictionary
            HashSet<String> words = new HashSet<>(Arrays.asList(
                    "cat", "bat", "bet", "bot", "bog", "dog", "cot", "dot", "dog"
            ));
            HashSet<String> visited = new HashSet<>();
            String allEnglishCharacters = "abcdefghijklmnopqrstuvwxyz";

            graph.add(new Tuple(start, 1));
            int level = -1;
            while (!graph.isEmpty()) {
                Tuple target = graph.remove();
                String src = target.text;
                for (int i = 0; i < src.length(); i++) {
                    for (char c : allEnglishCharacters.toCharArray()) {
                        String res = src.substring(0, i) + c + src.substring(i + 1);
                        //Optimization to reduce unnecessary checks
                        if (visited.contains(res)) {
                            continue;
                        } else {
                            visited.add(res);
                        }
                        // if target word found exit
                        if (res.equals(end)) {
                            level = target.level + 1;
                            break;
                        }
                        // if found in dictionary add
                        if (words.contains(res)) {
                            graph.add(new Tuple(res, target.level + 1));
                        }
                    }
                    if (level != -1)
                        break;
                }
                if (level != -1)
                    break;
            }
            System.out.println(level);
        }
    }

    class Tuple {
        String text;
        int level;

        Tuple(String t, int l) {
            this.text = t;
            this.level = l;
        }
    }
}
