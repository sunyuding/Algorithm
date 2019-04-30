package Tree;

//Given a binary tree,
// find the largest subtree which is a Binary Search Tree (BST),
// where largest means subtree with largest number of nodes in it.
//
//        Note:
//        A subtree must include all of its descendants.
//
//        Example:
//
//        Input: [10,5,15,1,8,null,7]
//
//            10
//           /  \
//          5    15
//         / \    \
//        1   8    7
//
//        Output: 3
//        Explanation: The Largest BST Subtree in this case is the highlighted one.
//        The return value is the subtree's size, which is 3.
//        Follow up:
//        Can you figure out ways to solve it with O(n) time complexity?

public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        int[] larget = new int[]{0};
        backTracking(root, larget);
        return larget[0];
    }

    private void backTracking(TreeNode node, int[] larget) {
        if (node == null) {
            return;
        }
        if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            larget[0] = Math.max(larget[0], getSize(node));
            return;
        }
        if (node.left != null) {
            backTracking(node.left, larget);
        }
        if (node.right != null) {
            backTracking(node.right, larget);
        }
    }

    private int getSize(TreeNode node) {
        if (node == null) return 0;
        return 1 + getSize(node.left) + getSize(node.right);
    }

    private boolean isBST(TreeNode node, int start, int end) {
        if (node == null) return true;
        if (node.val < start || node.val > end) return false;
        return (node.val == Integer.MIN_VALUE || isBST(node.left, start, node.val - 1))
                && (node.val == Integer.MAX_VALUE || isBST(node.right, node.val + 1, end));
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    //            10
//           /  \
//          5    15
//         / \    \
//        1   8    7

    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n15 = new TreeNode(15);
        TreeNode n1 = new TreeNode(1);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        n10.left = n5;
        n10.right = n15;
        n5.left = n1;
        n5.right = n8;
        n15.right = n7;
        LargestBSTSubtree ins = new LargestBSTSubtree();
        int i = ins.largestBSTSubtree(n10);
        System.out.println(i);
    }
}
