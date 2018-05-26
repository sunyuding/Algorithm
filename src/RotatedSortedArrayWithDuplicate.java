//[3, 1, 3, 3, 3]
//[3, 3, 3, 1, 3]
public class RotatedSortedArrayWithDuplicate {
    public int getMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // right half is monotonically increasing.
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                // nums[mid] == nums[right]
                right--;
            }
        }
        return left;
    }
}
