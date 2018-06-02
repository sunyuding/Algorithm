import java.lang.reflect.Array;
import java.util.*;

/**
 * Given an array nums of n integers and an integer target,
 * are there elements a, b, c, and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * 4 sum => 3 sum
 * b + c + d = target - a
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0) return res;
            Arrays.sort(nums);
            helper(nums, target, res, new ArrayList<Integer>(), 0, 0);
            return res;
        }
        private void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> temp, int index, int currSum) {
            if (temp.size() == 4 && currSum == target) {
                res.add(new ArrayList<>(temp));
                return;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (set.add(nums[i])) {
                    // Choose the current element
                    currSum += nums[i];
                    temp.add(nums[i]);
                    helper(nums, target, res, temp, i + 1, currSum);
                    temp.remove(temp.size() - 1);
                    currSum -= nums[i];

                    // Not choose the current element
                    helper(nums, target, res, temp, i + 1, currSum);
                }
            }
        }


        public static void main(String[] args) {
        FourSum ins = new FourSum();
        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        int target = 0;
        ins.fourSum(nums, target);
    }
}
