import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a quadratic function of the form f(x) = ax2 + bx + c
 * to each element x in the array.
 *
 * The returned array must be in sorted order.
 *
 * Expected time complexity: O(n)
 *
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5
 *          l         r
 *
 * Result: [3, 9, 15, 33]
 *
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 *
 * Result: [-23, -5, 1, 7]
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length];
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            if (a < 0) {
                for (int i = 0; i < result.length; i++) {
                    if (f(nums[l], a, b, c) < f(nums[r], a, b, c)) {
                        result[i] = f(nums[l++], a, b, c);
                    } else {
                        result[i] = f(nums[r--], a, b, c);
                    }
                }
            } else {
                for (int i = result.length - 1; i >= 0; i--) {
                    if (f(nums[l], a, b, c) > f(nums[r], a, b, c)) {
                        result[i] = f(nums[l++], a, b, c);
                    } else {
                        result[i] = f(nums[r--], a, b, c);
                    }
                }
            }
        }
        return result;
    }

    private int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        SortTransformedArray ins = new SortTransformedArray();
        int[] nums = new int[] {-4, -2, 2, 4};
        ins.sortTransformedArray(nums, 1, 3, 5);
    }

}
