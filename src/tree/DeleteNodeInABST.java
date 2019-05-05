package tree;
//Given a root node reference of a BST and a key,
// delete the node with the given key in the BST.
// Return the root node reference (possibly updated) of the BST.
//
//        Basically, the deletion can be divided into two stages:
//
//        Search for a node to remove.
//        If the node is found, delete the node.
//        Note: Time complexity should be O(height of tree).
public class DeleteNodeInABST {
    // O(height of tree)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                TreeNode successor = getSuccessor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            } else {
                TreeNode predecessor = getPredecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode(root.left, predecessor.val);
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key); // O(height of tree)

        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode getPredecessor(TreeNode root) {
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        //root.right == null
        return root;
    }

    private TreeNode getSuccessor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


}
