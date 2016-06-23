package com.practice.codingInterview.linkedLists;

/**
 * Created by abhi.pandey on 11/30/14.
 */
public class LinkedListNode<T> {


    public T data;
    public LinkedListNode next;

    public LinkedListNode(T data, LinkedListNode next) {
        this.data = data;
        this.next = next;

    }

    public LinkedListNode(T data){
        this.data = data;
    }

    public static void printNode(LinkedListNode home) {
        if (home == null) {
            return;
        }
        System.out.print(home.data + " ");
        printNode(home.next);
    }
}

