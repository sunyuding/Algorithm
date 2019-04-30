package Tree;
//Given an array of numbers,
// verify whether it is the correct preorder traversal sequence of a binary search tree.
//
//        You may assume each number in the sequence is unique.
//
//        Consider the following binary search tree:
//
//            5
//           / \
//          2   6
//         /  \
//        1   3
//        Example 1:
//
//        Input: [5,2,6,1,3]
//        Output: false
//        Example 2:
//
//        Input: [5,2,1,3,6]
//        Output: true
//        Follow up:
//        Could you do it using only constant space complexity?
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        // root
        // left subtree
        // right subtre
        if (preorder == null) return true;
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    private boolean verifyPreorder(int[] preorder, int start, int end) {
        if (start > end) return true; // this subtree is null
        int rootVal = preorder[start];
        int i = start + 1;
        while(i <= end) {
            if (preorder[i] >= rootVal) break;
            i++;
        }
        //preorder[i] >= rootval
        int rightStart = i;
        while(i <= end) {
            if (preorder[i] <= rootVal) return false;
            i++;
        }
        // i == end + 1
        return verifyPreorder(preorder, start + 1, rightStart - 1)
                && verifyPreorder(preorder, rightStart, end);
    }
}
