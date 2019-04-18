import java.util.Arrays;
import java.util.HashSet;

/*
* Given an array with n integers,
* you need to find if there are triplets (i, j, k) which satisfies following conditions:
* 0 < i,
* i + 1 < j,
* j + 1 < k < n - 1
* Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
* where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
* Example:
* Input: [1,2,1,2,1,2,1]
*           i   j   k
*        [1,3,4,6,7,9,10]
*
* Output: True
* Explanation:
* i = 1, j = 3, k = 5.
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Note:
1 <= n <= 2000.
Elements in the given array will be in range [-1,000,000, 1,000,000].
* */
public class SplitArrayWithEqualSum {
    // definition: dp[i][j] represents subarray[0, i) could be split by j indexes
    // induction rule: k < i
    //              dp[k][j - 1] == sum of subarray[k + 1, i)
    //              then, dp[i][j] = sum of subarray[k + 1, i)
    // base case: dp[k][k] = 0
    //    0      1    2    3
    // 0  0   -1   -1   -1
    // 1  sum
    // 2  sum
    // 3  sum
    // 4  sum
    // 5  sum
    // 6  sum
    // return dp[nums.length][3]
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) return false;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int j = 3; j < nums.length - 3; j++) {
            HashSet <Integer> set = new HashSet< >();
            for (int i = 1; i < j - 1; i++) {
                if (sums[i - 1] == sums[j - 1] - sums[i]) {
                    set.add(sums[i - 1]);
                }
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sums[nums.length - 1] - sums[k] == sums[k - 1] - sums[j] && set.contains(sums[k - 1] - sums[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SplitArrayWithEqualSum ins = new SplitArrayWithEqualSum();
        ins.splitArray(new int[] {3, 3, 3, 1, -2, 2, 1, 2, 3, 2, -2, 1, 1, 3, 2, 3, -3, 0, 3, 2, 0, 3, 2});
    }
}
