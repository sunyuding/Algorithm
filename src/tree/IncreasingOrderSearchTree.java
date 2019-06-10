package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time: O(n)
 * Space: O(height)
 */
//public class IncreasingOrderSearchTree {
//    public TreeNode increasingBST(TreeNode root) {
//        if (root == null) return null;
//        TreeNode newRoot;
//        if (root.left != null) {
//            TreeNode left = root.left;
//            root.left = null;
//            newRoot = increasingBST(left);
//            TreeNode cur = newRoot;
//            while (cur.right != null) {
//                cur = cur.right;
//            }
//            cur.right = root;
//        } else {
//            newRoot = root;
//        }
//        root.right = increasingBST(root.right);
//        return newRoot;
//    }
//}


/**
 * Time : O(n)
 * Space: O(height)
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(stack, root);
        TreeNode pre = null;
        TreeNode newRoot = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (newRoot == null) {
                newRoot = cur;
            }
            if (pre != null) {
                pre.right = cur;
            }
            pushLeft(stack, cur.right);
            pre = cur;
        }
        return newRoot;
    }

    private void pushLeft(Deque<TreeNode> stack, TreeNode cur) {
        while(cur != null) {
            TreeNode left = cur.left;
            cur.left = null;
            stack.push(cur);
            cur = left;
        }
    }
}
