package Tree;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree,
// return all root-to-leaf paths.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Input:
//
//            1
//          /   \
//         2     3
//          \
//           5
//
//        Output: ["1->2->5", "1->3"]
//
//        Explanation: All root-to-leaf paths are: 1->2->5, 1->3
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        StringBuilder cur = new StringBuilder();
        cur.append(root.val);
        dfs(root, cur, result);
        return result;
    }

    private void dfs(TreeNode root, StringBuilder cur, List<String> result) {
        if (root == null) {
            return;
        }
        // leaf node
        if (root.left == null && root.right == null) {
            result.add(new String(cur));
            return;
        }
        if (root.left != null) {
            cur.append("->").append(root.left.val);
            dfs(root.left, cur, result);
            int index = cur.lastIndexOf("->");
            cur.delete(index, cur.length());
        }
        if (root.right != null) {
            cur.append("->").append(root.right.val);
            dfs(root.right, cur, result);
            int index = cur.lastIndexOf("->");
            cur.delete(index, cur.length());
        }
    }
}
