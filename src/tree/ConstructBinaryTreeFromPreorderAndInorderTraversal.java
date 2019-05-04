package tree;

//Given preorder and inorder traversal of a tree,
// construct the binary tree.
//
//        Note:
//        You may assume that duplicates do not exist in the tree.
//
//        For example, given
//
//        preorder = [3,9,20,15,7]
//        inorder = [9,3,15,20,7]
//        Return the following binary tree:
//
//         3
//        /  \
//        9  20
//           /  \
//          15   7
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        if (preLeft == preRight)return new TreeNode(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inorderRootIndex = getIndex(inorder, root.val);
        int leftLength = inorderRootIndex - inLeft;
        int rightLength = inRight - inorderRootIndex;
        root.left = buildTree(preorder, preLeft + 1, preLeft + leftLength, inorder, inLeft, inorderRootIndex - 1);
        root.right = buildTree(preorder, preRight - rightLength + 1, preRight, inorder, inorderRootIndex + 1, inRight);
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

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal ins = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = new int[] {1, 2, 3};
        int[] inorder = new int[] {2, 3, 1};
        TreeNode root = ins.buildTree(preorder, inorder);

    }
}
