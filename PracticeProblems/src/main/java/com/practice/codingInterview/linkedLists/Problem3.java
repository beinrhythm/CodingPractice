package com.practice.codingInterview.linkedLists;

/**
 * Created by abhi.pandey on 11/30/14.
 */
public class Problem3 {
    /**
     * Implement an algorithm to delete a node in the middle of a single linked list,
     * given only access to that node.
     *
     * @param node
     * @return
     */
    public static boolean deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) return false;
        LinkedListNode next = node.next;

        node.data = next.data;
        node.next = next.next;

        return true;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(1, new LinkedListNode<Integer>(3,
                new LinkedListNode<Integer>(5, new LinkedListNode<Integer>(8,
                        new LinkedListNode<Integer>(7, new LinkedListNode<Integer>(6, new LinkedListNode<Integer>(4, null)
                        ))))));
        LinkedListNode<Integer> temp = head;
        while (temp != null && temp.data != 5) {
            temp = temp.next;
        }
        LinkedListNode.printNode(head);
        System.out.println();
        deleteNode(temp);
        LinkedListNode.printNode(head);
    }
}

class temp{
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
