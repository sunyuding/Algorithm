package tree;

import java.util.*;

//501. Find Mode in Binary Search tree
//        Given a binary search tree (BST) with duplicates,
// find all the mode(s) (the most frequently occurred element) in the given BST.
//
//        Assume a BST is defined as follows:
//
//        The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//        The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//        Both the left and right subtrees must also be binary search trees.
//
//
//        For example:
//        Given BST [1,null,2,2],
//
//           1
//            \
//             2
//            /
//           2
//
//
//           return [2].
//
//           Note: If a tree has more than one mode,
// you can return them in any order.
//
//           Follow up: Could you do that without using any extra space?
// (Assume that the implicit stack space incurred due to recursion does not count).
public class FindModeInBinarySearchTree {

    TreeNode prev;
    int max;
    int count;


    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        prev = null;
        max = 0;
        count = 1;

        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        // update count;
        if (prev != null) {
            if (prev.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        // update max;
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root;
        traverse(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.right = node1;
        node1.left = node2;
        FindModeInBinarySearchTree ins = new FindModeInBinarySearchTree();
        ins.findMode(root);
    }
}
