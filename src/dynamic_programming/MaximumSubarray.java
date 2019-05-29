package dynamic_programming;

/**
 * Time: O(n)
 * Space: O(1)
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        int dp = nums[0];
        // int result = dp[0];
        int result = dp;
        for (int i = 1; i < nums.length; i++) {
            // if (dp[i - 1] > 0) {
            //     dp[i] = dp[i - 1] + nums[i];
            // } else {
            //     dp[i] = nums[i];
            // }
            // if (dp[i] > result) {
            //     result = dp[i];
            // }
            if (dp > 0) {
                dp += nums[i];
            } else {
                dp = nums[i];
            }
            if (dp > result) {
                result = dp;
            }
        }
        return result;
    }
}
