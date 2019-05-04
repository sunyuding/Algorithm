package array;

import java.util.Arrays;

/**
 * Given a sorted integer array,
 * remove duplicate elements.
 * For each group of elements with the same value keep at most two of them.
 * Do this in-place,
 * using the left side of the original array and maintain the relative order of the elements of the array.
 * Return the array after deduplication.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
 *                 s
 *                   f
 * count 2
 * Medium
 * array
 */
public class ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        if (array.length < 3) {
            return array;
        }
        int s = 1, count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1] && count == 1) {
                    array[s] = array[i];
                    s++;
                    count++;
            } else if (array[i] != array[i - 1]) {
                array[s] = array[i];
                s++;
                count = 1;
            }
        }
        return Arrays.copyOfRange(array, 0, s);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,2,3,3,3};
        ArrayDeduplicationII ad = new ArrayDeduplicationII();
        ad.dedup(array);
    }
}
