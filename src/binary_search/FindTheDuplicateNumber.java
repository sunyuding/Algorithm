package binary_search;
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
// prove that at least one duplicate number must exist.
// Assume that there is only one duplicate number,
// find the duplicate one.
//
//        Example 1:
//
//        Input: [1,3,4,2,2]
//        Output: 2
//
//        Example 2:
//
//        Input: [3,1,3,4,2]
//        Output: 3
//
//        Note:
//
//        You must not modify the array (assume the array is read only).
//        You must use only constant,
// O(1) extra space.
//        Your runtime complexity should be less than O(n2).
//        There is only one duplicate number in the array,
// but it could be repeated more than once.
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        // find the smallest x, where f(x) > x
        // f(x) # of element <= x in the nums
        while(start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // looking for smallest element with f(x) > x
            if (count > mid) {
                end = mid;
            } else {
                // count <= mid
                start = mid + 1;
            }
        }
        return start;
    }
}
