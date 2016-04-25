package com.practice.codingInterview.treesAndGraphs;

/**
 * Created by abhi.pandey on 12/8/14.
 */
public class BinaryTreeNode<T> {

    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private BinaryTreeNode parent;
    private int size;
    T data;

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BinaryTreeNode(T data) {

        this.data = data;
    }

}
