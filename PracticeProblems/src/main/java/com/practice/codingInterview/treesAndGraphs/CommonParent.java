package com.practice.codingInterview.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhi.pandey on 12/21/14.
 */
public class CommonParent {
    ArrayList <BinaryTreeNode> path = new ArrayList<BinaryTreeNode>();

    public static BinaryTreeNode findCommonParent(BinaryTreeNode root , BinaryTreeNode node1, BinaryTreeNode node2){

        if(findIn(root.left, node1) && findIn(root.left, node2)){
            return findCommonParent(root.left, node1 , node2);
        }

        if(findIn(root.right, node1) && findIn(root.right, node2)){
            return findCommonParent(root.right, node1 , node2);
        }
        return root;
    }

    private static boolean findIn(BinaryTreeNode root, BinaryTreeNode node){
        if(root==null) return false;
        if(root.data == node.data) return true;

        else {
            return findIn(root.left,node) || findIn(root.right,node);
        }
    }

    static boolean getPath(BinaryTreeNode rootNode, char key, ArrayList<BinaryTreeNode> path ){
        //return true if the node is found
        if( rootNode==null)
            return false;
        if (rootNode.data==key){
            path.add(rootNode);
            return true;
        }
        boolean left_check = getPath( rootNode.left,key,path);
        boolean right_check = getPath( rootNode.right,key,path);
        if ( left_check || right_check){
            path.add(rootNode);
            return true;
        }
        return false;

    }




}
