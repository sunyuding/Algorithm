/**
 * Use the least number of comparisons to get the largest and smallest number in the given integer array.
 * Return the largest number and the smallest number.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 1
 * Examples
 *
 * {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
 *
 * Medium
 * array
 */
public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        int[] result = new int[2];
        result[0] = array[0];//max
        result[1] = array[0];//min
        for (int i = 1; i < array.length; i++) {
            if (array[i] > result[0]) {
                result[0] = array[i];//max
            }
            if (array[i] < result[1]) {
                result[1] = array[i];//min
            }
        }
        return result;
    }
}
