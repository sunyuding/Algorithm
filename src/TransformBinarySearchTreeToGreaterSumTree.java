/**
 * Given a BST,
 * change each node’s value,
 * such that its value is equal to the sum of all nodes greater than itself.
 *
 * Examples:
 *
 *      11
 *
 *     /  \
 *
 *   2     29
 *
 *  /  \  /  \
 *
 * 1   7 15  40
 *
 *           /
 *
 *          35
 *
 * is transformed to
 *
 *      119
 *
 *     /  \
 *
 *   137    75
 *
 *  /  \    /  \
 *
 * 139 130 104  0
 *
 *             /
 *
 *           40
 *
 * Medium
 * Binary Search Tree
 */
public class TransformBinarySearchTreeToGreaterSumTree {
//    public TreeNode greaterSum(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode newRoot = new TreeNode(traverse(root, root.key));
//
//        TreeNode leftNode;
//        if (root.left != null) {
//            leftNode = new TreeNode(traverse(root, root.left.key));
//        } else {
//            leftNode = null;
//        }
//
//        TreeNode rightNode;
//        if (root.right != null) {
//            rightNode = new TreeNode(traverse(root, root.right.key));
//        } else {
//            rightNode = null;
//        }
//
//        newRoot.left = leftNode;
//        newRoot.right = rightNode;
//        return newRoot;
//    }
//
//    private int traverse(TreeNode root, int target) {
//        if (root == null) {
//            return 0;
//        }
//        int leftSum = traverse(root.left, target);
//        int rightSum = traverse(root.right, target);
//        if (root.key > target) {
//            return leftSum + root.key + rightSum;
//        } else {
//            return leftSum + rightSum;
//        }
//    }
    // O(n ^ 2)

    public TreeNode greaterSum(TreeNode root) {
        int sum = 0;
        traverse(root, sum);
        return root;
    }

    private void traverse(TreeNode root, int sum) {
        if (root == null) return;
        traverse(root.right, sum);

        int tmp = root.key;
        root.key = sum;
        sum += tmp;

        traverse(root.left, sum);
    }
}
