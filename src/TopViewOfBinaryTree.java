import java.util.*;

/**
 * Given a binary tree,
 * get the top view of it.
 * The nodes in the output list should be from left to right.
 * A node x belongs to the output if x is the topmost node at its column.
 *
 * Examples:
 *
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4  (5,6)  7
 *
 * the top view is [4, 2, 1, 3, 7]
 *
 * Medium
 * Binary tree
 */
public class TopViewOfBinaryTree {
    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Deque<Integer> deque = new LinkedList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == 0) {
                    deque.offerFirst(cur.key);
                }
                if (i != 0 && i == size - 1) {
                    deque.offerLast(cur.key);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return new ArrayList<>(deque);
    }
}
