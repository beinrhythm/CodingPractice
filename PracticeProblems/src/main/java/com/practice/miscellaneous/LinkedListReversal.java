package com.practice.miscellaneous;

public class LinkedListReversal {

	public static void main(String[] args){
		Node home = new Node(1,new Node(2,new Node(3,new Node(4,null))));
		printNode(home);
		LinkedListReversal llr = new LinkedListReversal();
		Node revHome = llr.reverse(home);
		System.out.println();
		printNode(revHome);
	}


	private static void printNode(Node home) {
		if(home == null){
			return;
		}
		System.out.print(home.data + " ");
		printNode(home.next);
	}


	private Node reverse(Node node){
		Node back = null;
		while(node != null){
			Node front = node.next;
			node.next = back;
			back=node;
			node=front;
		}
		return back;

	}


}


class Node{
	int data;
	Node next;

	Node(int data,Node next){
		this.data = data;
		this.next = next;

	}
}
