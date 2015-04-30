package com.practice.codingInterview.arraysAndStrings;

/**
 * Created by abhi.pandey on 11/27/14.
 */
public class Problem5 {
    public static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }


    public static void main(String[] args) {
        int[][] input = new int[5][5];
        Problem5.rotate(input, 90);
    }
}
