package tree;

/**
 * Runtime: 0 ms
 * Memory Usage: 33.8 MB
 * Time: average case O(nlogn),
 *              n / 2
 *              n / 4 + n / 4
 *              n / 8 * 4
 *       worst case O(n ^ 2)
 *       base case O(n)
 * Space: O(logn)
 */
//public class ConstructBinarySearchTreeFromPreorderTraversal {
//
//    public TreeNode bstFromPreorder(int[] preorder) {
//        if (preorder == null || preorder.length == 0) return null;
//        return bstFromPreorder(preorder, 0, preorder.length - 1);
//    }
//
//    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
//        if (preorder == null || start > end) return null;
//        int cur = preorder[start];
//        TreeNode root = new TreeNode(cur);
//        int rightStart = start + 1;
//        while (rightStart <= end) {
//            if (preorder[rightStart] > root.val) {
//                break;
//            }
//            rightStart++;
//        }
//        // preorder[i] > root.val
//        root.left = bstFromPreorder(preorder, start + 1, rightStart - 1);
//        root.right = bstFromPreorder(preorder, rightStart, end);
//        return root;
//    }
//}

/**
 * Runtime: 0 ms
 * Memory Usage: 33.8 MB
 * Runtime: 1 ms
 * Memory Usage: 33.9 MB
 * Time: O(n)
 * Space: O(logn)
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    int preIndex = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    //preOrder next element > inorder next element => current subtree has completed
    private TreeNode bstFromPreorder(int[] preorder, int inOrderSuccessor) {
        if (preIndex == preorder.length || preorder[preIndex] > inOrderSuccessor) {
            return null;
        }
        // induction rule
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, inOrderSuccessor);
        return root;
    }
}
