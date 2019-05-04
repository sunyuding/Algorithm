package array;

import java.util.Arrays;

/**
 * Given a sorted integer array,
 * remove duplicate elements.
 * For each group of elements with the same value keep only one of them.
 * Do this in-place,
 * using the left side of the original array and maintain the relative order of the elements of the array.
 * Return the array after deduplication.
 *
 * Assumptions
 *
 * The array is not null
 * Examples
 *
 * {1, 2, 3, 3, 3, 3} → {1, 2, 3}
 *           s
 *                   f
 * Easy
 * array
 */
public class ArrayDeduplicationI {
    public int[] dedup(int[] array) {
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[i - 1]) {
                array[s] = array[i];
                s++;
            }
        }
        return Arrays.copyOfRange(array, 0, s);
    }
}
