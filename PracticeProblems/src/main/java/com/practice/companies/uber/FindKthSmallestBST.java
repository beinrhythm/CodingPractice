package com.practice.companies.uber;

import com.practice.codingInterview.treesAndGraphs.BinaryTreeNode;

/**
 * Created by abhi.pandey on 5/12/16.
 */
public class FindKthSmallestBST {

    public int kthSmallest(BinaryTreeNode<Integer> root, int k) {
        int count = countNodes(root.getLeft());
        if (k <= count) {
            return kthSmallest(root.getLeft(), k);
        } else if (k > count + 1) {
            return kthSmallest(root.getRight(), k - 1 - count); // 1 is counted as current node
        }

        return root.getData();
    }

    public int countNodes(BinaryTreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.getLeft()) + countNodes(n.getRight());
    }
}
