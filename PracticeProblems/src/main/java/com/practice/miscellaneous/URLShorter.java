package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 10/7/15.
 */
public class URLShorter {

    public static String URLfromID(int id) {
        char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder shortURL = new StringBuilder();

        while (id > 0) {
            shortURL.append(map[id % 62]);
            id /= 62;
        }
        return shortURL.reverse().toString();
    }

    public static long URLtoID(String url) {

        long id = 0;
        char[] arr = url.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if ('a' <= arr[i] && arr[i] <= 'z') {
                id = id * 62 + arr[i] - 'a';
            }
            if ('A' <= arr[i] && arr[i] <= 'Z') {
                id = id * 62 + arr[i] - 'A' + 26;
            }
            if ('0' <= arr[i] && arr[i] <= '9') {
                id = id * 62 + arr[i] - '0' + 52;
            }
        }
        return id;
    }

    public static void main(String[] args) {
        int n = 56789;
        String url = URLfromID(n);
        System.out.println(url);
        System.out.println(URLtoID(url));
    }

}