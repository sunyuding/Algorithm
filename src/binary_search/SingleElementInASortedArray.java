package binary_search;

//Given a sorted array consisting of only integers where every element appears exactly twice except for one element which appears exactly once.
// Find this single element that appears only once.
public class SingleElementInASortedArray {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            // if i is even
            // left side
            // nums[i] == nums[i + 1]

            // right side
            // if i is odd
            // nums[i] == nums[i + 1]
            int l = 0;
            int r = nums.length - 1;
            while(l < r) {
                int mid = l + (r - l) / 2;
//                if ((mid < 1 || nums[mid - 1] != nums[mid]) && (mid + 1 > nums.length - 1 || nums[mid] != nums[mid + 1])) {
//                    return nums[mid];
//                } else if (mid < 1 || nums[mid - 1] == nums[mid]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }

                if (mid % 2 == 0) {
                    mid++;
                }
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else if (nums[mid] == nums[mid + 1]) {
                    r = mid - 1;
                }
            }
            return nums[l];
        }
    }
}
