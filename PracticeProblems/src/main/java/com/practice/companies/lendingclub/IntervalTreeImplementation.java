package com.practice.companies.lendingclub;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A custom implementation of interval tree https://en.wikipedia.org/wiki/Interval_tree
 * Java implemetation is also available since JDK8
 * http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b27/sun/jvm/hotspot/utilities/IntervalTree.java
 *
 * Created by abhi.pandey on 5/10/16.
 */
public class IntervalTreeImplementation {
    public InternalNode insert(InternalNode root, UserUsage userUsage) {
        if (root == null) {
            InternalNode interval = new InternalNode(userUsage.startTime, userUsage.endTime);
            interval.max = userUsage.endTime;
            interval.data = userUsage;
            return interval;
        }

        if (userUsage.startTime < root.startTime) {
            root.left = insert(root.left, userUsage);
        } else {
            root.right = insert(root.right, userUsage);
        }

        root.max = Math.max(root.endTime, userUsage.endTime);
        return root;
    }

    public ArrayList<InternalNode> getOverlapIntervals(InternalNode root, double startTime, double endTime) {
        ArrayList<InternalNode> overlapIntervals = new ArrayList<>();
        Stack<InternalNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            InternalNode interval = stack.pop();
            if (interval != null) {
                if (interval.endTime > startTime && interval.startTime < endTime) {
                    overlapIntervals.add(interval);
                }
                stack.push(interval.left);
                stack.push(interval.right);
            }
        }
        return overlapIntervals;
    }
}
