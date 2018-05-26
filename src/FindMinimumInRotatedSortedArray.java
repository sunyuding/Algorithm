/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // binary search
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                // right side including mid is monotonically increasing
                end = mid;
            } else {
                // right side is not
                start = mid + 1;
            }
        }
        // start == end
        return nums[start];
    }
}
