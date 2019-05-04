import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Determine if there exists three elements in a given array that sum to the given target number.
 * Return all the triple of values that sums to target.

 Assumptions

 The given array is not null and has length of at least 3
 No duplicate triples should be returned, order of the values in the tuple does not matter
 Examples

 A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]

 Medium
 array
 Sort
 */
public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i == 0 || array[i] != array[i - 1]) {
                int j = i + 1;
                int k = array.length - 1;
                while (j < k) {
                    // array[i] <= array[j] <= array[k]
                    int sum = array[i] + array[j] + array[k];
                    if (sum == target) {
                        List<Integer> cur = new ArrayList<>();
                        cur.add(array[i]);
                        cur.add(array[j]);
                        cur.add(array[k]);
                        result.add(cur);
                        j++;
                        k--;
                        while (j < k && array[j] == array[j - 1]) {
                            j++;
                        }
                        while (j < k && array[k] == array[k + 1]) {
                            k--;
                        }
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
