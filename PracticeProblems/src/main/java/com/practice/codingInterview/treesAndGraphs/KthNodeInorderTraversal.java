package com.practice.codingInterview.treesAndGraphs;

/**
 * Find kth node in in-order traversal. Given that each node stores the total number of nodes in its subtree
 * Created by abhi.pandey on 3/5/16.
 */
public class KthNodeInorderTraversal {
    public BinaryTreeNode findNode(BinaryTreeNode<Integer> head, int k) {
        BinaryTreeNode temp = head;

        while (temp != null) {
            int leftSize = 0;

            if(temp.getLeft()!=null){
                leftSize = temp.getLeft().getSize();
            }

            if(k > leftSize + 1){
                k = k - (leftSize+1);
                temp = temp.getRight();
            }else if(k == leftSize +1 ){
                return temp;
            }
            else{
                temp = temp.getLeft();
            }


        }

        return null;
    }
}

