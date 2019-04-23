package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

//Given two binary trees,
// write a function to check if they are the same or not.
//
//        Two binary trees are considered the same if they are structurally identical
// and the nodes have the same value.
//
//        Example 1:
//
//        Input:     1         1
//        / \       / \
//        2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//        Output: true
//        Example 2:
//
//        Input:     1         1
//        /           \
//        2             2
//
//        [1,2],     [1,null,2]
//
//        Output: false
//        Example 3:
//
//        Input:     1         1
//        / \       / \
//        2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//        Output: false
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    private boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        Deque<TreeNode> stackP = new ArrayDeque<>();
        Deque<TreeNode> stackQ = new ArrayDeque<>();
        stackP.push(p);
        stackQ.push(q);
        firstNode(p, stackP);
        firstNode(q, stackQ);
        while(!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode curP = stackP.pop();
            TreeNode curQ = stackQ.pop();
        }
        return false;
    }

    private void firstNode(TreeNode cur, Deque<TreeNode> stack) {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
