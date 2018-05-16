import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a binary search tree,
 * write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 <=k <= BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often
 * and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * Medium
 * Binary Search Tree
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> maxHeap = new PriorityQueue<>(k, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o1.key < o2.key? 1 : -1;
            }
        });

        Queue<TreeNode> q  = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (count < k) {
                maxHeap.add(cur);
                count++;
            } else {
                if (cur.key < maxHeap.peek().key) {
                    maxHeap.poll();
                    maxHeap.add(cur);
                }
            }
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return maxHeap.peek().key;
    }
}
