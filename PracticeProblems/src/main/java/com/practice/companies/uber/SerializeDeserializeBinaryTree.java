package com.practice.companies.uber;

import com.practice.codingInterview.treesAndGraphs.BinaryTreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Created by abhi.pandey on 4/15/16.
 */
public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(BinaryTreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(BinaryTreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#" + " ");
        } else {
            sb.append(root.getData() + " ");
            serialize(root.getLeft(), sb);
            serialize(root.getRight(), sb);
        }

    }

    // Decodes your encoded data to tree.
    public BinaryTreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }

    private BinaryTreeNode deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens())
            return null;
        String s = st.nextToken();
        if (s.equals("#"))
            return null;
        BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(s));
        root.setLeft(deserialize(st));
        root.setRight(deserialize(st));

        return root;
    }

    public String serializeIterative(BinaryTreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode node = q.remove();
            if (node != null) {
                sb.append(node.getData());
                q.add(node.getLeft());
                q.add(node.getRight());
            } else {
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public BinaryTreeNode deSerializeIterative(String data) {
        if (data == null || data.length() == 0) return null;

        int length = data.length();
        List<BinaryTreeNode> nodeList = new ArrayList<>();

        int i = 0;
        while (i < length) {
            char parent = data.charAt(i);
            if (parent != '#') {
                nodeList.add(new BinaryTreeNode(parent));
            } else {
                nodeList.add(null);
            }
            i++;
        }
        int size = nodeList.size();
        for (int l = 0; l < size; l++) {
            int left = 2 * l + 1;
            int right = left + 1;
            BinaryTreeNode root = nodeList.get(l);
            if (root != null) {
                root.setLeft(left >= size ? null : nodeList.get(left));
                root.setRight(right >= size ? null : nodeList.get(right));
                nodeList.set(l, root);
            }

        }
        return nodeList.get(0);
    }

}
