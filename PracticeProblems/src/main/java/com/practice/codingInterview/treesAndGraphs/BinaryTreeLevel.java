package com.practice.codingInterview.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by abhi.pandey on 12/15/14.
 */
public class BinaryTreeLevel {
    public static void levelOrderTraversal(BinaryTreeNode root) {
        BinaryTreeNode<Integer> temp;
        Queue<BinaryTreeNode> q = new LinkedBlockingDeque<BinaryTreeNode>();
        q.add(root);
        q.add(new BinaryTreeNode(-1));
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.getData() == -1) {
                System.out.println();
                if (!q.isEmpty())
                    q.add(new BinaryTreeNode(-1));

            } else {
                System.out.print(temp.getData());
                if (temp.getLeft() != null)
                    q.add(temp.getLeft());
                if (temp.getRight() != null)
                    q.add(temp.getRight());
            }
        }

    }

    static ArrayList<LinkedList<BinaryTreeNode>> findLevelLinkList(BinaryTreeNode root) {
        ArrayList<LinkedList<BinaryTreeNode>> result = new ArrayList<LinkedList<BinaryTreeNode>>();
        LinkedList<BinaryTreeNode> list = new LinkedList<>();

        Queue<BinaryTreeNode<Integer>> q = new LinkedList();
        BinaryTreeNode<Integer> special = new BinaryTreeNode<>(-1);
        q.add(root);
        q.add(special);

        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.remove();

            if (node != null) {
                if (node.getData() != -1) {
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
            BinaryTreeNode <Integer>node = q.remove();

            if (node != null) {
                if (node.getData() != -1) {
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
            BinaryTreeNode<Integer> node = q.remove();

            if (node != null) {
                if (node.getData() != -1) {
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





