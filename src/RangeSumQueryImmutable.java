/**
 * Given an integer array nums,
 * find the sum of the elements between indices i and j (i ≤ j),
 * inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
    int[] prefixSum;

    /**
     * Time O(n) to create an extra O(n) array to store the prefix sum.
     * @param nums
     */
    public RangeSumQueryImmutable(int[] nums) {
        if (nums != null) {
            this.prefixSum = new int[nums.length];
            if (this.prefixSum.length != 0) {
                this.prefixSum[0] = nums[0];
            }
            for (int i = 1; i < nums.length; i++) {
                this.prefixSum[i] = this.prefixSum[i - 1] + nums[i];
            }
        }
    }

    /**
     * Time: O(1)
     * Space: O(n) an extra prefixSum array
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        if (i == 0) {
            return prefixSum[j];
        }
        return prefixSum[j] - prefixSum[i - 1];
    }
}
