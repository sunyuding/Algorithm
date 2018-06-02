import java.util.*;

/**
 *  Given a sorted array, two integers k and x,
 *  find the k closest elements to x in the array.
 *  The result should also be sorted in ascending order.
 *  If there is a tie, the smaller elements are always preferred.
 *
 *  Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 *
 *  Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null) {
            return new ArrayList<>();
        }
        // binary search to find the first element in the result
        // range
        int lo = 0, hi = arr.length - k;
        // check status
        // from left to right, find the first x - array[mid] <= array[mid + k] - x
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                // mid + k not included
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        // lo
        return arrayToList(Arrays.copyOfRange(arr, lo, lo + k));
    }

    private List<Integer> arrayToList(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int cur : arr) {
            result.add(cur);
        }
        return result;
    }
}
