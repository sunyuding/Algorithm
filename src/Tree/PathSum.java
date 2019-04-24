package Tree;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

//Given a binary tree and a sum,
// determine if the tree has a root-to-leaf path
// such that adding up all the values along the path equals the given sum.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given the below binary tree and sum = 22,
//
//             5
//          /    \
//         4      8
//        /     /   \
//       11    13    4
//      /  \          \
//     7    2          1
//        return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<TreeNode, Integer>(root, sum));
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            if (cur.getKey().left == null && cur.getKey().right == null && cur.getKey().val == cur.getValue()) return true;
            if (cur.getKey().left != null) {
                stack.push(new Pair<TreeNode, Integer>(cur.getKey().left, cur.getValue() - cur.getKey().val));
            }
            if (cur.getKey().right != null) {
                stack.push(new Pair<TreeNode, Integer>(cur.getKey().right, cur.getValue() - cur.getKey().val));
            }
        }
        return false;
    }
}
