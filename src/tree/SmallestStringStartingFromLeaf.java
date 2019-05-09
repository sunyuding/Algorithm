package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 988. Smallest String Starting From Leaf
 * Given the root of a binary tree,
 * each node has a value from 0 to 25 representing the letters 'a' to 'z':
 * a value of 0 represents 'a',
 * a value of 1 represents 'b',
 * and so on.
 *
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 *
 * (As a reminder, any shorter prefix of a string is lexicographically smaller:
 * for example,
 * "ab" is lexicographically smaller than "aba".
 * A leaf of a node is a node that has no children.)
 *
 * Example 1:
 *                 0
 *               /   \
 *              1     2
 *             / \   / \
 *             3 4  3  4
 * Input: [0,1,2,3,4,3,4]
 * Output: "dba"
 *
 * Example 2:
 *                  25
 *                /    \
 *               1     3
 *              / \   / \
 *              1 3  0  2
 * Input: [25,1,3,1,3,0,2]
 * Output: "adz"
 *
 * Example 3:
 *                      2
 *                 /        \
 *               2           1
 *             /    \       /  \
 *            null  1     0   null
 *                 /
 *                 0
 * Input: [2,2,1,null,1,0,null,0]
 * Output: "abc"
 *
 *
 * Note:
 *
 * The number of nodes in the given tree will be between 1 and 8500.
 * Each node in the tree will have a value between 0 and 25.
 */
public class SmallestStringStartingFromLeaf {
    private static final char[] DICT = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private String result;

    /**
     * Time: O(n * height)
     * Space: O(height)
     * @param root
     * @return
     */
    public String smallestFromLeaf(TreeNode root) {
        result = "";
        if (root == null) return result;
        StringBuilder sb = new StringBuilder();
        sb.insert(0, DICT[root.val]);
        backtracking(root, sb);
        return result;
    }

    private void backtracking(TreeNode root, StringBuilder sb) {
        // base case: leaf node
        if (root.left == null && root.right == null) {
            String cur = sb.toString();
            if (result.equals("")) {
                result = cur;
            }
            // O(height)
            if (cur.compareTo(result) < 0) {
                result = cur;
            }
            return;
        }
        if (root.left != null) {
            sb.insert(0, DICT[root.left.val]);
            backtracking(root.left, sb);
            sb.deleteCharAt(0);
        }
        if (root.right != null) {
            sb.insert(0, DICT[root.right.val]);
            backtracking(root.right, sb);
            sb.deleteCharAt(0);
        }
    }
}
