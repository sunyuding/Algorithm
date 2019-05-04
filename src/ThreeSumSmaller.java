import java.util.Arrays;

/**
 * Given an array of n integers nums and a target,
 * find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2. Because there are two triplets which sums are less than 2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Easy
 * array
 * Two Pointers
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] num, int target) {
        Arrays.sort(num);
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            result += twoSumSmaller(num, i + 1,target - num[i]);
        }
        return result;
    }

    private int twoSumSmaller(int[] num, int index, int target) {
        int result = 0;
        if (index >= num.length) {
            return result;
        }
        for (int i = index; i < num.length; i++) {
            result += oneSmaller(num, i + 1, target - num[i]);
        }
        return result;
    }

    private int oneSmaller(int[] num, int index, int target) {
        int result = 0;
        if (index >= num.length) {
            return result;
        }
        for (int i = index; i < num.length; i++) {
            if (num[i] < target) {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumSmaller tss = new ThreeSumSmaller();
        int[] num = new int[] {-2, 0, 1, 3};
        int target = 2;
        tss.threeSumSmaller(num, target);
    }
}
