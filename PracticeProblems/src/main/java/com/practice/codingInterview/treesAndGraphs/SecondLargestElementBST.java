package com.practice.codingInterview.treesAndGraphs;

/**
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
                return rightChild.getLeft();
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
}
