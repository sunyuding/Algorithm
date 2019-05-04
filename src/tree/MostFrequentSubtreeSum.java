package tree;
//508. Most Frequent Subtree Sum
//Given the root of a tree,
// you are asked to find the most frequent subtree sum.
// The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
// So what is the most frequent subtree sum value?
// If there is a tie, return all the values with the highest frequency in any order.
//
//        Examples 1
//        Input:
//
//          5
//         /  \
//        2   -3

//           5(4)
//         /      \
//        2(2)   -3(-3)
//        return [2, -3, 4], since all the values happen only once,
//        return all of them in any order.
//        Examples 2
//        Input:
//
//           5
//         /  \
//        2   -5

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//           5(2)
//         /     \
//        2(2)   -5(-5)
//        return [2], since 2 happens twice, however -5 only occur once.
//        Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
public class MostFrequentSubtreeSum {
    int max;
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        map = new HashMap<>();
        max = Integer.MIN_VALUE;
        list = new ArrayList<>();
        postOrder(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int leftSum = postOrder(root.left);
        int rightSum = postOrder(root.right);
        int curSum = leftSum + root.val + rightSum;
        // update frequency
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        // update max
        if (map.get(curSum) > max) {
            max = map.get(curSum);
            list.clear();
            list.add(curSum);
        } else if (map.get(curSum) == max) {
            list.add(curSum);
        }
        return curSum;
    }
}
