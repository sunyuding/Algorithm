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
        // a + b + c + d = target
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            // get a
            // de-duplicate
            if (i == 0 || nums[i] != nums[i - 1]){
                // three sum for target - nums[i]
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        // 2 sum for target - sums[i] - sums[j]
                        int lo = j + 1;
                        int hi = nums.length - 1;
                        while(lo < hi) {
                            if (nums[lo] + nums[hi] == target - nums[i] - nums[j]) {
                                // find it
                                res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                                while(lo < hi && nums[lo] == nums[lo + 1]) {
                                    lo++;
                                }
                                while(lo < hi && nums[hi] == nums[hi - 1]) {
                                    hi--;
                                }
                                lo++;
                                hi--;
                            } else if (nums[lo] + nums[hi] < target - nums[i] - nums[j]) {
                                lo++;
                            } else {
                                hi--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum ins = new FourSum();
        int[] nums = new int[]{1,0,-1,0,-2,2};
        ins.fourSum(nums, 0);
    }
}
