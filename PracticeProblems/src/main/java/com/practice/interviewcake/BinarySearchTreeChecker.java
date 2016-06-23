package com.practice.interviewcake;

import com.practice.codingInterview.treesAndGraphs.BinarySearchTree;
import com.practice.codingInterview.treesAndGraphs.BinaryTreeNode;

/**
 * Created by abhi.pandey on 3/3/16.
 */
public class BinarySearchTreeChecker {

    public static void main(String[] args) {
        Integer[] a = {5, 3, 4, 8, 7, 9, 6, 10, 2, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer n : a) bst.insert(n);
        System.out.println(isValidBSTRecursive(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBST(bst.getRoot()));
    }

    /*
    Left should be greater than lower bound and right should be greater than upper bound.
     */
    public static boolean isValidBSTRecursive(BinaryTreeNode<Integer> root, int lower_bound, int upper_bound) {
        if (root == null) {
            return true;
        }
        if (root.getData() < lower_bound || root.getData() > upper_bound ) return false;

        return isValidBSTRecursive(root.getLeft(), lower_bound, root.getData()) & isValidBSTRecursive(root.getRight(), root.getData(), upper_bound);

    }

    /*
    The best solution I found is O(n) and it uses no extra space.
    It is similar to inorder traversal but instead of storing it to array
    and then checking whether it is sorted we can take a static variable
    and check while inorder traversing whether array is sorted.
     */
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> prev = null;

        if (root != null) {
            if (!isBST(root.getLeft()))
                return false;

            // Allows only distinct valued nodes
            if (prev != null && root.getData() <= prev.getData())
                return false;

            prev = root;

            return isBST(root.getRight());
        }
        return true;
    }
}
