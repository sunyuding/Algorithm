package Tree;
//Two elements of a binary search tree (BST) are swapped by mistake.
//
//        Recover the tree without changing its structure.
//
//        Example 1:
//
//        Input: [1,3,null,null,2]
//
//        1
//        /
//        3
//        \
//        2
//           3 2 1
//           1 2 3
//        Output: [3,1,null,null,2]
//
//        3
//        /
//        1
//        \
//        2
//        Example 2:
//
//        Input: [3,1,4,null,null,2]
//
//        3
//        / \
//        1   4
//        /
//        2
//        2, 1, 3, 4
//              prev
//                 cur
//       fir
//          sec
//        1  2  3  4
//        Output: [2,1,4,null,null,3]
//
//        2
//        / \
//        1   4
//        /
//        3
//        Follow up:
//
//        A solution using O(n) space is pretty straight forward.
//        Could you devise a constant space solution?

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNode(root, stack);
        TreeNode prev = null;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prev != null && prev.val > cur.val) {
                if (firstNode == null) {
                    firstNode = prev;
                    secondNode = cur;
                } else {
                    secondNode = cur;
                }
            }
            firstNode(cur.right, stack);
            prev = cur;
        }
        swap(firstNode, secondNode);
    }

    private void swap(TreeNode firstNode, TreeNode secondNode) {
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void firstNode(TreeNode root, Deque<TreeNode> stack) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
