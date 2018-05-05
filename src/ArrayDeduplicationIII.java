import java.util.Arrays;

/**
 * Given a sorted integer array,
 * remove duplicate elements.
 * For each group of elements with the same value do not keep any of them.
 * Do this in-place,
 * using the left side of the original array and and maintain the relative order of the elements of the array.
 * Return the array after deduplication.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {1, 2, 2, 3, 3, 3} → {1}
 *
 * Medium
 * Array
 */
public class ArrayDeduplicationIII {
    public int[] dedup(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int s = 0;
        int f = 0;
        while(f < array.length - 1) {
            if ((f == 0 || array[f] != array[f - 1]) && array[f] != array[f + 1]) {
                // unique one
                array[s] = array[f];
                s++;
            }
            f++;
        }
        //check last element
        if (array[f] != array[f - 1]) {
            array[s] = array[f];
            s++;
        }
        return Arrays.copyOfRange(array, 0, s);
    }
}
