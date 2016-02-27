package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 8/16/15.
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 10, 11, 15};
        int[] b = {1, 5};
        int[] c = solution(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    public static int[] solution(int[] a, int[] b) {

        if (a != null && b != null) {
            int lenA = a.length;
            int lenB = b.length;
            int lenC = lenA + lenB;

            int[] c = new int[lenC];

            if (lenA > 0 && lenB > 0) {

                int i = 0, j = 0, k = 0;

                while (i != lenA && j != lenB) {
                    if (a[i] < b[j]) {
                        c[k++] = a[i++];
                    } else if (b[j] < a[i]) {
                        c[k++] = b[j++];
                    }else{
                        c[k++] = a[i++];
                        j++;
                    }
                }

                while (i != lenA) {
                    c[k++] = a[i++];
                }
                while (j != lenB) {
                    c[k++] = b[j++];
                }
                return c;
            } else if (lenA <= 0) {
                return b;
            } else {
                return a;
            }
        }
        return new int[]{-1};
    }
}
