package com.practice.codingInterview.treesAndGraphs;

/**
 * Created by abhi.pandey on 12/8/14.
 */
public class BinaryTreeNode<T> {

    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;


    T data;

    BinaryTreeNode(T data) {

        this.data = data;
    }

}
