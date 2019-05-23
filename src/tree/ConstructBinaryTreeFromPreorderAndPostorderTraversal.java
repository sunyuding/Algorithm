package tree;

/**
 * Return any binary tree that matches the given preorder and postorder traversals.

 Values in the traversals pre and post are distinct positive integers.



 Example 1:

 Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 Output: [1,2,3,4,5,6,7]


 Note:

 1 <= pre.length == post.length <= 30
 pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 It is guaranteed an answer exists.
 * If there exists multiple answers, you can return any of them.
 */

/**
 * Runtime: 1 ms
 * Memory Usage: 39.7 MB
 * Time: O(nlogn)
 * Space: O(logn)
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length == 0 || post.length == 0) {
            return null;
        }
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode constructFromPrePost(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int postLeftRoot = postStart;
        while (postLeftRoot < postEnd) {
            if (post[postLeftRoot] == pre[preStart + 1]) { // left subtree root
                break;
            }
            postLeftRoot++;
        }
        // postStart - postLeftRoot -
        int leftSubLen = postLeftRoot - postStart;
        // i is the start index in pre for right subtree
        root.left = constructFromPrePost(pre, preStart + 1, preStart + 1 + leftSubLen, post, postStart, postLeftRoot);
        root.right = constructFromPrePost(pre, preStart + 1 + leftSubLen + 1, preEnd, post, postLeftRoot + 1, postEnd - 1);

        return root;
    }
}
