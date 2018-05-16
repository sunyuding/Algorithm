import java.util.HashSet;
import java.util.Set;

/**
 * Given two nodes in a binary tree (with parent pointer available),
 * find their lowest common ancestor.
 *
 * Assumptions
 *
 * There is parent pointer for the nodes in the binary tree
 *
 * The given two nodes are not guaranteed to be in the binary tree
 *
 * Examples
 *
 *         5
 *
 *       /   \
 *
 *      9     12
 *
 *    /  \      \
 *
 *   2    3      14
 *
 * The lowest common ancestor of 2 and 14 is 5
 *
 * The lowest common ancestor of 2 and 9 is 9
 *
 * The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 *
 * Medium
 * Binary Tree
 * Linked List
 */



public class LowestCommonAncestorII {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        TreeNodeP n1 = one;
        TreeNodeP n2 = two;
        Set<TreeNodeP> set = new HashSet<>();
        while(n1 != null) {
            set.add(n1);
            n1 = n1.parent;
        }
        while(n2 != null) {
            if (set.contains(n2)) {
                return n2;
            }
            n2 = n2.parent;
        }
        return null;
    }
}
