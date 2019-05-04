package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwoSumIVInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        leftNode(root.left, stack);
        rightNode(root.right, stack);
        while(!stack.isEmpty()) {
            int sum = stack.peekFirst().val + stack.peekLast().val;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                TreeNode cur = stack.pollFirst();
                leftNode(cur.right, stack);
            } else {
                TreeNode cur = stack.pollLast();
                rightNode(cur.left, stack);
            }
        }
        return false;
    }

    private void leftNode(TreeNode node, Deque<TreeNode> stack) {
        while(node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
    }

    private void rightNode(TreeNode node, Deque<TreeNode> stack) {
        while(node != null) {
            stack.offerLast(node);
            node = node.right;
        }
    }
}
