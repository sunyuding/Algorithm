package tree;
//Given the root node of a binary search tree (BST) and a value.
// You need to find the node in the BST that the node's value equals the given value.
// Return the subtree rooted with that node.
// If such node doesn't exist, you should return NULL.
public class SearchInABinarySearchTree {
    /**
     * Time: O(height)
     * Space: O(height)
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            // root.val > val
            return searchBST(root.left, val);
        }
    }
}
