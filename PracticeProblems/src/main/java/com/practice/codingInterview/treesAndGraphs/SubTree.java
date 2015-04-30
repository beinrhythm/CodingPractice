package com.practice.codingInterview.treesAndGraphs;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 * <p/>
 * Created by abhi.pandey on 12/21/14.
 */
public class SubTree {

    public boolean isSubtree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t2 == null) {
            return true;
        } else return subTree(t1, t2);
    }

    private boolean subTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null) return false;

        if (t1.data == t2.data) {
            if (matchTree(t1, t2)) return true;
        }

        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    private boolean matchTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) return true;

        if (t1 == null || t2 == null) return false;

        if (t1.data != t2.data) return false;

        else return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);

    }
}
