package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

//Given a binary search tree with non-negative values,
// find the minimum absolute difference between values of any two nodes.
//
//        Example:
//
//        Input:
//
//        1
//          \
//           3
//          /
//         2
//
//        Output:
//        1
//
//        Explanation:
//        The minimum absolute difference is 1,
// which is the difference between 2 and 1 (or between 2 and 3).
//
//
//        Note: There are at least two nodes in this BST.
public class MinimumAbsoluteDifferenceInBST {
    /**
     * Time: O(n)
     * Space: O(height)
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        //in-order traverse
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNode(root, stack);
        int min = Integer.MAX_VALUE;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prev != null) {
                min = Math.min(min, cur.val - prev.val);
            }
            prev = cur;
            firstNode(cur.right, stack);
        }
        return min;
    }

    private void firstNode(TreeNode root, Deque<TreeNode> stack) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
