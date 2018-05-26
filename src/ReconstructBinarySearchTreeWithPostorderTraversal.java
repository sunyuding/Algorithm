import java.util.Arrays;

/**
 * Given the postorder traversal sequence of a binary search tree,
 * reconstruct the original tree.
 *
 * Assumptions
 *
 * The given sequence is not null
 * There are no duplicate keys in the binary search tree
 * Examples
 *
 * postorder traversal = {1, 4, 3, 11, 8, 5}
 *
 * the corresponding binary search tree is
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
 * The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:
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
 * Binary Search Tree
 */
public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post) {
        if(post == null || post.length == 0) {
            return null;
        }
        int rootKey = post[post.length - 1];
        TreeNode root = new TreeNode(rootKey);
        int i = 0;
        while(i < post.length - 1) {
            if (post[i] > rootKey) {
                break;
            }
            i++;
        }
        TreeNode left = reconstruct(Arrays.copyOfRange(post, 0, i));
        TreeNode right = reconstruct(Arrays.copyOfRange(post, i, post.length - 1));
        root.left = left;
        root.right = right;
        return root;
    }
}
