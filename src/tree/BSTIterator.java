package tree;

import java.util.ArrayDeque;
import java.util.Deque;

//BSTIterator iterator = new BSTIterator(root);
//        iterator.next();    // return 3
//        iterator.next();    // return 7
//        iterator.hasNext(); // return true
//        iterator.next();    // return 9
//        iterator.hasNext(); // return true
//        iterator.next();    // return 15
//        iterator.hasNext(); // return true
//        iterator.next();    // return 20
//        iterator.hasNext(); // return false

//Note:
//
//        next() and hasNext() should run in average O(1) time and uses O(h) memory,
// where h is the height of the tree.
//        You may assume that next() call will always be valid,
// that is, there will be at least a next smallest number in the BST when next() is called.

public class BSTIterator {
    Deque<TreeNode> stack;

    private void firstNode(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        firstNode(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.poll();
        firstNode(cur.right);
        return cur.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
