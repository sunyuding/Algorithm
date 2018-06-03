// int[] array, rotated sorted array, min position. (no duplicate elements).
// [1, 2, 3, 4, 5]  --> [4, 5, 1, 2, 3], return index 2
public class RotatedSortedArrayMinPosition {
    public int getMinPosition(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                //mid may be
                right = mid;
            } else {
                // mid is not
                left = mid + 1;
            }
        }
        return left;
    }
}
