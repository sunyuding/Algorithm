package tree;

/**
 * Time: (n)
 * Space: O(height)
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return rangeSumBST(root.left, L, root.val - 1) + root.val + rangeSumBST(root.right, root.val + 1, R);
        }
    }
}
