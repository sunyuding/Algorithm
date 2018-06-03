public class RotatedSortedArraySearchTarget {
    public int getTarget(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                // potential min is on left side with mid
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // potential min is on right side without mid
                // left side is monotonically increasing
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                left = mid + 1;
            }
        }
        if (nums[left] == target) return left;
        return -1;
    }

}
