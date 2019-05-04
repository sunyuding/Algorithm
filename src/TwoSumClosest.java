/**
 * Find the pair of elements in a given array that sum to a value that is closest to the given target number.
 * Return the values of the two numbers.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 2
 * Examples
 *
 * A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
 *
 *
 *
 * Medium
 * array
 * Sort
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TwoSumClosest {
    public List<Integer> closest(int[] array, int target) {
        List<Integer> result = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return result;
        }
        int left = 0, right = array.length - 1;
        int tmp1 = left, tmp2 = right;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(array);
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                result.add(array[left], array[right]);
                return result;
            } else if (sum > target) {
                if (sum - target <= diff) {
                    diff = sum - target;
                    tmp1 = left;
                    tmp2 = right;
                    right--;
                } else {
                    break;
                }
            } else {
                // sum < target
                if (target - sum <= diff) {
                    diff = target - sum;
                    tmp1 = left;
                    tmp2 = right;
                    left++;
                } else {
                    break;
                }
            }
        }
        result.add(array[tmp1], array[tmp2]);
        return result;
    }

    public static void main(String[] args) {
        TwoSumClosest tsc = new TwoSumClosest();
        int[] array = new int[]{3, 4, 0, -1, 2, 0, 5};
        int target = 10;
        tsc.closest(array, target);
    }
}
