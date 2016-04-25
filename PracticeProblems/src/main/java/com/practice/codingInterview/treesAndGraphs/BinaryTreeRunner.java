package com.practice.codingInterview.treesAndGraphs;

import com.practice.companies.uber.SerializeDeserializeBinaryTree;

/**
 * Created by abhi.pandey on 8/28/15.
 */
public class BinaryTreeRunner {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.setLeft(new BinaryTreeNode<>(2));
        root.setRight(new BinaryTreeNode<>(3));
      /*  root.getLeft().setLeft(new BinaryTreeNode<>(5));
        root.getLeft().setRight(new BinaryTreeNode<>(4));
        root.getLeft().getRight().setLeft(new BinaryTreeNode<>(1));*/
        root.getRight().setRight(new BinaryTreeNode<>(5));
        root.getRight().setLeft(new BinaryTreeNode<>(4));
      /*  root.getRight().getLeft().setLeft(new BinaryTreeNode<>(7));
        root.getRight().getRight().setLeft(new BinaryTreeNode<>(4));*/
        // root.getRight().getRight().setRight(new BinaryTreeNode<>(-1));

        SerializeDeserializeBinaryTree sdbt = new SerializeDeserializeBinaryTree();
        String serialize = sdbt.serializeIterative(root);
        System.out.println(serialize);
        BinaryTreeNode<Integer> resultTree = sdbt.deSerializeIterative(serialize);
        serialize = sdbt.serializeIterative(resultTree);
        System.out.println(serialize);
    }
}
