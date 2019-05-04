import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


//Description
//        Get the list of keys in a given binary tree layer by layer in zig-zag order.
//
//        Examples
//
//        5
//
//        /    \
//
//        3        8
//
//        /   \        \
//
//        1     4        11
//
//        the result is [5, 3, 8, 11, 4, 1]
//
//        Corner Cases
//
//        What if the binary tree is null? Return an empty list in this case.
//How is the binary tree represented?
//
//        We use the level order traversal sequence with a special symbol "#" denoting the null node.
//
//        For Example:
//
//        The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
//
//        1
//
//        /   \
//
//        2     3
//
//        /
//
//        4
//
//        Medium
//        Binary tree
//        Breadth First Search
public class GetKeysInBinaryTreeLayerByL {
    class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode (int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
    public List<Integer> zigZag(TreeNode root) {

        List<Integer> result = new ArrayList<>();
//        Corner Cases
//        What if the binary tree is null? Return an empty list in this case.
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int layer = 0;
        while(!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    // even, from right to left
                    TreeNode tmp = deque.pollLast();
                    result.add(tmp.key);
                    if (tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }
                } else {
                    // odd, from left to right
                    TreeNode tmp = deque.pollFirst();
                    result.add(tmp.key);
                    if (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return result;
    }
}
