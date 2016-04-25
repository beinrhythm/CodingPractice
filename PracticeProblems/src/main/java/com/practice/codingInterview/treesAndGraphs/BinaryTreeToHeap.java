package com.practice.codingInterview.treesAndGraphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * You are given a set of integers in an unordered binary tree. Use an array sorting routine to transform the tree into
 * a heap that uses a balanced binary tree as its underlying data structure.
 * <p/>
 * Created by abhi.pandey on 2/28/16.
 */
public class BinaryTreeToHeap {

    public static void main(String[] args) {
        Integer[] a = {5, 3, 4, 8, 7, 9, 6, 10, 2, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer n : a) bst.insert(n);

        heapifyBinaryTree(bst.getRoot());
    }

    public static BinaryTreeNode heapifyBinaryTree(BinaryTreeNode<Integer> root) {
        int sizeOfArray = traverseIterative(root, null);
        BinaryTreeNode[] arr = new BinaryTreeNode[sizeOfArray];
        traverseIterative(root, arr);
        Arrays.sort(arr, new Comparator<BinaryTreeNode>() {

            @Override
            public int compare(BinaryTreeNode o1, BinaryTreeNode o2) {

                int v1 = (int) o1.getData();

                int v2 = (int) o2.getData();

                return (v1 < v2 ? -1 : (v1 == v2 ? 0 : 1));
            }
        });

        for (int i = 0; i < arr.length; i++) {
            int leftIndex = 2 * i + 1;
            int rightIndex = leftIndex + 1;

            arr[i].setLeft((leftIndex >= sizeOfArray ? null : arr[leftIndex]));

            arr[i].setRight((rightIndex >= sizeOfArray ? null : arr[rightIndex]));
        }
        return arr[0];
    }

    private static int traverseRecursive(BinaryTreeNode root, int count, BinaryTreeNode[] arr) {

        if (root == null) return count;

        if (arr != null) {
            arr[count] = root;
        }

        count++;

        count = traverseRecursive(root.getLeft(), count, arr);
        count = traverseRecursive(root.getRight(), count, arr);

        return count;

    }

    private static int traverseIterative(BinaryTreeNode root, BinaryTreeNode[] arr) {
        int count = 0;

        Stack<BinaryTreeNode> s = new Stack();
        if (root != null) {
            s.push(root);
            while (!s.isEmpty()) {
                BinaryTreeNode child = s.pop();
                if (child != null) {


                    if (arr != null) {
                        arr[count] = child;
                    }

                    if (child.getLeft() != null) {
                        s.push(child.getLeft());
                    }

                    if (child.getRight() != null) {
                        s.push(child.getRight());
                    }

                    count++;
                }


            }
        }
        return count;
    }
}
