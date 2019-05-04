package tree;

import java.util.*;

// Given a non-empty binary search tree and a target value,
// find k values in the BST that are closest to the target.
//
//        Note:
//
//        Given target value is a floating point.
//        You may assume k is always valid,
//        that is: k ≤ total nodes.
//        You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
//        Example:
//
//        Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
//
//            4
//           / \
//          2   5
//         / \
//        1   3
//
//        Output: [4,3]
//        Follow up:
//        Assume that the BST is balanced,
//        could you solve it in less than O(n) runtime (where n = total nodes)?
public class ClosestBinarySearchTreeValueII {
    /**
     * Time O(n)
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        inorder(root, deque);
        while(deque.size() > k) {
            int first = deque.peekFirst();
            int last = deque.peekLast();
            if (Math.abs(first - target) < Math.abs(last - target)) {
                // first is closer
                deque.pollLast();
            } else {
                deque.pollFirst();
            }
        }
        //deque.size() == k
        return new LinkedList<>(deque);
    }

    private void inorder(TreeNode root, Deque<Integer> deque) {
        if (root == null) return;
        inorder(root.left, deque);
        deque.offer(root.val);
        inorder(root.right, deque);
    }
}
