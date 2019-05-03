package Tree;
//Given a binary tree,
// you need to compute the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
// This path may or may not pass through the root.
//
//Example:
//        Given a binary tree
//            1
//           / \
//          2   3
//         / \
//        4   5
//        Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//        Note: The length of path between two nodes is represented by the number of edges between them.
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[] {0};
        arrowPath(root, max);
        return max[0];
    }

    // node number of the path
    private int arrowPath(TreeNode root, int[] max) {
        if (root == null) return 0;
        int leftPath = arrowPath(root.left, max);
        int rightPath = arrowPath(root.right, max);
        max[0] = Math.max(max[0], leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}
