import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths from left to right.
 *
 * For example, given the following binary tree:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 * Easy
 * Binary Tree
 * Depth First Search
 */
public class BinaryTreePaths {
    public String[] binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(root, cur, result);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(TreeNode root, List<Integer> cur, List<String> result) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            cur.add(root.key);
            result.add(listToString(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        cur.add(root.key);
        dfs(root.left, cur, result);
        dfs(root.right, cur, result);
        cur.remove(cur.size() - 1);
    }

    private String listToString(List<Integer> cur) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cur.size(); i++) {
            if (i > 0) {
                sb.append("->");
            }
            sb.append(cur.get(i).toString());
        }
        return sb.toString();
    }
}