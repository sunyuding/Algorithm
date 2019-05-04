//    Given a binary tree where all the right nodes are leaf nodes,
// flip it upside down and turn it into a tree with left leaf nodes as the root.
//
//        Examples
//
//        1
//
//        /    \
//
//        2        5
//
//        /   \
//
//        3      4
//
//        is reversed to
//
//        3
//
//        /    \
//
//        2        4
//
//        /   \
//
//        1      5
//
//        How is the binary tree represented?
//
//        We use the pre order traversal sequence with a special symbol "#" denoting the null node.
//
//        For Example:
//
//        The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
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
//        Iterative
//        Linked List
//        Recursion

public class ReverseBinaryTreeUpsideDown {

    class TreeNode{
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode reverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left, right = root.right;
        if (left != null) {
            TreeNode newRoot = reverse(left);
            left.left = right;
            left.right = root;

            root.left = null;
            root.right = null;
            return newRoot;
        }
        return null;
    }
}
