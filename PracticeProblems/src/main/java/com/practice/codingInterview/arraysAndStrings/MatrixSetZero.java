package com.practice.codingInterview.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhi.pandey on 11/27/14.
 */
public class MatrixSetZero {
    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
     *
     * @param matrix
     */
    private void setZeros(int[][] matrix) {

        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }


        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 1}, {0, 4, 5}, {4, 0, 5}};
        new MatrixSetZero().setZeros(input);
    }


}
