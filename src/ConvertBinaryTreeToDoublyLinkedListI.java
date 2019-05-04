/**
 * Given a binary tree,
 * convert it to a doubly linked list in place (use the left pointer as previous,
 * use the right pointer as next).
 *
 * The values in the nodes of the doubly linked list should follow
 * the in-order traversal sequence of the binary tree.
 *
 * Examples:
 *
 *     10
 *
 *    /  \
 *
 *   5    15
 *
 *  /
 *
 * 2
 *
 * Output:  2 <-> 5 <-> 10 <-> 15
 *
 * Medium
 * Binary tree
 */
public class ConvertBinaryTreeToDoublyLinkedListI {
    public TreeNode toDoubleLinkedList(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = toDoubleLinkedList(root.left);
        TreeNode right = toDoubleLinkedList(root.right);
        if (left == null) {
            if (right != null) {
                root.right = right;
                right.left = root;
            }
            return root;
        } else {
            TreeNode cur = left;
            while(cur.right != null) {
                cur = cur.right;
            }
            cur.right = root;
            root.left = cur;
            if (right != null) {
                root.right = right;
                right.left = root;
            }
            return left;
        }
    }
}
