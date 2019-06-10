package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 0 ms
 * Memory Usage: 34.4 MB
 * Time: O(n)
 * Space: O(height)
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        backtracking(root1, list1);
        backtracking(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).val != list2.get(i).val) {
                return false;
            }
        }
        return true;
    }

    private void backtracking(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root);
            return;
        }
        backtracking(root.left, list);
        backtracking(root.right, list);
    }
}
