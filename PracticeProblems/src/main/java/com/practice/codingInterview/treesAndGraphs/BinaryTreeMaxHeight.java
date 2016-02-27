package com.practice.codingInterview.treesAndGraphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhi.pandey on 8/28/15.
 */
public class BinaryTreeMaxHeight {
    ArrayList<ArrayList<BinaryTreeNode>> result;

    public BinaryTreeMaxHeight(BinaryTreeNode root) {
        result = new ArrayList<>();
        ArrayList<BinaryTreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);
        processLevelRecursive(rootLevel);
    }

    private void processLevelRecursive(ArrayList<BinaryTreeNode> rootLevel) {
        if (rootLevel.size() > 0) {
            ArrayList<BinaryTreeNode> newLevel = new ArrayList<>();
            for (BinaryTreeNode node : rootLevel) {
                if (node.getLeft() != null) {
                    newLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    newLevel.add(node.getRight());
                }
            }

            result.add(newLevel);
            processLevelRecursive(newLevel);
        }

    }

    public int getMaxHeight() {
        return result.size();
    }

    public static int getMaxHeightRecursive2(BinaryTreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getMaxHeightRecursive2(node.getLeft()), getMaxHeightRecursive2(node.getRight()));
    }

    public static int getMaxHeightIterative(BinaryTreeNode root) {
        Stack<ArrayList<BinaryTreeNode>> myStack = new Stack<>();
        int height = 0;
        ArrayList<BinaryTreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);
        myStack.add(rootLevel);
        while (!myStack.isEmpty()) {
            ArrayList<BinaryTreeNode> level = myStack.pop();
            ArrayList<BinaryTreeNode> newLevel = new ArrayList<>();
            for (BinaryTreeNode node : level) {
                if (node.getLeft() != null) {
                    newLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    newLevel.add(node.getRight());
                }
            }
            height++;
            if (newLevel.size() > 0)
                myStack.push(newLevel);
        }
        return height;
    }
}
