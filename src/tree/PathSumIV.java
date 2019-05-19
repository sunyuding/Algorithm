package tree;
//If the depth of a tree is smaller than 5,
// then this tree can be represented by a list of three-digits integers.
//
//        For each integer in this list:
//        The hundreds digit represents the depth D of this node,
//        1 <= D <= 4.
//        The tens digit represents the position P of this node in the level it belongs to,
//        1 <= P <= 8.
//        The position is the same as that in a full binary tree.
//        The units digit represents the value V of this node,
//        0 <= V <= 9.
//        Given a list of ascending three-digits integers representing a binary with the depth smaller than 5.
//        You need to return the sum of all paths from the root towards the leaves.
//
//        Example 1:
//        Input: [113, 215, 221]
//        Output: 12
//        Explanation:
//        The tree that the list represents is:
//          3
//         / \
//        5   1
//
//        The path sum is (3 + 5) + (3 + 1) = 12.
//
//        Example 2:
//        Input: [113, 221]
//        Output: 4
//        Explanation:
//        The tree that the list represents is:
//        3
//         \
//          1
//
//        The path sum is (3 + 1) = 4.

import java.util.HashMap;
import java.util.Map;

public class PathSumIV {
    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map  = new HashMap<>();
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        int[] result = new int[] {0};
        backTracking(map, nums[0] / 10, nums[0] % 10, result);
        return result[0];
    }

    private void backTracking(Map<Integer, Integer> map, int node, int sum, int[] result) {
        int depth = node / 10;   // 11/10    3, 21  5, 22   1
        int pos = node % 10;     // 11%10
        int left = (depth + 1) * 10 + pos * 2 - 1;  // (1 + 1) * 10 + 1 * 2 - 1 = 21
        int right = left + 1;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            //leaf node;
            result[0] += sum;
            return;
        }
        if (map.containsKey(left)) {
            backTracking(map, left, sum + map.get(left), result);
        }
        if (map.containsKey(right)) {
            backTracking(map, right, sum + map.get(right), result);
        }
    }
}
