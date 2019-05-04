package tree;

//156. Binary tree Upside Down
//Given a binary tree where all the right nodes
// are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
// flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
// Return the new root.
// the leftmost node would be the root node
//
//        Example:
//
//        Input: [1,2,3,4,5]
//
//            1
//           / \
//          2   3
//         / \
//        4   5
//
//            1
//           / \
//          4   3
//         / \
//        5   2
//
//
//
//          4
//         / \
//        5   2
//       / \
//       3  1
//
//        Output: return the root of the binary tree [4,5,2,#,#,3,1]
//
//           4
//          / \
//         5   2
//             / \
//            3   1
//        Clarification:
//
//        Confused what [4,5,2,#,#,3,1] means?
//        Read more below on how binary tree is serialized on OJ.
//
//        The serialization of a binary tree follows a level order traversal,
//        where '#' signifies a path terminator where no node exists below.
//
//        Here's an example:
//
//          1
//         / \
//        2   3
//       /
//      4
//       \
//        5
//        The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;

        TreeNode left  = root.left;
        root.left = null;

        TreeNode right = root.right;
        root.right = null;

        TreeNode newRoot = upsideDownBinaryTree(left);
        TreeNode rightMost = newRoot;
        while(rightMost.right != null) {
            rightMost = rightMost.right;
        }
        //rightMost.right == null;

        rightMost.left = right;
        rightMost.right = root;
        return newRoot;
    }
}
