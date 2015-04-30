package com.practice.codingInterview.linkedLists;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by abhi.pandey on 11/27/14.
 */
public class DeleteDuplicates {
    /**
     * Write code to remove duplicates from an unsorted linked list.
     *
     * @param head
     */
    public static void deleteDuplicates(LinkedListNode head) {

        if (head != null) {
            System.out.println("Printing nodes before removing duplicates--");
            LinkedListNode.printNode(head);
            System.out.println();
            HashSet setOfFound = new HashSet();
            LinkedListNode prev = null, node = head;

            while (node != null) {
                if (!setOfFound.contains(node.data)) {
                    setOfFound.add(node.data);
                    prev = node;
                } else {
                    System.out.println("duplicate found " + node.data);
                    prev.next = node.next;
                }
                node = node.next;

            }
            System.out.println("Printing nodes after removing duplicates--");
            LinkedListNode.printNode(head);
        }
    }

    private static void deleteDuplicates2(LinkedListNode node) {
        if (node == null) return;

        System.out.println("Printing nodes after removing duplicates--");
        LinkedListNode.printNode(node);
        LinkedListNode prev = node;
        LinkedListNode current = node.next;
        boolean isRemoved = false;

        while (current != null) {
            LinkedListNode runner = node;
            while (runner != current) {
                if (runner.data == current.data) {
                    prev.next = current.next;
                    current = current.next;
                    isRemoved = true;
                    break;
                }
                isRemoved = false;
                runner = runner.next;
            }

            if(!isRemoved) {
                prev = current;
                current = current.next;
            }

        }
        System.out.println("Printing nodes after removing duplicates--");
        LinkedListNode.printNode(node);
    }



    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(1, new LinkedListNode<Integer>(3,
                new LinkedListNode<Integer>(2, new LinkedListNode<Integer>(3,
                        new LinkedListNode<Integer>(2, new LinkedListNode<Integer>(1, new LinkedListNode<Integer>(4, null)
                        ))))));
        deleteDuplicates2(head);
    }
}



