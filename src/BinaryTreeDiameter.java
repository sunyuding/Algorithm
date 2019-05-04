import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree in which each node contains an integer number.
 * The diameter is defined as the longest distance from one leaf node to another leaf node.
 * The distance is the number of nodes on the path.

 If there does not exist any such paths, return 0.

 Examples

 5

 /    \

 2      11

 /    \

 6     14

 The diameter of this tree is 4 (2 → 5 → 11 → 14)

 How is the binary tree represented?

 We use the level order traversal sequence with a special symbol "#" denoting the null node.

 For Example:

 The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

 1

 /   \

 2     3

 /

 4

 Medium
 Binary tree
 */
public class BinaryTreeDiameter {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (getHeight(cur.left) != 0 && getHeight(cur.right) != 0) {
                int leftToRight =  1 + getHeight(cur.left) + getHeight(cur.right);
                result = Math.max(result, leftToRight);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return result;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
