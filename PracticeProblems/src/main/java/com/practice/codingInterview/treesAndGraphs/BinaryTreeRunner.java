package com.practice.codingInterview.treesAndGraphs;

/**
 * Created by abhi.pandey on 8/28/15.
 */
public class BinaryTreeRunner {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.setLeft( new BinaryTreeNode<>(2));
        root.setRight(new BinaryTreeNode<>(3));
        root.getLeft().setLeft( new BinaryTreeNode<>(4));
        root.getRight().setLeft( new BinaryTreeNode<>(5));
        root.getRight().setRight( new BinaryTreeNode<>(6));
        root.getRight().getLeft().setLeft( new BinaryTreeNode<>(7));
        root.getRight().getLeft().getLeft().setLeft( new BinaryTreeNode<>(8));
        root.getRight().getLeft().getLeft().setRight( new BinaryTreeNode<>(9));
        System.out.println(BinaryTreeMaxHeight.getMaxHeightIterative(root));
    }
}
