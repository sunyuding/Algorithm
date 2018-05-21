/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find the largest element <= target
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return searchArray(matrix[mid], target);
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    private boolean searchArray(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        int start = 0;
        int end = array.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix instance = new SearchA2DMatrix();
        instance.searchMatrix(new int[][]{{1}, {3}, {5}}, 3);
    }
}
