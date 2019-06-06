package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time: O(n)
 * Space: O(1)
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(stack, root);
        TreeNode pre = null;
        int res = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (pre != null) {
                res = Math.min(res, cur.val - pre.val);
            }
            pushLeft(stack, cur.right);
            pre = cur;
        }
        return res;
    }

    private void pushLeft(Deque<TreeNode> stack, TreeNode cur) {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
