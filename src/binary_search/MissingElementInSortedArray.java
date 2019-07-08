package binary_search;
//Given a sorted array A of unique numbers,
// find the K-th missing number starting from the leftmost number of the array.
//
//        Example 1:
//
//        Input: A = [4,7,9,10], K = 1
//        Output: 5
//        Explanation:
//        The first missing number is 5.
//        Example 2:
//
//        Input: A = [4,7,9,10], K = 3
//        Output: 8
//        Explanation:
//        The missing numbers are [5,6,8,...], hence the third missing number is 8.
//        Example 3:
//
//        Input: A = [1,2,4], K = 3
//        Output: 6
//        Explanation:
//        The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
//
//
//        Note:
//
//        1 <= A.length <= 50000
//        1 <= A[i] <= 1e7
//        1 <= K <= 1e8
public class MissingElementInSortedArray {
//TODO
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 1;
        // search the smallest index of element with nums[i] = i + 2
        // return index + 1
        int left = 0;
        int right = nums.length - 1;
        int diff = nums[0];
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - mid - diff > k) {

            }
        }

    }
}
