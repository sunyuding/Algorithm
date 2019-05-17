package reservoir_sampling;

import java.util.Random;

public class RandomPickIndex {
    int[] nums;
    Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param target
     * @return
     */
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
