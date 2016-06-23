package com.practice.interviewcake;

import com.practice.codingInterview.treesAndGraphs.BinarySearchTree;
import com.practice.codingInterview.treesAndGraphs.BinaryTreeNode;

import java.util.*;

/**
 * A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.
 * <p/>
 * Created by abhi.pandey on 2/23/16.
 */
public class SuperBalancedBinaryTree {
    public static void main(String[] args) {
        Integer[] a = {5, 3, 4, 8, 7, 9, 6, 10, 2, 1};

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer n : a) bst.insert(n);
        isSuperBalanced(bst.getRoot());
    }

    private static boolean isSuperBalanced(BinaryTreeNode root) {
        Stack<Tuple> myStack = new Stack<>();

        HashSet<Integer> setOfDepths = new HashSet<>();
        Tuple t = new Tuple(root, 0);
        myStack.push(t);

        while (!myStack.isEmpty()) {
            Tuple temp = myStack.pop();

            //leaf node
            if (temp.node.getLeft() == null && temp.node.getRight() == null) {

                /* two ways we might now have an unbalanced tree:
                1) more than 2 different leaf depths
                2) 2 leaf depths that are more than 1 apart*/

                setOfDepths.add(temp.depth);
                if (setOfDepths.size() == 2) {
                    List<Integer> list = new ArrayList<Integer>(setOfDepths);
                    if (Math.abs(list.get(0) - list.get(1)) > 1) {
                        return false;
                    }

                }
                if (setOfDepths.size() > 2) {
                    return false;
                }
            } else {
                if (temp.node.getLeft() != null) {
                    Tuple left = new Tuple(temp.node.getLeft(), temp.depth + 1);
                    myStack.push(left);
                }

                if (temp.node.getRight() != null) {
                    Tuple right = new Tuple(temp.node.getRight(), temp.depth + 1);
                    myStack.push(right);
                }
            }
        }
        return true;
    }

    static class Tuple {
        BinaryTreeNode node;

        int depth;

        public Tuple(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;

        }
    }
}
