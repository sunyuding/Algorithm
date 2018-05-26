/**
 * Find the second largest key in the given binary search tree.
 *
 * If there does not exist the second largest key,
 * return Integer.MIN_VALUE.
 *
 * Assumptions:
 *
 * The given binary search tree is not null.
 * Examples:
 *
 *     2
 *
 *   /   \
 *
 *  1     4
 *
 *       /
 *
 *     3
 *
 * the second largest key is 3.
 *
 * Easy
 * Binary Search Tree
 */
public class SecondLargestInBinarySearchTree {
    public int secondLargest(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode cur = root;
        while(cur.right != null) {
            pre = cur;
            cur = cur.right;
        }
        // now cur is the largest one
        if (cur.left != null) {
            // find the largest in cur.left
            cur = cur.left;
            while(cur.right != null) {
                cur = cur.right;
            }
            return cur.key;
        } else {
            return pre.key;
        }
    }
}
