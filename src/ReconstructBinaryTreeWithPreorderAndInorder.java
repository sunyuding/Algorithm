import java.util.Arrays;

/**
 * Given the preorder and inorder traversal sequence of a binary tree,
 * reconstruct the original tree.
 *
 * Assumptions
 *
 * The given sequences are not null and they have the same length
 * There are no duplicate keys in the binary tree
 * Examples
 *
 * preorder traversal = {5, 3, 1, 4, 8, 11}
 *
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 *
 * the corresponding binary tree is
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
 * Medium
 * Binary Tree
 */
public class ReconstructBinaryTreeWithPreorderAndInorder {
    public TreeNode reconstruct(int[] in, int[] pre) {
        int len = in.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (len == 1) {
            return root;
        }
        for (int i = 0; i < len; i++) {
            if (in[i] == root.key) {
                TreeNode left = reconstruct(Arrays.copyOfRange(in, 0, i),
                        Arrays.copyOfRange(pre, 1, i + 1));
                TreeNode right = reconstruct(Arrays.copyOfRange(in, i + 1, len),
                        Arrays.copyOfRange(pre, i + 1, len));
                root.left = left;
                root.right = right;
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ReconstructBinaryTreeWithPreorderAndInorder instance = new ReconstructBinaryTreeWithPreorderAndInorder();
        instance.reconstruct(new int[]{2,3,1},new int[]{1,3,2});
    }
}
