package com.practice.codingInterview.treesAndGraphs;

/**
 * Created by abhi.pandey on 12/15/14.
 */
public class MinimumHeightBinaryTree {
    public static BinaryTreeNode createMinimalBST(int [] data){
        return add(data, 0, data.length - 1);
    }
    private static BinaryTreeNode add(int[] insert, int start, int end){
        if(end <start) return null;

        int mid = (start+end)/2;
        BinaryTreeNode root = new BinaryTreeNode(insert[mid]);
        root.setLeft( add(insert, start, mid - 1));
        root.setRight( add(insert , mid+1, end));
        return  root;

    }

    public static void main(String[] args) {
        int[] data = {9,8,7,6,5,4,3,2,1};
        MinimumHeightBinaryTree.createMinimalBST(data);
    }
}
