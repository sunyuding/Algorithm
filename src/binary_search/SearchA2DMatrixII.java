package binary_search;
//Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:
//
//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.
//        Example:
//
//        Consider the following matrix:
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],

//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        Given target = 5, return true.
//
//        Given target = 20, return false.

/**
 * Time: O(m + n)
 * Space: no extra space
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        // starting from right top corner, it is a BST
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
