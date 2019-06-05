package tree;
// Given a Binary Search Tree (BST) with root node root,
// and a target value V,
// split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value,
// while the other subtree has all nodes that are greater than the target value.
// It's not necessarily the case that the tree contains a node with value V.
//
//        Additionally,
// most of the structure of the original tree should remain.
// Formally,
// for any child C with parent P in the original tree,
// if they are both in the same subtree after the split,
// then node C should still have the parent P.
//
//        You should output the root TreeNode of both subtrees after splitting,
// in any order.
//
//        Example 1:
//
//        Input: root = [4,2,6,1,3,5,7], V = 2
//        Output: [[2,1],[4,3,6,null,null,5,7]]
//        Explanation:
//        Note that root,
// output[0],
// and output[1] are TreeNode objects,
// not arrays.
//
//        The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
//
//             4
//           /   \
//          2      6
//         / \    / \
//        1   3  5   7
//
//        while the diagrams for the outputs are:
//
//             4
//           /   \
//          3     6      and    2
//         / \                 /
//        5   7               1
//        Note:
//
//        The size of the BST will not exceed 50.
//        The BST is always valid and each node's value is different.

/**
 * Recursion
 * The root node either belongs to the first half or the second half.
 * Let's say it belongs to the first half.
 * Time: O(n)
 * Space: O(n)
 */
//public class SplitBST {
//    public TreeNode[] splitBST(TreeNode root, int V) {
//        TreeNode[] res = new TreeNode[2];
//        if (root == null) return res;
//        if (root.val <= V) {
//            TreeNode[] nodes = splitBST(root.right, V);
//            root.right = nodes[0];
//            nodes[0] = root;
//            return nodes;
//        } else {
//            TreeNode[] nodes = splitBST(root.left, V);
//            root.left = nodes[1];
//            nodes[1] = root;
//            return nodes;
//        }
//    }
//}

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Iteration
 * Time: O(n)
 * Space: O(n)
 */
public class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) return res;
        // find the node in the BST with smallest value larger than V
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(cur != null) {
            if (cur.val <= V) {
                stack.push(cur);
                cur = cur.right;
            } else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        while(!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.val <= V) {
                // keep res[0] <= V
                cur.right = res[0];
                res[0] = cur;
            } else {
                // keep res[1] > V
                cur.left = res[1];
                res[1] = cur;
            }
        }
        return res;
    }
}
