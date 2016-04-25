package com.practice.codingInterview.treesAndGraphs;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 * <p/>
 * Created by abhi.pandey on 12/21/14.
 */
public class SubTree {

    public boolean isSubtree(BinaryTreeNode T1, BinaryTreeNode T2) {
        if (T2 == null) return true;//Empty Subtree is accepted

        if (T1 == null) return false; // If large tree is empty no need of continuing further

      /*   return true if any of the following conditions is true-
           1- Both T1 and T2 are same/equal trees
           2- T2 is subtree of T1's left tree
           3- T2 is subtree of T1's right tree
        */
        return isSameTree(T1, T2) || isSubtree(T1.getLeft(), T2) || isSubtree(T1.getRight(), T2);
    }

    private boolean isSameTree(BinaryTreeNode T1, BinaryTreeNode T2) {
        // nothing left in the subtree
        if (T1 == null &&  T2 == null) return true;

        // big tree empty & subtree still not found
        if (T1 == null || T2 == null) return false;

        // data doesn’t match
        if (T1.getData() != T2.getData()) return false;

        return isSameTree(T1.getLeft(), T2.getLeft()) && isSameTree(T1.getRight(), T2.getRight());
    }
}
