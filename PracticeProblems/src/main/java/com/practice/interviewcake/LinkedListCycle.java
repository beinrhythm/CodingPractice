package com.practice.interviewcake;

import com.practice.codingInterview.linkedLists.LinkedListNode;

/**
 * Created by abhi.pandey on 5/7/16.
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode('a');
        LinkedListNode b = new LinkedListNode('b');
        LinkedListNode c = new LinkedListNode('c');
        LinkedListNode d = new LinkedListNode('d');
        LinkedListNode e = new LinkedListNode('e');
        LinkedListNode f = new LinkedListNode('f');


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        System.out.println(hasCycle(a));
    }

    private static boolean hasCycle(LinkedListNode start) {

        LinkedListNode slow = start;
        LinkedListNode fast = start;
        while(fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }


        return false;
    }
}
