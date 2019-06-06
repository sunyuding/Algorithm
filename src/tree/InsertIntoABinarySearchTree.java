package tree;

/**
 * Time: O(n)
 * Space: O(1)
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode largestSmaller = null;
        TreeNode smallestLarget = null;
        while(root != null) {
            if (root.val < val) {
                largestSmaller = root;
                root = root.right;
            } else {
                smallestLarget = root;
                root = root.left;
            }
        }
        if (largestSmaller == null) {
            smallestLarget.left = new TreeNode(val);
        } else {
            if (largestSmaller.right == null) {
                largestSmaller.right = new TreeNode(val);
            } else {
                TreeNode tmp = largestSmaller.right;
                largestSmaller.right = new TreeNode(val);
                largestSmaller.right.right = tmp;
            }
        }
        return root;
    }
}
