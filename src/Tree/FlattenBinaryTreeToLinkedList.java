package Tree;
//Given a binary tree, flatten it to a linked list in-place.
//
//        For example, given the following tree:
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        The flattened tree should look like:
//
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        root.left = null;
        TreeNode right = root.right;
        root.right = null;

        flatten(left);
        flatten(right);

        root.right = left;

        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }

        cur.right = right;
        return;
    }
}
