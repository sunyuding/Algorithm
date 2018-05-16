import java.util.Arrays;

/**
 * Given the preorder traversal sequence of a binary search tree,
 * reconstruct the original tree.
 *
 * Assumptions
 *
 * The given sequence is not null
 * There are no duplicate keys in the binary search tree
 * Examples
 *
 * preorder traversal = {5, 3, 1, 4, 8, 11}
 *
 * The corresponding binary search tree is
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * How is the binary tree represented?
 *
 * We use the pre order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
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
 *
 *
 * Medium
 * Binary Search Tree
 */
public class ReconstructBinarySearchTreeWithPreorderTraversal {
    public TreeNode reconstruct(int[] pre) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int i = 1;
        while(i < pre.length) {
            if (pre[i] > root.key) {
                break;
            }
            i++;
        }
        root.left = reconstruct(Arrays.copyOfRange(pre, 1, i));
        root.right = reconstruct(Arrays.copyOfRange(pre, i, pre.length));
        return root;
    }
}
