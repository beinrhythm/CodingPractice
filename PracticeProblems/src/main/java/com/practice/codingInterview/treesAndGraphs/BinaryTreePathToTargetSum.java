package com.practice.codingInterview.treesAndGraphs;

import java.util.ArrayList;

/**
 * Created by abhi.pandey on 3/5/16.
 */
public class BinaryTreePathToTargetSum {

    public boolean hasPathSum(BinaryTreeNode<Integer> head, int sum) {
        return hasPathSumHelper(head, 0, sum);
    }

    private boolean hasPathSumHelper(BinaryTreeNode<Integer> head, int partialSum, int targetSum) {
        if (head == null) return false;

        partialSum += head.getData();

        //leaf node
        if (head.getLeft() == null && head.getRight() == null) {
            return partialSum == targetSum;
        }
        //non-leaf node
        return hasPathSumHelper(head.getLeft(), partialSum, targetSum) || hasPathSumHelper(head.getRight(), partialSum, targetSum);

    }

    public void pathsFromRootToLeafEqualToSum(BinaryTreeNode<Integer> head, int sum) {
        ArrayList<Integer> buffer = new ArrayList<>();

        listOfPathsEqualToSumHelper(head, 0, sum, buffer);
    }

    private void listOfPathsEqualToSumHelper(BinaryTreeNode<Integer> head, int partialSum, int targetSum, ArrayList<Integer> buffer) {
        if (head == null) return;

        buffer.add(head.getData());
        partialSum += head.getData();

        //leaf node
        if (head.getLeft() == null && head.getRight() == null) {
            if (partialSum == targetSum) {
                System.out.println(buffer);
            }
        }
        ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
        //non-leaf node
        listOfPathsEqualToSumHelper(head.getLeft(), partialSum, targetSum, c1);
        listOfPathsEqualToSumHelper(head.getRight(), partialSum, targetSum, c2);

    }

    public void allPathsFromRootToLeafEqualToSum(BinaryTreeNode<Integer> head, int sum) {
        ArrayList<Integer> buffer = new ArrayList<>();

        listOfAllPathsEqualToSumHelper(head, sum, buffer, 0);
    }

    private void listOfAllPathsEqualToSumHelper(BinaryTreeNode<Integer> head, int targetSum, ArrayList<Integer> buffer, int level) {
        if (head == null) return;

        int tmp = targetSum;
        buffer.add(head.getData());
        for (int i = level;i >- 1; i--){
            tmp -= buffer.get(i);
            if (tmp == 0) print(buffer, i, level);
        }


        ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
        //non-leaf node
        listOfAllPathsEqualToSumHelper(head.getLeft(), targetSum, c1, level + 1);
        listOfAllPathsEqualToSumHelper(head.getRight(), targetSum, c2, level + 1);

    }

    private void print(ArrayList<Integer> buffer, int level, int i2) {
        for (int i = level; i <= i2; i++) {
            System.out.print(buffer.get(i) + " ");
        }
        System.out.println();
    }


}
