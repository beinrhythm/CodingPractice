package com.practice.codingInterview.linkedLists;

/**
 * Created by abhi.pandey on 11/30/14.
 */
public class Problem5 {
    /**
     * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
     * @param head
     * @return
     */
    private static LinkedListNode findBeginningOfLoop(LinkedListNode head) {
        if (head == null) {
            return null;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode result ;

        //finding meeting point
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                result = slow;
                System.out.println("Meeting point at " + result.data);
                break;
            }
        }
        if (fast == null) {
            System.out.println("No loop");
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        result = fast;
        return result;
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(1, null);
        LinkedListNode second = new LinkedListNode(2, null);
        LinkedListNode third = new LinkedListNode(3, null);
        LinkedListNode fourth = new LinkedListNode(4, null);
        LinkedListNode fifth = new LinkedListNode(5, null);
        LinkedListNode sixth = new LinkedListNode(6, null);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = fourth;

        if (Problem5.findBeginningOfLoop(first) != null) {
            System.out.println("Loop at " + Problem5.findBeginningOfLoop(first).data);
        }
    }
}
