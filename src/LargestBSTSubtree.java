import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree,
 * find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 *
 *     10
 *     / \
 *    5  15
 *   / \   \
 *  1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 *
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 *
 * Medium
 * Recursion
 * Binary Tree
 * Binary Search Tree
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return getSize(root);
        } else {
            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key < min || root.key > max) {
            return false;
        }
        return isBST(root.left, min, root.key - 1) && isBST(root.right, root.key + 1, max);
    }

    private int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + 1 + getSize(root.right);
    }
}
