package tree;

/**
 * Time: O(n)
 * Space: O(height)
 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return (root.left == null || isUnivalTree(root.left) && root.val == root.left.val)
                && (root.right == null || isUnivalTree(root.right) && root.val == root.right.val);
    }
}
