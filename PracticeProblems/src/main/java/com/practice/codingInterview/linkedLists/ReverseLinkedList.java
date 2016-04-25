package com.practice.codingInterview.linkedLists;


/**
 * Created by abhi.pandey on 12/7/14.
 */
public class ReverseLinkedList {
    public static LinkedListNode reverseIterative(LinkedListNode head) {
        if (head == null) {
            return head;
        } else {
            LinkedListNode current = head;
            LinkedListNode prev = null;

            while (current != null) {
                LinkedListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;

            }
            return prev;


        }
    }

    public static LinkedListNode reverseRecursive(LinkedListNode head) {
        if (head == null) return null;

        if (head.next == null) return head;

        else {
            LinkedListNode first = head;
            LinkedListNode rest = head.next;
            first.next = null;

            LinkedListNode temp = reverseRecursive(rest);
            rest.next = first;
            return temp;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(1, new LinkedListNode<Integer>(2,
                new LinkedListNode<Integer>(3, new LinkedListNode<Integer>(4,
                        new LinkedListNode<Integer>(5, new LinkedListNode<Integer>(6, new LinkedListNode<Integer>(7, null)
                        ))))));
        LinkedListNode.printNode(head);
        System.out.println();
        LinkedListNode.printNode(reverseRecursive(head));

    }
}
