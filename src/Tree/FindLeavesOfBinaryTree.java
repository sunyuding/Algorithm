package Tree;

import java.util.*;

//Given a binary tree,
// collect a tree's nodes as if you were doing this: Collect and remove all leaves,
// repeat until the tree is empty.

public class FindLeavesOfBinaryTree {
    /**
     * Time: O(n)
     * Space: O(height of tree)
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
    }

    private int height(TreeNode root, List<List<Integer>> result) {
        if (root == null) return - 1;
        int height = 0;
        int left = height(root.left, result);
        int right = height(root.right, result);
        height = 1 + Math.max(left, right);
        if (result.size() == height) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        return height;
    }
}
