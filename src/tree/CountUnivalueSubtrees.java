package tree;
//Given a binary tree,
// count the number of uni-value subtrees.
//
//        A Uni-value subtree means all nodes of the subtree have the same value.
//
//        Example :
//
//        Input:  root = [5,1,5,5,5,null,5]
//
//          5
//         / \
//        1   5
//       / \   \
//      5   5   5
//
//      Output: 4
public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[]{0};
        isUnivalTree(root, count);
        return count[0];
    }

    /**
     *
     * @param root
     * @param count
     * @return the node with the uni-value back tracking from the bottom
     */
    private boolean isUnivalTree(TreeNode root, int[] count) {
        if (root.left == null && root.right == null) {
            count[0]++;
            return true;
        }
        boolean isUnival = true;

        if (root.left != null) {
            isUnival = isUnivalTree(root.left, count) && root.left.val == root.val && isUnival;
        }

        if (root.right != null) {
            isUnival = isUnivalTree(root.right, count) && root.right.val == root.val && isUnival;
        }

        if (!isUnival) return false;
        count[0]++;
        return isUnival;
    }
}
