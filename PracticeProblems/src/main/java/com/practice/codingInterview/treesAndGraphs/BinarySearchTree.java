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
            p.setRight(insert(p.getRight(), data));

        } else {
            p.setLeft(insert(p.getLeft(), data));
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
            p.setRight(delete(p.getRight(), data));
        } else if (compare(data, p.data) < 0) {
            p.setLeft(delete(p.getLeft(), data));
        } else {

            if (p.getLeft() == null) return p.getRight();
            else if (p.getRight() == null) return p.getLeft();
            else if (p.getLeft() == null && p.getRight() == null) return p;
            else {
                //rotation
                p.setData((T) getData(p.getLeft()));
                p.setLeft(delete(p.getLeft(), p.data));
            }
        }
        return p;
    }

    private T getData(BinaryTreeNode<T> p) {
        while (p.getRight() != null) {
            p = p.getRight();
        }
        return p.data;
    }


    public T findMax(BinaryTreeNode<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.data;
    }

    public T findMin(BinaryTreeNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.data;
    }


    private void traversePreOrder(BinaryTreeNode<T> node) {
        if (node == null) return;

        System.out.println(node.data);
        traversePreOrder(node.getLeft());
        traversePreOrder(node.getRight());

    }

    public void traverseInOrder(BinaryTreeNode<T> node) {
        if (node == null) return;

        traverseInOrder(node.getLeft());
        System.out.println(node.data);
        traverseInOrder(node.getRight());
    }

    private void traversePostOrder(BinaryTreeNode<T> node) {
        if (node == null) return;

        traversePostOrder(node.getRight());
        traversePostOrder(node.getLeft());
        System.out.println(node.data);
    }

    private int MinDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.min(MinDepth(node.getLeft()), MinDepth(node.getRight()));

    }

    private int MaxDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(MaxDepth(node.getLeft()), MaxDepth(node.getRight()));
    }

    public boolean isBalanced(BinaryTreeNode root) {
        System.out.println(MaxDepth(root));
        System.out.println(MinDepth(root));
        return (MaxDepth(root) - MinDepth(root) <= 1);

    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        Integer[] a = {5, 3, 4, 8, 7, 9, 6, 10, 2, 1};
        Integer[] b = {6, 3, 2, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer n : b) bst.insert(n);
        System.out.println(SecondLargestElementBST.find(bst.getRoot()).data);
        //System.out.println(btm.getMaxHeight());
        //System.out.println(BinaryTreeMaxHeight.getMaxHeightIterative(bst.root));
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

        //  System.out.println(Problem5.inorderSuccessor(bst.root.left.right).data);


    }


}


