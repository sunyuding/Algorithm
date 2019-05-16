package tree;

import java.util.List;

//Given a n-ary tree,
// find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//        For example, given a 3-ary tree:
//Note:
//
//        The depth of the tree is at most 1000.
//        The total number of nodes is at most 5000.


public class MaximumDepthOfNaryTree {
    /**
     * Time: O(n)
     * Space: O(height)
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node n : root.children) {
            max = Math.max(max, maxDepth(n));
        }
        return max + 1;
    }
}
