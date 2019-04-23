package Tree;
//98. Validate Binary Search Tree
//        Given a binary tree,
// determine if it is a valid binary search tree (BST).
//
//        Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than the node's key.
//        The right subtree of a node contains only nodes with keys greater than the node's key.
//        Both the left and right subtrees must also be binary search trees.
//        Example 1:
//
//        Input:
//        2
//        / \
//        1   3
//        Output: true
//        Example 2:
//
//        5
//        / \
//        1   4
//        / \
//        3   6
//        Output: false
//        Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
//        is 5 but its right child's value is 4.
public class ValidateBinarySearchTree {
    //Time: O(n)
    //Space: O(call stack height)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val < minValue || root.val > maxValue) return false;
        if (root.val == Integer.MIN_VALUE && root.left != null) {
            return false;
        }
        if (root.val == Integer.MAX_VALUE && root.right != null) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val - 1)
                && isValidBST(root.right, root.val + 1, maxValue);
    }
}
