package tree;
//662.
//Given a binary tree,
// write a function to get the maximum width of the given tree.
// The width of a tree is the maximum width among all levels.
// The binary tree has the same structure as a full binary tree,
// but some nodes are null.
//
//        The width of one level is defined as the length between the end-nodes
// (the leftmost and right most non-null nodes in the level,
// where the null nodes between the end-nodes are also counted into the length calculation.
//
//        Example 1:
//
//        Input:
//
//             1
//           /        \
//          3          2
//         / \        /    \
//        5   3      null  9
//
//        Output: 4
//        Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

import java.util.LinkedList;
import java.util.Queue;

//        Example 2:
//        Input:
//
//             1
//            /
//           3
//          / \
//         5   3
//
//        Output: 2
//        Explanation: The maximum width existing in the third level with the length 2 (5,3).
//        Example 3:
//
//        Input:
//
//            1
//           / \
//          3   2
//         /
//        5
//
//        Output: 2
//        Explanation: The maximum width existing in the second level with the length 2 (3,2).
//        Example 4:
//
//        Input:
//
//              1
//             / \
//            3   2
//           /     \
//          5       9
//         /         \
//        6           7
//        Output: 8
//        Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
//
//
//        Note: Answer will in the range of 32-bit signed integer.
public class MaximumWidthOfBinaryTree {
    private class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        private AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<AnnotatedNode> q = new LinkedList<>();
        q.offer(new AnnotatedNode(root, 0, 0));
        int width = 1;
        while(!q.isEmpty()) {
            //for each level
            int size = q.size();
            int leftIndex = -1;
            int rightIndex = -1;
            for (int i = 0; i < size; i++) {
                AnnotatedNode cur = q.poll();
                if (leftIndex == -1) {
                    leftIndex = cur.pos;
                }
                rightIndex = cur.pos;
                if (cur.node.left != null) {
//                    if (leftIndex == -1) {
//                        leftIndex = cur.pos * 2;
//                    }
//                    rightIndex = cur.pos * 2;
                    q.offer(new AnnotatedNode(cur.node.left, cur.depth + 1, cur.pos * 2));
                }
                if (cur.node.right != null) {
//                    if (leftIndex == -1) {
//                        leftIndex = cur.pos * 2 + 1;
//                    }
//                    rightIndex = cur.pos * 2 + 1;
                    q.offer(new AnnotatedNode(cur.node.right, cur.depth + 1, cur.pos * 2 + 1));
                }
            }
            width = Math.max(width, rightIndex - leftIndex + 1);
        }
        return width;
    }
}
