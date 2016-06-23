package com.practice.companies.uber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by abhi.pandey on 5/16/16.
 */
public class Boggle {
    public static void main(String args[]) {

    }

    HashSet<String> result = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(result);
    }

    // run dfs for rows and column of this 2d array
    private void dfs(char[][] boggle, boolean[][] visited, String str, int i, int j, Trie trie) {

        int m = boggle.length;
        int n = boggle.length;

        // if we are going aout of index for this 2d array
        if (i < 0 || j < 0 || i >= m || j >= n) return;

        // if we already vicited this alphabet
        if (visited[i][j]) return;

        str = str + boggle[i][j];

        // if trie doesn't starts with this string
        if (!trie.startsWith(str)) return;

        //search for this string in trie
        if (trie.search(str)) {
            result.add(str);
        }

        visited[i][j] = true;

        dfs(boggle, visited, str, i - 1, j, trie);
        dfs(boggle, visited, str, i + 1, j, trie);
        dfs(boggle, visited, str, i, j - 1, trie);
        dfs(boggle, visited, str, i, j + 1, trie);
        dfs(boggle, visited, str, i + 1, j - 1, trie);
        dfs(boggle, visited, str, i + 1, j + 1, trie);
        dfs(boggle, visited, str, i - 1, j + 1, trie);
        dfs(boggle, visited, str, i - 1, j - 1, trie);

        visited[i][j] = false;
    }

    //Trie Node
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    //Trie
    class Trie {
        public TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    return false;
                node = node.children[c - 'a'];
            }
            if (node.item.equals(word)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}


