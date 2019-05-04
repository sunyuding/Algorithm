import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a Binary tree,
 * return the right view of it.
 * Right view of a Binary tree is list of nodes visible when tree is visited from Right side,
 * the order of the nodes in the list should be from top to bottom level of the original tree.
 *
 * Examples:
 *            1
 *         /    \
 *        2      3
 *       / \    /  \
 *      4   5   6  7
 *     /            \
 *     9             8
 *
 *   /  \
 *
 *  10  11
 *
 * the right view =  [1, 3, 7, 8, 11]
 *
 * Medium
 * Binary tree
 */
public class RightViewOfBinaryTree {
    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == size - 1) {
                    result.add(cur.key);
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
