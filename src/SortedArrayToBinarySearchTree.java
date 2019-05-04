import java.util.Arrays;

/**
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * Example:
 *     Given ascending order array: [1, 3, 4, 5, 8, 11]
 *
 *     return Binary Search tree is
 *
 *               4
 *
 *           /        \
 *
 *         1          8
 *
 *            \      /     \
 *
 *            3     5    11
 *
 *
 *
 * Medium
 * Binary Search tree
 * Recursion
 */
public class SortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        int mid;
        if (num.length % 2 == 0) {
            mid = num.length / 2 - 1;
        } else {
            mid = num.length / 2;
        }
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1, num.length));
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBinarySearchTree instance = new SortedArrayToBinarySearchTree();
        instance.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}