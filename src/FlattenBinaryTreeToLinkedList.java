/**
 * Given a binary tree,
 * flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 *
 * Medium
 * Binary Tree
 * Depth First Search
 */
public class FlattenBinaryTreeToLinkedList {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);
        if (left == null) {
            root.right = right;
        } else if (right == null){
            root.right = left;
            root.left = null;
        } else {
            root.right = left;
            root.left = null;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        return root;
    }
}
