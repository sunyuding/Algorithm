package Tree;
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//        An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//        Find the total sum of all root-to-leaf numbers.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Input: [1,2,3]
//        1
//        / \
//        2   3
//        Output: 25
//        Explanation:
//        The root-to-leaf path 1->2 represents the number 12.
//        The root-to-leaf path 1->3 represents the number 13.
//        Therefore, sum = 12 + 13 = 25.
//        Example 2:
//
//        Input: [4,9,0,5,1]
//           4
//         /   \
//        9     0
//       / \
//      5   1
//        Output: 1026
//        Explanation:
//        The root-to-leaf path 4->9->5 represents the number 495.
//        The root-to-leaf path 4->9->1 represents the number 491.
//        The root-to-leaf path 4->0 represents the number 40.
//        Therefore, sum = 495 + 491 + 40 = 1026.

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * excluded
 */
//public class SumRootToLeafNumbers {
//    private class Wrapper {
//        TreeNode node;
//        int sum;    // the sum from root to current node(excluded)
//
//        Wrapper(TreeNode node, int sum) {
//            this.node = node;
//            this.sum = sum;
//        }
//    }
//    //dfs pre-order
//    public int sumNumbers(TreeNode root) {
//        int result = 0;
//        if (root == null) return result;
//        Deque<Wrapper> stack = new ArrayDeque<>();
//        stack.push(new Wrapper(root, 0));   // {{1}, 0}
//
//        while(!stack.isEmpty()) {
//            Wrapper cur = stack.pop();     // {{2}, 1}
//            TreeNode leftNode = cur.node.left; // {2}
//            TreeNode rightNode = cur.node.right; // {3}
//            int curSum = cur.sum * 10 + cur.node.val;  // 10 + 3
//            if (leftNode == null && rightNode == null) {
//                result += curSum;  //
//            }
//            if (leftNode != null) {
//                stack.push(new Wrapper(leftNode, curSum));  // {{2}, 1}
//            }
//            if (rightNode != null) {
//                stack.push(new Wrapper(rightNode, curSum)); // {{3}, 1}
//            }
//        }
//        return result;
//    }
//}

/**
 * included
 */
public class SumRootToLeafNumbers {
    private class Wrapper {
        TreeNode node;
        int sum;    // the sum from root to current node(included)

        Wrapper(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
    //dfs pre-order
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) return result;
        Deque<Wrapper> stack = new ArrayDeque<>();
        stack.push(new Wrapper(root, root.val));   // {{1}, 1}

        while(!stack.isEmpty()) {
            Wrapper cur = stack.pop();// {{2}, 1}
            TreeNode curNode = cur.node;
            TreeNode leftNode = curNode.left; // {2}
            TreeNode rightNode = curNode.right; // {3}
            int curSum = cur.sum;  //
            if (leftNode == null && rightNode == null) {
                result += curSum;
            }
            if (leftNode != null) {
                stack.push(new Wrapper(leftNode, curSum * 10 + leftNode.val));  // {{2}, 12}
            }
            if (rightNode != null) {
                stack.push(new Wrapper(rightNode, curSum * 10 + rightNode.val)); // {{3}, 13}
            }
        }
        return result;
    }
}
