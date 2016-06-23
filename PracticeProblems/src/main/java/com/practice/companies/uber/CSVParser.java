package com.practice.companies.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by abhi.pandey on 5/12/16.
 */
public class CSVParser {

    public static void main(String[] args) {
        String input = "a, b,\"hello,world\", xy\ne,f,g";
        List<List<String>> output = parse(input);

    }

    private static List<List<String>> parse(String input) {

        List<List<String>> output = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {

            output.add(process(line));

        }
        System.out.println(output);
        return output;
    }

    private static List<String> process(String line) {
        List<String> elephantList = Arrays.asList(line.split("\""));
        return elephantList;
    }
}
