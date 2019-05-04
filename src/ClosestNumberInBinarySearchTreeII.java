/**
 * In a binary search tree,
 * find k nodes containing the closest numbers to the given target number. return them in sorted array
 *
 * Assumptions:
 *
 * The given root is not null.
 * There are no duplicate keys in the binary search tree.
 * Examples:
 *
 *     5
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6     14
 *
 * closest number to 4 is 5
 *
 * closest number to 10 is 11
 *
 * closest number to 6 is 6
 *
 * How is the binary tree represented?
 *
 * We use the level order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 *
 * Medium
 * Binary Search tree
 */
public class ClosestNumberInBinarySearchTreeII {

    public int[] closestKValues(TreeNode root, double target, int k) {
        return null;
    }

    private int closest(ClosestNumberInBinarySearchTree.TreeNode root, int target) {
        if (target == root.key) {
            return root.key;
        } else if (target < root.key) {
            if (root.left == null) {
                return root.key;
            } else {
                int leftClose = closest(root.left, target);
                if (Math.abs(leftClose - target) < root.key - target) {
                    return leftClose;
                } else {
                    return root.key;
                }
            }
        } else {
            if (root.right == null) {
                return root.key;
            } else {
                int rightCLose = closest(root.right, target);
                if (Math.abs(rightCLose - target) < target - root.key) {
                    return rightCLose;
                } else {
                    return root.key;
                }
            }
        }
    }
}
