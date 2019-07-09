package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:
 * Say there are n words,
 * the words' length is l,
 * and each trie node worse case has 26 children.
 * buildTrie() takes O(n * l).
 * backtracking() helper method takes O(26^l).
 * So the for loop takes O(n * 26^l).
 * The overall time complexity is O(n * l + n * 26^l).
 */
public class WordSquares {
    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        TrieNode root = buildTrie(words);
        List<List<String>> squares = new ArrayList<>();

        for (String word : words) {
            List<String> square = new ArrayList<>();
            square.add(word);
            backtracking(root, word.length(), square, squares);
        }
        return squares;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = word;
        }
        return root;
    }

    private void backtracking(TrieNode root, int len, List<String> square, List<List<String>> squares) {
        if (square.size() == len) {
            squares.add(new ArrayList<>(square)); // IMPORTANT: initialize a new ArrayList instead of using the reference
            return;
        }

        String prefix = getPrefix(square, square.size());


        List<String> children = new ArrayList<>();

        TrieNode node = search(root, prefix);
        if (node == null) {
            return;
        }

        getChildren(node, children);

        for (String child : children) {
            square.add(child);
            backtracking(root, len, square, squares);
            square.remove(square.size() - 1);
        }
    }

    private String getPrefix(List<String> square, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(square.get(i).charAt(index));
        }
        return sb.toString();
    }

    private TrieNode search(TrieNode root, String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }

    private void getChildren(TrieNode node, List<String> children) {
        if (node.word != null) {
            children.add(node.word);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                getChildren(node.children[i], children);
            }
        }
    }
}
