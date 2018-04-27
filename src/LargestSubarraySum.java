public class LargestSubarraySum {

    public int largestSum(int[] array) {
        // Write your solution here.
        // state definition: dp[i] represents the largest sum of subarray from [o-th element to the i-th element] must including i-th element
        // base case: dp[0] = array[0];
        // induction rule:
        //                  case 1 dp[i - 1] > 0, dp[i] = array[i] + dp[i - 1]
        //                  case 2 otherwise, dp[i] = array[i]
        // result: max in dp[] array
        // optimize space to O(1)
//        int[] dp = new int[array.length];
//        dp[0] = array[0];
//        int max = dp[0];
        int dp = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp > 0) {
                dp = array[i] + dp;
            } else {
                dp = array[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }



}
