package tree;
//Given a non-empty binary tree,
// find the maximum path sum.
//
//        For this problem,
// a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
// The path must contain at least one node and does not need to go through the root.
//
//        Example 1:
//
//        Input: [1,2,3]
//
//          1
//         / \
//        2   3
//
//        Output: 6
//        Example 2:
//
//        Input: [-10,9,20,null,null,15,7]
//
//        -10
//        / \
//        9  20
//        /  \
//        15   7
//
//        Output: 42
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
    // Time: O(n)
    // Space: O(tree height)
    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        int maxGainLeft = maxGain(root.left);
        int maxGainRight = maxGain(root.right);
        if (maxGainLeft <= 0 && maxGainRight <= 0) {
            max = Math.max(max, root.val);
            return root.val;
        } else if (maxGainLeft <= 0) {
            max = Math.max(max, root.val + maxGainRight);
            return root.val + maxGainRight;
        } else if (maxGainRight <= 0) {
            max = Math.max(max, root.val + maxGainLeft);
            return root.val + maxGainLeft;
        } else {
            max = Math.max(max, root.val + maxGainLeft + maxGainRight);
            return root.val + Math.max(maxGainLeft, maxGainRight);
        }
    }
}
