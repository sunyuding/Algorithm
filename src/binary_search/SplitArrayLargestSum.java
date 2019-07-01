package binary_search;

/**
 * Given an array which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 If n is the length of array,
 assume the following constraints are satisfied:

 1 ≤ n ≤ 1000
 1 ≤ m ≤ min(50, n)
 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.
 */

/**
 * Time: O(nlog(sum of array))
 * Space: no extra space
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    count++;
                    sum = nums[i]; // reset sum;
                } else {
                    sum += nums[i];
                }
            }
            if (count <= m) {
                // this part would be the result
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                // count > m cannot be the result
                l = mid + 1;
            }
        }
        return (int)ans;
    }
}
