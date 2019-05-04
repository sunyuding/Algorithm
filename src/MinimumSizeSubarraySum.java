import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.

 For example,
 given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 Medium
 array
 Two Pointers
 Binary tree
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                if (getSum(nums, i, i + len) >= s) {
                    return len;
                }
            }
        }
        return 0;
    }

    private int getSum(int[] nums, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            result += nums[i];
        }
        return result;
    }
}
