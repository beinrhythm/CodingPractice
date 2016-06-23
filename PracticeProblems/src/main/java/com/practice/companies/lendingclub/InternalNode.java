package com.practice.companies.lendingclub;

/**
 * Created by abhi.pandey on 5/10/16.
 */
public class InternalNode {
    double startTime;
    double endTime;
    double max;
    InternalNode left;
    InternalNode right;
    UserUsage data;


    public InternalNode(double startTime, double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "InternalNode{" +
                " startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

}
