package array;
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].

import java.util.*;

class Two_Sum {
    //O(n ^ 2)
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                while(i < j && nums[i] == nums[j]) {

                }
                return new int[] {map.get(nums[i]), map.get(nums[j])};
            } else if (sum < target) {
                i++;
            } else {
                // sum > target
                j--;
            }
        }
        return new int[]{};
    }
}