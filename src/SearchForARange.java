import javax.sound.midi.SysexMessage;

/**
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array,
 * return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        // binary search find the first target for result[0]
        // find the largest smaller then target
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] != target) {
            return new int[]{-1, -1};
        }
        result[0] = start;
        end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid + 1;
            } else {
                // nums[mid] > target
                end = mid;
            }
        }
        result[1] = start;
        return result;
    }

    public static void main(String[] args) {
        SearchForARange ins = new SearchForARange();
        ins.searchRange(new int[] {5,7,7,8,8,10}, 8);
    }
}
