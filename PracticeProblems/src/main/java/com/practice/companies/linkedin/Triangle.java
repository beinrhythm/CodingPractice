package com.practice.companies.linkedin;

import java.util.Arrays;

/**
 * Three segments of lengths A, B, C form a triangle iff
 * <p/>
 * A + B > C
 * B + C > A
 * A + C > B
 * <p/>
 * e.g.
 * 6, 4, 5 can form a triangle
 * 10, 2, 7 can't
 * <p/>
 * Given a list of segments lengths algorithm should find at least one triplet of segments that form a triangle (if any).
 * <p/>
 * Method should return an array of either:
 * - 3 elements: segments that form a triangle (i.e. satisfy the condition above)
 * - empty array if there are no such segments
 * <p/>
 * Solution - we sort the list of segments- presumably in O(nlogn) with merge sort.
 * Then in O(n) time, we traverse the sorted list. Set i = 0, j = 1, k = 2.
 * Check if array[i], array[j], array[k] are a triangle. If not, increment i, j, k then repeat the process.
 * <p/>
 * Created by abhi.pandey on 4/4/16.
 */

public class Triangle {

    int[] getTriangleSides(int[] segments) {
        if (segments.length < 3) {
            return new int[]{};
        }
        Arrays.sort(segments);

        int k = 2;

        for (k = 2; k < segments.length; k++) {
            if ((segments[k - 2] + segments[k - 1]) > segments[k]) {
                return new int[]{segments[k - 2], segments[k - 1], segments[k]};
            }
        }

        return new int[]{};
    }

    // print all triangles
    public void triangleTriplet(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; j < n; j++) {
                    if (i != j && j != k && i != k)
                        if (a[i] + a[j] > a[k] && a[j] + a[k] > a[i] && a[i] + a[k] > a[j]) {
                            System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        }
                }
            }
        }
    }

}
