package dynamic_programming;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2];        // 2 3 -2  4
        dp[0][0] = nums[0]; // for min     // 2 3 -12 -48
        dp[0][1] = nums[0]; // for max     // 2 6 -2  4
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
            dp[i][0] = Math.min(dp[i][0], nums[i]);
            dp[i][1] = Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
            dp[i][1] = Math.max(dp[i][1], nums[i]);
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }
}
