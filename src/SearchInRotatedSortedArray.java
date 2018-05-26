/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search.
 * If found in the array return its index,
 * otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // find the pivot
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                // right side monotonously increasing
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        // start is the pivot
        if (start == 0) {
            start = 0;
            end = nums.length - 1;
            while(start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        } else if (nums[0] <= target && target <= nums[start - 1]) {
            // run binary search
            int start1 = 0;
            int end1 = start - 1;
            while(start1 <= end1) {
                int mid1 = start1 + (end1 - start1) / 2;
                if (nums[mid1] == target) {
                    return mid1;
                } else if (nums[mid1] < target){
                    start1 = mid1 + 1;
                } else {
                    end1 = mid1 - 1;
                }
            }
            return -1;
        } else if (nums[start] <= target && target <= nums[nums.length - 1]) {
            // run binary search
            int start2 = start;
            int end2 = nums.length - 1;
            while(start2 <= end2) {
                int mid2 = start2 + (end2 - start2) / 2;
                if (nums[mid2] == target) {
                    return mid2;
                } else if (nums[mid2] < target){
                    start2 = mid2 + 1;
                } else {
                    end2 = mid2 - 1;
                }
            }
            return -1;
        } else {
            return -1;
        }
    }
}
