package binary_search;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) { // mid + 1 guarantee it is not outofbound
                // mid may be left, but must not be right
                left = mid + 1;
            } else {
                // (mid + 1 < nums.length - 1 && nums[mid] > nums[mid + 1])
                right = mid;
            }
        }
        // left == right
        return left;
    }
}
