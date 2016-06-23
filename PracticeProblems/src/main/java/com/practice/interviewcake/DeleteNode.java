package com.practice.interviewcake;

import com.practice.codingInterview.linkedLists.LinkedListNode;

/**
 * Delete a node from a singly linked list given only a variable pointing to that node.
 * Created by abhi.pandey on 5/7/16.
 */
public class DeleteNode {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode('a');
        LinkedListNode b = new LinkedListNode('b');
        LinkedListNode c = new LinkedListNode('c');
        LinkedListNode d = new LinkedListNode('d');


        a.next = b;
        b.next = c;
        c.next = d;
        deleteThisNode(d);
        LinkedListNode.printNode(a);
    }

    public static void deleteThisNode(LinkedListNode nodeToBeDeleted) {

        if(nodeToBeDeleted.next == null){
            nodeToBeDeleted.data = null;
            nodeToBeDeleted.next = null;
        }else {
            nodeToBeDeleted.data = nodeToBeDeleted.next.data;
            nodeToBeDeleted.next = nodeToBeDeleted.next.next;
        }
    }
}
