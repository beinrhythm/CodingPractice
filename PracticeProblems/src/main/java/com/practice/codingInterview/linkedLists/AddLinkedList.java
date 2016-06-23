package com.practice.codingInterview.linkedLists;

/**
 * Created by abhi.pandey on 11/30/14.
 */
public class AddLinkedList {
    public static LinkedListNode addList(LinkedListNode<Integer> node1, LinkedListNode<Integer> node2) {

        if(node1 == null || node2 == null){
            return null;
        }
        int data = node1.data + node2.data;
        int value = data % 10;
        int carry = data / 10;
        LinkedListNode<Integer> result = new LinkedListNode<Integer>(value, null);
        LinkedListNode head = result;
        node1 = node1.next;
        node2 = node2.next;


        while (node1 != null || node2 != null) {
            data = node1.data + node2.data;
            value = (data +carry) % 10;
            result.next = new LinkedListNode<Integer>(value , null);
            result = result.next;

            carry = (data+carry) / 10;
            node1 = node1.next;
            node2 = node2.next;


        }
        if(carry >0 && node1 == null || node2 == null){
            result.next = new LinkedListNode<Integer>(  carry, null);
        }
        LinkedListNode.printNode(head);
        return head;


    }

    public LinkedListNode subtractList(LinkedListNode node1, LinkedListNode node2) {
        LinkedListNode result = null;
        return result;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(5, new LinkedListNode<Integer>(5,
                new LinkedListNode<Integer>(5, null)
        ));
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(5, new LinkedListNode<Integer>(5,
                new LinkedListNode<Integer>(5, null)
        ));
        AddLinkedList.addList(node1, node2);
    }

}
