package com.practice.codingInterview.dynamicProgramming;

/**
 * Created by abhi.pandey on 12/27/14.
 */
public class LongestSubStringWithoutDuplication {

    public static int find(char[] str) {

        int length = str.length - 1;
        int cur_len = 1;  // To store the length of current substring
        int max_len = 1;  // To store the result
        int prev_index;  // To store the previous index
        int i;

        int dp[] = new int['z'];

        /* Initialize the visited array as -1, -1 is used to indicate that
       character has not been visited yet. */
        for (i = 0; i < 'z'; i++)
            dp[i] = -1;

          /* Mark first character as visited by storing the index of first
       character in visited array. */
        dp[str[0]] = 0;

         /* Start from the second character. First character is already processed
       (cur_len and max_len are initialized as 1, and visited[str[0]] is set */
        for (i = 1; i < length; i++) {
            prev_index = dp[str[i]];

        /* If the current character is not present in the already processed
           substring or it is not part of the current NRCS, then do cur_len++ */
            if (prev_index == -1 || i - cur_len > prev_index)
                cur_len++;

        /* If the current character is present in currently considered NRCS,
           then update NRCS to start from the next character of previous instance. */
            else {
            /* Also, when we are changing the NRCS, we should also check whether
              length of the previous NRCS was greater than max_len or not.*/
                if (cur_len > max_len)
                    max_len = cur_len;

                cur_len = i - prev_index;
            }

            dp[str[i]] = i; // update the index of current character
        }

        if (cur_len > max_len)
            max_len = cur_len;


        return max_len;

    }

    public static int find2(String s) {

        if (s == null)
            return 0;

        // Trimming input even for the non-empty case is more consistent.
        final String str = s.trim();

        if (str.equals(""))
            return 0;

        int seen[] = new int[256];
        for (int i = 0; i < 256; i++)
            seen[i] = -1;

        int max = 1;
        int len = 0;

        for (int j = 0; j < str.length(); ++j) {
            char ch = str.charAt(j);
            // If ch was recently seen,
            // counting must restart after the last place it was seen.
            // Otherwise, it adds 1 to the length.
            len = Math.min(j - seen[ch], len + 1);
            if (len > max)
                max = len;

            seen[ch] = j;
        }
        return max;

    }



    public static void main(String[] args) {
        String test = "ABDEFGABEF";
        System.out.println(LongestSubStringWithoutDuplication.find2(test));

    }
}
