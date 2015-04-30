package com.practice.codingInterview.linkedLists;

/**
 * Created by abhi.pandey on 11/30/14.
 */
public class Problem2 {
    /**
     * Implement an algorithm to find the nth to last element of a singly linked list.
     * @param head
     * @param n
     * @return
     */
    public static LinkedListNode nthToLast(LinkedListNode head, int n) {
        if (head == null) return null;
        LinkedListNode.printNode(head);
        System.out.println();
        LinkedListNode node = head;
        LinkedListNode result = head;

        while (n > 0 && node !=null) {
            node = node.next;
            n--;
        }
        while (node.next != null) {
            result = result.next;
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(1, new LinkedListNode<Integer>(3,
                new LinkedListNode<Integer>(5, new LinkedListNode<Integer>(8,
                        new LinkedListNode<Integer>(7, new LinkedListNode<Integer>(6, new LinkedListNode<Integer>(4, null)
                        ))))));
        System.out.println(nthToLast(head, 4).data);
    }
}
