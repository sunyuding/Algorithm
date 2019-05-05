package tree;

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int[] result = new int[] {0};
        pathSumRoot(root, sum, root.val, result);
        return result[0] + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private void pathSumRoot(TreeNode root, int sum, int curSum, int[] result) {
        if (root == null) return;
        if (curSum == sum) {
            result[0]++;
        }
        if (root.left != null) {
            curSum += root.left.val;
            pathSumRoot(root.left, sum, curSum, result);
            curSum -= root.left.val;
        }
        if (root.right != null) {
            curSum += root.right.val;
            pathSumRoot(root.right, sum, curSum, result);
            curSum -= root.right.val;
        }
    }
}
