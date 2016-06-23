package com.practice.interviewcake;

import com.practice.codingInterview.treesAndGraphs.BinaryTreeNode;

/**
 * Write a function to find the 2nd largest element in a binary search tree.
 * https://www.interviewcake.com/question/java/second-largest-item-in-bst
 * Created by abhi.pandey on 9/1/15.
 */
public class SecondLargestElementBST {

    public static BinaryTreeNode find(BinaryTreeNode root) {
        if (root.getRight() != null) {
            BinaryTreeNode parentNode = root;
            BinaryTreeNode rightChild = root.getRight();
            while (rightChild.getRight() != null) {
                parentNode = rightChild;
                rightChild = rightChild.getRight();
            }

            if (rightChild.getLeft() == null) {
                return parentNode;
            } else {
                return find_largest(rightChild.getLeft());
            }
        } else if (root.getLeft() != null) {
            BinaryTreeNode secondMaxNode = root.getLeft();

            if (secondMaxNode.getRight() == null) {
                return secondMaxNode;
            }
            while (secondMaxNode.getRight() != null) {
                secondMaxNode = secondMaxNode.getRight();
            }
            return secondMaxNode;
        }
        return new BinaryTreeNode(null);
    }

    private static BinaryTreeNode find_largest(BinaryTreeNode root) {
        BinaryTreeNode curr = root;
        while (curr != null) {
            if(curr.getRight() == null){
                return curr;
            }else{
                curr = curr.getRight();
            }
        }
        return curr;
    }
}
