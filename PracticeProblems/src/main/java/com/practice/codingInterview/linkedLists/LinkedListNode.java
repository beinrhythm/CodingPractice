package com.practice.codingInterview.linkedLists;

/**
 * Created by abhi.pandey on 11/30/14.
 */
public class LinkedListNode<T> {


    T data;
    LinkedListNode next;

    LinkedListNode(T data, LinkedListNode next) {
        this.data = data;
        this.next = next;

    }

    public static void printNode(LinkedListNode home) {
        if (home == null) {
            return;
        }
        System.out.print(home.data + " ");
        printNode(home.next);
    }
}

