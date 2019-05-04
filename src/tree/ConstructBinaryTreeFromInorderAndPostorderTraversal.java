package tree;
//Given inorder and postorder traversal of a tree,
// construct the binary tree.
//
//        Note:
//        You may assume that duplicates do not exist in the tree.
//
//        For example, given
//
//        inorder = [9,3,15,20,7]
//        postorder = [9,15,7,20,3]
//        Return the following binary tree:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
        if (postLeft > postRight) return null;
        if (postLeft == postRight)return new TreeNode(postorder[postRight]);
        TreeNode root = new TreeNode(postorder[postRight]);
        int inorderRootIndex = getIndex(inorder, root.val);
        int leftLength = inorderRootIndex - inLeft;
        int rightLength = inRight - inorderRootIndex;
        root.left = buildTree(postorder, postLeft, postLeft + leftLength - 1, inorder, inLeft, inorderRootIndex - 1);
        root.right = buildTree(postorder, postRight - rightLength, postRight - 1, inorder, inorderRootIndex + 1, inRight);
        return root;
    }

    private int getIndex(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
