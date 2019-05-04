/**
 * Given an array of integers with possible duplicates,
 * randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. NumberOfIslandsII that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * NumberOfIslandsII solution = new NumberOfIslandsII(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 *
 */
public class RandomPickIndex {
    int[] nums;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        while(true) {
            int index = (int) (Math.random() * nums.length);//[0, nums.length)
            if (nums[index] == target) {
                return index;
            }
        }
    }
}
/**
 * Your NumberOfIslandsII object will be instantiated and called as such:
 * NumberOfIslandsII obj = new NumberOfIslandsII(nums);
 * int param_1 = obj.pick(target);
 */