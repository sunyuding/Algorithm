package dynamic_programming;

//Given an integer array nums,
// ind the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//        Example:
//
//        Input: [-2,1,-3,4,-1,2,1,-5,4],
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.
//        Follow up:
//
//        If you have figured out the O(n) solution,
// try coding another solution using the divide and conquer approach,
// which is more subtle.


//public class MaximumSubarray {
//    public int maxSubArray(int[] nums) {
//        int max = 0;
//        if (nums == null || nums.length == 0) {
//            return max;
//        }
//        //dp[i] is the max Sum of subarray ending at i-th element(i-th is included in the result)
//        int[] dp = new int[nums.length];
//        //base case
//        dp[0] = nums[0];
//        max = dp[0];
//        // induction rule
//        for (int i = 1; i < nums.length; i++) {
//            if (dp[i - 1] > 0) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }
//}


public class MaximumSubarray {
    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        //dp[i] is the max Sum of subarray ending at i-th element(i-th is included in the result)

        //base case
        int dp = nums[0];
        max = dp;
        // induction rule
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
