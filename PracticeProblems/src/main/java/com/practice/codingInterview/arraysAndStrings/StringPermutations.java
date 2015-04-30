package com.practice.codingInterview.arraysAndStrings;

import java.util.ArrayList;

/**
 * Created by abhi.pandey on 12/28/14.
 */
public class StringPermutations {
    public static void permutation(String str) {
        permutation("", str);
    }

     private static void permutation(String prefix, String str) {
        int n = str.length();

         if(n == 0) System.out.println(prefix);

         else{
             for(int i=0; i<n; i++)
             permutation(prefix+ str.charAt(i) , str.substring(0,i) + str.substring(i+1, n));
         }
     }

    public static void permutation2(String s) {
        perm2(s.toCharArray(), s.length());
    }


   private static void perm2(char[] a, int n) {
       if(n==1){
           System.out.println(a);
           return;
       }

       for(int i=0; i<n ;i++){
           swap(a, i, n-1);
           perm2(a, n-1);
           swap(a, i, n-1);
       }
   }

    public static ArrayList<String> getPerms(String s){
        ArrayList<String> permutations = new ArrayList<>();
        if(s==null){
            return null;
        }
        else if(s.length()==0){
            permutations.add("");
            return permutations;
        }

        char first = s.charAt(0);

        String remainder = s.substring(1);

        ArrayList<String> perms = getPerms(remainder);

        for (String perm : perms) {
            for (int i = 0; i < perm.length(); i++) {
                String temp = insert(perm, first, i);
                permutations.add(temp);
            }

        }

        return permutations;
    }

    private static String insert(String str, char ch, int index) {
        String firstPart = str.substring(0,index);
        String lastPart = str.substring(index);

        return firstPart+ch+lastPart;
    }


    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c;
        c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
        String a = "abc";
        StringPermutations.permutation2(a);
    }
}
