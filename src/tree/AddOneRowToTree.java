package tree;
//623. Add One Row to Tree
//Given the root of a binary tree,
// then value v and depth d,
// you need to add a row of nodes with value v at the given depth d.
// The root node is at depth 1.

//        The adding rule is:
// given a positive integer depth d,
// for each NOT null tree nodes N in depth d-1,
// create two tree nodes with value v as N's left subtree root and right subtree root.
// And N's original left subtree should be the left subtree of the new left subtree root,
// its original right subtree should be the right subtree of the new right subtree root.
// If depth d is 1 that means there is no depth d-1 at all,
// then create a tree node with value v as the new root of the whole original tree,
// and the original tree is the new root's left subtree.
//Example 1:
//        Input:
//        A binary tree as following:
// 1            4
//            /   \
// 2         2     6
//          / \   /
// 3       3  1  5
//
//        v = 1
//
//        d = 2
//
//        Output:
//              4
//             / \
//            1   1
//           /     \
//          2       6
//         / \     /
//        3   1   5
//Example 2:
//        Input:
//        A binary tree as following:
// 1           4
//            /
// 2         2
//          / \
// 3       3   1
//
//        v = 1
//
//        d = 3
//
//        Output:
//              4
//             /
//            2
//           / \
//          1   1
//         /     \
//        3       1

import java.util.LinkedList;
import java.util.Queue;

//Note:
//        The given d is in range [1, maximum depth of the given tree + 1].
//        The given binary tree has at least one tree node.
public class AddOneRowToTree {
    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        // If depth d is 1 that means there is no depth d-1 at all,
        // then create a tree node with value v as the new root of the whole original tree,
        // and the original tree is the new root's left subtree.
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //find d - 1 level;
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (level == d - 1) {
                    TreeNode left = cur.left;
                    cur.left = new TreeNode(v);
                    cur.left.left = left;

                    TreeNode right = cur.right;
                    cur.right = new TreeNode(v);
                    cur.right.right = right;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (level == d - 1) {
                break;
            }
            level++;

        }
        return root;
    }
}
