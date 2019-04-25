package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Given a binary tree,
// return the preorder traversal of its nodes' values.
//
//        Example:
//
//        Input: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//
//        Output: [1,2,3]
//        Follow up: Recursive solution is trivial, could you do it iteratively?
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }
}
