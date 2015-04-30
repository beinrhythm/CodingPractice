package com.practice.codingInterview.treesAndGraphs;

/**
 * Created by abhi.pandey on 12/7/14.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode root;

    private int compare(T x, T y) {
        return x.compareTo(y);
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> p, T data) {
        if (p == null) {
            return new BinaryTreeNode<T>(data);
        }

        if (compare(data, p.data) > 0) {
            p.right = insert(p.right, data);

        } else {
            p.left = insert(p.left, data);
        }
        return p;
    }

    public void delete(T data) {
        root = delete(root, data);

    }

    private BinaryTreeNode delete(BinaryTreeNode<T> p, T data) {
        if (p == null) {
            throw new RuntimeException("cannot delete.");
        } else if (compare(data, p.data) > 0) {
            p.right = delete(p.right, data);
        } else if (compare(data, p.data) < 0) {
            p.left = delete(p.left, data);
        } else {

            if (p.left == null) return p.right;
            else if (p.right == null) return p.left;
            else if (p.left == null && p.right == null) return p;
            else {
                //rotation
                p.data = getData(p.left);
                p.left = delete(p.left, p.data);
            }
        }
        return p;
    }

    private T getData(BinaryTreeNode<T> p) {
        while (p.right != null) {
            p = p.right;
        }
        return p.data;
    }


    public T findMax(BinaryTreeNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public T findMin(BinaryTreeNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }


    private void traversePreOrder(BinaryTreeNode<T> node) {
        if (node == null) return;

        System.out.println(node.data);
        traversePreOrder(node.left);
        traversePreOrder(node.right);

    }

    public void traverseInOrder(BinaryTreeNode<T> node) {
        if (node == null) return;

        traverseInOrder(node.left);
        System.out.println(node.data);
        traverseInOrder(node.right);
    }

    private void traversePostOrder(BinaryTreeNode<T> node) {
        if (node == null) return;

        traversePostOrder(node.right);
        traversePostOrder(node.left);
        System.out.println(node.data);
    }

    private int MinDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.min(MinDepth(node.left), MinDepth(node.right));

    }

    private int MaxDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(MaxDepth(node.left), MaxDepth(node.right));
    }

    public boolean isBalanced(BinaryTreeNode root) {
        System.out.println(MaxDepth(root));
        System.out.println(MinDepth(root));
        return (MaxDepth(root) - MinDepth(root) <= 1);

    }

    public static void main(String[] args) {
        Integer[] a = {5, 3, 4, 8, 7, 9, 6, 10, 2, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer n : a) bst.insert(n);
       /* System.out.println("InOrder");
        bst.traverseInOrder(bst.root);
        System.out.println("PreOrder");
        bst.traversePreOrder(bst.root);
        System.out.println("PostOrder");
        bst.traversePostOrder(bst.root);
        System.out.println("Max=" + bst.findMax(bst.root));
        System.out.println("Min=" + bst.findMin(bst.root));
        bst.delete(9);*/
        //
        // System.out.println(bst.isBalanced(bst.root));
        //    Problem4.printTreeLtoR(bst.root);
        //  Problem4.findLevelLinkList(bst.root);
        //   Problem4.printTreeLtoR(bst.root);
        //     Problem4.printTreeZigZag(bst.root);

        System.out.println(Problem5.inorderSuccessor(bst.root.left.right).data);


    }


}


