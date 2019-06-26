package backtracking;

import java.util.*;

//Given a collection of numbers that might contain duplicates,
// return all possible unique permutations.
//
//        Example:
//
//        Input: [1,1,2]
//        Output:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]
public class PermutationsII {
    /**
     * Time: worse case O(n!) factorial of n, if there is no duplicate element
     * Space: O(1) extra space
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, result);
        return result;
    }

    private void backtracking(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(arrayToList(nums));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                swap(nums, index, i);
                backtracking(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
        Map<Map<Character, Integer>, List<String>> patterns = new HashMap<>();
        for (List<String> list : patterns.values()) {
//            result.add(list);
        }

    }

    private List<Integer> arrayToList(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            result.add(i);
        }
        return result;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}