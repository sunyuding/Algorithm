/**
 * Use the least number of comparisons to get the largest and 2nd largest number in the given integer array.
 * Return the largest number and 2nd largest number.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 2
 * Examples
 *
 * {2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
 *
 * Medium
 * array
 */
public class LargestAndSecondLargest {
    public int[] largestAndSecond(int[] array) {
        int[] result = new int[2];
        // at least 2
        if (array[0] > array[1]) {
            result[0] = array[0];
            result[1] = array[1];
        } else {
            result[0] = array[1];
            result[1] = array[0];
        }
        for (int i = 2; i < array.length; i++) {
            if (array[i] > result[0]) {
                result[1] = result[0];//update second
                result[0] = array[i];//update first
            } else if (array[i] > result[1]) {
                result[1] = array[i];
            }
        }
        return result;
    }
}
