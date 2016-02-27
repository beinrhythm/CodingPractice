package com.practice.codingInterview.treesAndGraphs;

/**
 * Created by abhi.pandey on 12/15/14.
 */

/**
 *
 *Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a
 * given node in a binary search tree where each node has a link to its parent
 *
 *       5
       /   \
      3     8
     / \   / \
    1  4  7  9
    \    /    \
     2   6     10

 */
public class Problem5 {

    public static BinaryTreeNode inorderSuccessor(BinaryTreeNode node){
        if(node!=null){
            BinaryTreeNode result = null;

            //case 1 when successor is leftmost of right sub tree, example 5 and answer is 6
            if(node.getParent() != null || node.getRight()!= null){
                result = leftMost(node.getRight());
            }
            else{
            // right subtree is empty
                if(node.getRight() == null){
                    BinaryTreeNode parent = node.getParent();
                    //case 2 when successor is parent, example 6 and answer is 7
                    if(node == parent.getLeft()){
                        result = parent;
                    }else{
                        // case 3 when successor is parent's successor, example 4 and answer is 5
                        result = inorderSuccessor(parent);
                    }
                }
            }
            return  result;
        }

        return null;

    }

    private static BinaryTreeNode leftMost(BinaryTreeNode node) {
        if(node == null) return null;
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }


}
