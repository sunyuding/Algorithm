import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the levelorder traversal sequence of a binary search tree,
 * reconstruct the original tree.
 *
 * Assumptions
 *
 * The given sequence is not null
 * There are no duplicate keys in the binary search tree
 * Examples
 *
 * levelorder traversal = {5, 3, 8, 1, 4, 11}
 *
 * the corresponding binary search tree is
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * How is the binary tree represented?
 *
 * We use the pre order traversal sequence with a special symbol "#" denoting the null node.
 *
 * For Example:
 *
 * The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
 *
 *     1
 *
 *   /   \
 *
 *  2     3
 *
 *       /
 *
 *     4
 *
 * Medium
 * Binary Search Tree
 */
public class ReconstructBinarySearchTreeWithLevelOrderTraversal {
    public TreeNode reconstruct(int[] level) {
        if (level == null || level.length == 0) {
            return null;
        }
        return null;
    }
}
