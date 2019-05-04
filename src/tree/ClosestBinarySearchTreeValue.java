package tree;

//Given a non-empty binary search tree and a target value,
// find the value in the BST that is closest to the target.
//
//        Note:
//
//        Given target value is a floating point.
//        You are guaranteed to have only one unique value in the BST that is closest to the target.
//        Example:
//
//        Input: root = [4,2,5,1,3], target = 3.714286
//
//          4
//         / \
//        2   5
//       / \
//      1   3
//
//        Output: 4
//           1
//          /  \
//         null 2

public class ClosestBinarySearchTreeValue {
    // O(height)
    public int closestValue(TreeNode root, double target) {
        TreeNode cur  = root;
        int closest = root.val;
        while(cur != null) {
            if (Math.abs(cur.val - target) < Math.abs(closest - target)) {
                closest = cur.val;
            }
            if (cur.val == target) {
                break;
            } else if (cur.val < target) {
                cur = cur.right;
            } else if (cur.val > target) {
                cur = cur.left;
            }
        }
        return closest;
    }
}
