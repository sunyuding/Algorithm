package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
//
//        Note:
//
//        The solution set must not contain duplicate triplets.
//
//        Example:
//
//        Given array nums = [-1, 0, 1, 2, -1, -4],
//
//        A solution set is:
//        [
//        [-1, 0, 1],
//        [-1, -1, 2]
//        ]

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // left != left+1
                    left++;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    while(left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while(left < (right - 1) && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                }
            }
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
