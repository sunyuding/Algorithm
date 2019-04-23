package Tree;
//Given a binary tree,
// check whether it is a mirror of itself (ie, symmetric around its center).
//
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//        But the following [1,2,2,null,3,null,3] is not:
//        1
//        / \
//        2   2
//        \   \
//        3    3
//        Note:
//        Bonus points if you could solve it both recursively and iteratively.
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode right = rotate(root.right);
        return isSameTree(root.left, right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    private TreeNode rotate(TreeNode root) {
        if (root == null) return root;
        root.left = rotate(root.left);
        root.right = rotate(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
