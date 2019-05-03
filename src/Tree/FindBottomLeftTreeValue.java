package Tree;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree,
// find the leftmost value in the last row of the tree.
//
//        Example 1:
//        Input:
//
//          2
//         / \
//        1   3
//
//        Output:
//        1
//Note: You may assume the tree (i.e., the given root node) is not NULL.
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        // level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int result = root.val;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean firstTime = true;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (firstTime) {
                    result = cur.val;
                    firstTime = false;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return result;
    }
}
