/**
 * Given a sorted array and a target value,
 * return the index where it would be if it were inserted in order.
 *
 * Assumptions
 * If there are multiple elements with value same as target,
 * we should insert the target before the first existing element.
 *
 * Examples
 *  0 1 2 3
 * [1,3,5,6], 5 → 2
 *      l r
 * [1,3,5,6], 2 → 1
 *
 * [1,3,5,6], 7 → 4
 *
 * [1,3,3,3,5,6], 3 → 1
 *
 * [1,3,5,6], 0 → 0
 * Medium
 * Binary Search
 * array
 */
public class SearchInsertPosition {
    public int searchInsert(int[] input, int target) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // left == right
        if (input[left] >= target) {
            return left;
        }
        return left + 1;
    }
}
// 0 1 2 3  4
// 2,5,7,11,13,
//          lr
// 16
