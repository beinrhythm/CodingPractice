package com.practice.codingInterview.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhi.pandey on 12/28/14.
 */
public class BoxStacking {

    public static int calculateHeight(Box arr[]) {
        int length = arr.length;
        Box[] boxes = new Box[3 * length];

        for (int i = 0; i < 3 * length; i++) {
            boxes[i] = new Box(0, 0, 0);
        }

        int index = 0;
        for (int i = 0; i < length; i++) {
            // Copy the original box
            boxes[index] = arr[i];
            index++;

            // First rotation of box
            boxes[index].height = arr[i].width;
            boxes[index].depth = Math.max(arr[i].height, arr[i].depth);
            boxes[index].width = Math.min(arr[i].height, arr[i].depth);
            index++;

            // Second rotation of box
            boxes[index].height = arr[i].depth;
            boxes[index].depth = Math.max(arr[i].height, arr[i].width);
            boxes[index].width = Math.min(arr[i].height, arr[i].width);
            index++;
        }

        length = 3 * length;

        Arrays.sort(boxes, Collections.reverseOrder());



      /* Initialize msh values for all indexes
      msh[i] –> Maximum possible Stack Height with box i on top */
        int msh[] = new int[length];
        for (int i = 0; i < length; i++)
            msh[i] = boxes[i].height;

        /* Compute optimized msh values in bottom up manner */
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[j].width > boxes[i].width && boxes[j].depth > boxes[i].depth ) {
                    msh[i] = Math.max( msh[i] ,msh[j] + boxes[i].height);
                }
            }
        }

        /* Pick maximum of all msh values */
        int max = -1;
        for (int i = 0; i < length; i++)
            if (max < msh[i])
                max = msh[i];

        return max;

    }


    public static void main(String[] args) {
        Box arr[] = {new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32)};

        System.out.println(BoxStacking.calculateHeight(arr));
    }

}

class Box implements Comparable {
    int height, width, depth;

    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public int compareTo(Object o) {
        Box b = (Box) o;
        return this.width < b.width ? -1 : this.width > b.width ? 1 : 0;
    }
}
