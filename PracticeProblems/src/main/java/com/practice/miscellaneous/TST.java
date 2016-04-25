package com.practice.miscellaneous;

/**
 * Created by abhi.pandey on 12/5/14.
 */
public class TST<T extends Comparable<T>> {

    private TrinaryNode root;

    private int compare(T x, T y) {
        return x.compareTo(y);
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private TrinaryNode<T> insert(TrinaryNode<T> p, T data) {

        if (p == null) {
            return new TrinaryNode<T>(data);
        }

        if (compare(data, p.data) == 0) {
            TrinaryNode node = new TrinaryNode(data);
            p.center = node;
        }

        if (compare(data, p.data) < 0) {
            if (p.left == null) {
                TrinaryNode node = new TrinaryNode(data);
                p.left = node;
            } else {
                insert(p.left, data);
            }
        }
        if (compare(data, p.data) > 0) {
            if (p.right == null) {
                TrinaryNode node = new TrinaryNode(data);
                p.right = node;
            } else {
                insert(p.right, data);
            }
        }
        return p;
    }

    public void delete(T toDelete) {
        root = delete(root, toDelete);
    }

    private TrinaryNode<T> delete(TrinaryNode<T> p, T toDelete) {
        if (p == null) throw new RuntimeException("cannot delete.");
        else if (compare(toDelete, p.data) < 0)
            p.left = delete(p.left, toDelete);
        else if (compare(toDelete, p.data) > 0)
            p.right = delete(p.right, toDelete);
        else {
            if (p.left == null && p.right == null) {
                return p.center;
            } else if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            } else {
                //rotation
                p.data = (T) getData(p.left);
                p.left = delete(p.left, p.data);
            }
        }
        return p;
    }

    private T getData(TrinaryNode<T> p) {
        while (p.right != null){
            p = p.right;
        }
        return p.data;
    }


    public static void main(String[] args) {
        Integer[] a = {5, 4, 9, 5, 7, 2, 2};
        TST<Integer> tst = new TST<Integer>();
        for (Integer n : a) tst.insert(n);
        tst.delete(5);
        //tst.delete(2);
    }

    class TrinaryNode<T> {
        TrinaryNode left, center, right;

        T data;

        TrinaryNode(T data) {

            this.data = data;
        }
    }
}
