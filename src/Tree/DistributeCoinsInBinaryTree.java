package Tree;
//Given the root of a binary tree with N nodes,
// each node in the tree has node.val coins,
// and there are N coins total.
//
//        In one move,
// we may choose two adjacent nodes and move one coin from one node to another.
// (The move may be from parent to child, or from child to parent.)
//
//        Return the number of moves required to make every node have exactly one coin.
//Note:
//
//1<= N <= 100
//0 <= node.val <= N
public class DistributeCoinsInBinaryTree {
    public int distributeCoins(TreeNode root) {
        int[] result = new int[] {0};
        gain(root, result);
        return result[0];
    }
    // gain from the subtree
    private int gain(TreeNode root, int[] result) {
        if (root == null) return 0;
        int left = gain(root.left, result);
        int right = gain(root.right, result);
        result[0] += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}
