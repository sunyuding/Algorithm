//Description
//        Delete the target key K in the given binary search tree if the binary search tree contains K.
// Return the root of the binary search tree.
//
//        Find your own way to delete the node from the binary search tree,
// after deletion the binary search tree's property should be maintained.
//
//        Assumptions
//
//        There are no duplicate keys in the binary search tree
//
//        Medium
//        Binary tree
//        Iterative
//        Recursion


public class DeleteInBinarySearchTree {
    class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.key = key;
        }
    }
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.key == key) {
            // node to be deleted has no children
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                // node to be deleted has one children
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                // node to be deleted has two children
                // move the min of right side replace of root
                root.key = getMin(root.right).key;
                root.right = delete(root.right, root.key);
                return root;
            }
        } else if (key < root.key) {
            // left side
            root.left = delete(root.left, key);
        } else {
            // right side
            root.right = delete(root.right, key);
        }
        return root;
    }

    // root should not be null
    private TreeNode getMin(TreeNode root) {
        if (root.left == null) {
            return root;
        } else {
            return getMin(root.left);
        }
    }

}
