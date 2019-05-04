package tree;

//The thief has found himself a new place for his thievery again.
// There is only one entrance to this area,
// called the "root."
// Besides the root,
// each house has one and only one parent house.
// After a tour,
// the smart thief realized that "all houses in this place forms a binary tree".
// It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//        Determine the maximum amount of money the thief can rob tonight without alerting the police.
//
//        Example 1:
//
//        Input: [3,2,3,null,3,null,1]
//
//         3
//        /  \
//        2   3
//         \   \
//          3   1
//
//        Output: 7
//        Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
//        Example 2:
//
//        Input: [3,4,5,1,3,null,1]
//
//            3
//           / \
//          4   5
//         / \   \
//        1   3   1
//
//        Output: 9
//        Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int max = 0;
        if (root == null) return 0;

        // do not steel root
        int cur = 0;
        cur += rob(root.left);
        cur += rob(root.right);
        max = Math.max(max, cur);

        // steel root
        // then the next level cannot be stole
        cur = root.val;
        if (root.left != null) {
            cur += rob(root.left.left);
            cur += rob(root.left.right);
        }
        if (root.right != null) {
            cur += rob(root.right.left);
            cur += rob(root.right.right);
        }
        max = Math.max(max, cur);
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        HouseRobberIII ins = new HouseRobberIII();
        int i = ins.rob(root);
    }
}
