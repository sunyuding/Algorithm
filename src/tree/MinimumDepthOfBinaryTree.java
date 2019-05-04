package tree;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

//111. Minimum Depth of Binary tree
//Given a binary tree, find its minimum depth.
//
//        The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given binary tree [3,9,20,null,null,15,7],
//
//          3
//        /   \
//        9   20
//           /   \
//          15    7
//        return its minimum depth = 2.
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // leaf node
        if (root.left == null && root.right == null) return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            // left == null
            return 1 + right;
        }  else if (right == 0) {
            return 1 + left;
        } else {
            return 1 + Math.min(left, right);
        }
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null) return 0;
        // leaf node
        if (root.left == null && root.right == null) return 1;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<TreeNode, Integer>(root, 1));
        int depth = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            if (cur.getKey().left == null && cur.getKey().right == null) depth = Math.min(depth, cur.getValue());
            if (cur.getKey().left != null) stack.push(new Pair<TreeNode, Integer>(cur.getKey().left, cur.getValue() + 1));
            if (cur.getKey().right != null) stack.push(new Pair<TreeNode, Integer>(cur.getKey().right, cur.getValue() + 1));
        }
        return depth;
    }
}
