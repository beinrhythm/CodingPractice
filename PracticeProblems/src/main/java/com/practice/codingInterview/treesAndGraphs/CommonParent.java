package com.practice.codingInterview.treesAndGraphs;

import java.util.ArrayList;

/**
 * Created by abhi.pandey on 12/21/14.
 */
public class CommonParent {
    ArrayList <BinaryTreeNode> path = new ArrayList<BinaryTreeNode>();

    public static BinaryTreeNode findCommonParent(BinaryTreeNode root , BinaryTreeNode node1, BinaryTreeNode node2){
        if(findIn(root.getLeft(), node1) && findIn(root.getLeft(), node2)){
            return findCommonParent(root.getLeft(), node1 , node2);
        }

        if(findIn(root.getRight(), node1) && findIn(root.getRight(), node2)){
            return findCommonParent(root.getRight(), node1 , node2);
        }
        return root;
    }

    private static boolean findIn(BinaryTreeNode root, BinaryTreeNode node){
        if(root==null) return false;
        if(root.data == node.data) return true;

        else {
            return findIn(root.getLeft(),node) || findIn(root.getRight(),node);
        }
    }

    static boolean getPath(BinaryTreeNode<Integer> rootNode, char key, ArrayList<BinaryTreeNode> path ){
        //return true if the node is found
        if( rootNode==null)
            return false;
        if (rootNode.data==key){
            path.add(rootNode);

            return true;
        }
        boolean left_check = getPath( rootNode.getLeft(),key,path);
        boolean right_check = getPath( rootNode.getRight(),key,path);
        if ( left_check || right_check){
            path.add(rootNode);
            return true;
        }
        return false;

    }

}
