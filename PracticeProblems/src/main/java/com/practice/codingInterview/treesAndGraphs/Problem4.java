package com.practice.codingInterview.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhi.pandey on 12/15/14.
 */
public class Problem4 {
    static ArrayList<LinkedList<BinaryTreeNode>> findLevelLinkList(BinaryTreeNode root) {
        ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<LinkedList<BinaryTreeNode>>();
        LinkedList<BinaryTreeNode> list = new LinkedList<>();

        Queue<BinaryTreeNode<Integer>> q = new LinkedList();
        BinaryTreeNode<Integer> special = new BinaryTreeNode<>(-1);
        q.add(root);
        q.add(special);

        while (!q.isEmpty()) {
            BinaryTreeNode node = q.remove();

            if (node != null) {
                if (node.data != -1) {
                    System.out.print(node.data);
                    list.add(node);
                    if (node.getLeft() != null) {
                        q.add(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        q.add(node.getRight());
                    }

                } else if (node.data.equals(special.data)) {
                    System.out.println();
                    result.add(list);
                    list = new LinkedList<>();
                    q.add(special);

                }


            }
            if (q.size() <= 1 && q.peek().data.equals(special.data)) {
                result.add(list);
                break;
            }
        }

        return result;

    }

    public static void printTreeLtoR(BinaryTreeNode<Integer> root) {

        Queue<BinaryTreeNode<Integer>> q = new LinkedList();
        BinaryTreeNode<Integer> special = new BinaryTreeNode<>(-1);
        q.add(root);
        q.add(special);

        while (!q.isEmpty()) {
            BinaryTreeNode node = q.remove();

            if (node != null) {
                if (node.data != -1) {
                    System.out.print(node.data);
                    if (node.getLeft() != null) {
                        q.add(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        q.add(node.getRight());
                    }

                } else if (node.data.equals(special.data)) {
                    System.out.println();
                    q.add(special);

                }


            }
            if (q.size() <= 1 && q.peek().data.equals(special.data)) break;
        }
    }

    static void printTreeZigZag(BinaryTreeNode root) {
        ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<LinkedList<BinaryTreeNode>>();
        LinkedList<BinaryTreeNode> list = new LinkedList<>();

        Queue<BinaryTreeNode<Integer>> q = new LinkedList();
        BinaryTreeNode<Integer> special = new BinaryTreeNode<>(-1);
        q.add(root);
        q.add(special);

        while (!q.isEmpty()) {
            BinaryTreeNode node = q.remove();

            if (node != null) {
                if (node.data != -1) {
                //    System.out.print(node.data);
                    list.add(node);
                    if (node.getLeft() != null) {
                        q.add(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        q.add(node.getRight());
                    }

                } else if (node.data.equals(special.data)) {
            //        System.out.println();
                    result.add(list);
                    list = new LinkedList<>();
                    q.add(special);

                }


            }
            if (q.size() <= 1 && q.peek().data.equals(special.data)) {
                result.add(list);
                break;
            }
        }
        boolean l2R = true;
        System.out.print("\t");

         for( LinkedList<BinaryTreeNode> l : result){

             if(l2R){
                 for(int i =0 ; i< l.size(); i++){
                     System.out.print(l.get(i).data);
                     System.out.print("\t");
                 }
                 System.out.println();
                 l2R = false;
             }else{
                 for(int i =l.size()-1 ; i>= 0; i--){
                     System.out.print(l.get(i).data);
                     System.out.print("\t");
                 }
                 System.out.println();
                 l2R = true;
             }
         }

    }
}





