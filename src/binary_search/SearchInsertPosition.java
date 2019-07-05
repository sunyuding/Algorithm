package binary_search;
//Given a sorted array and a target value,
// return the index if the target is found.
// If not,
// return the index where it would be if it were inserted in order.
//
//        You may assume no duplicates in the array.
//
//        Example 1:
//
//        Input: [1,3,5,6], 5
//        Output: 2
//        Example 2:
//
//        Input: [1,3,5,6], 2
//        Output: 1
//        Example 3:
//
//        Input: [1,3,5,6], 7
//        Output: 4
//        Example 4:
//
//        Input: [1,3,5,6], 0
//        Output: 0
public class SearchInsertPosition {
    /**
     * V0
     */
//    public int searchInsert(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return 0;
//        int left = 0;
//        int right = nums.length - 1;
//        while(left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                // nums[mid] > target
//                right = mid - 1;
//            }
//        }
//        if (left >= nums.length) return left;
//        if (nums[left] < target) {
//            return left + 1;
//        } else {
////            nums[left] >  target
//            return left;
//        }
//    }

    /**
     * V2
     * Find the smallest element >= target
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // nums[mid] >= target
                right = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }

    /**
     * V2
     * Find the smallest element >= target
     * @param nums
     * @param target
     * @return
     */
//    public int searchInsert(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return 0;
//        int left = 0;
//        int right = nums.length - 1;
//        while(left < right - 1) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                // nums[mid] >= target
//                right = mid;
//            }
//        }
//        if (nums[left] >= target) {
//            return left;
//        } else if (nums[right] >= target) {
//            return right;
//        } else {
//            return right + 1;
//        }
//    }
}
