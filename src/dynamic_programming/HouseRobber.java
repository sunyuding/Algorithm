package dynamic_programming;

/**
 * Time: O(n)
 * Space: O(n)
 */
//public class HouseRobber {
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int[][] dp = new int[nums.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//            dp[i][1] = dp[i - 1][0] + nums[i];
//        }
//        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
//    }
//}

/**
 * Time: O(n)
 * Space: O(1)
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp0 = dp[0];
            int tmp1 = dp[1];
            dp[0] = Math.max(tmp0, tmp1);
            dp[1] = tmp0 + nums[i];
        }
        return Math.max(dp[0], dp[1]);
    }
}