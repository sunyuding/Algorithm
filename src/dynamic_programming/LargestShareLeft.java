package dynamic_programming;

/**
 * 1 5 7 2, k = 2
 * Time: O(nums.length * k)
 * Space: O(...)
 */
public class LargestShareLeft {
    public int largestShareLeft(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = prefixSum[i];
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j + 1; i < n; i++) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 2; j <= k && j <= i + 1; j++) {
                for (int m = j - 1; m < i; j++) {
                    dp[i][j] = Math.max(dp[i][j], Math.min(dp[m][j - 1], prefixSum[i] - prefixSum[m]));
                }
            }
        }
        return dp[n - 1][k];
    }
}
