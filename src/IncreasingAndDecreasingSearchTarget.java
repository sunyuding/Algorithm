public class IncreasingAndDecreasingSearchTarget {
    public int getTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int maxIndex = getMax(nums);
        increaseSearch(nums, maxIndex, target);
        decreaseSearch(nums, maxIndex, target);
        return left;
    }

    private int getMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
