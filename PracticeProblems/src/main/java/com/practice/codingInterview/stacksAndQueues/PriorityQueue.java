package com.practice.codingInterview.stacksAndQueues;


/**
 * Created by abhi.pandey on 12/25/14.
 */
public class PriorityQueue {

}

class Element implements Comparable {
    int data;
    int priority;

    Element(int data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        Element e = (Element) o;

        return (this.priority < e.priority) ? -1 : (this.priority > e.priority) ? 1 : 0;
    }
}

