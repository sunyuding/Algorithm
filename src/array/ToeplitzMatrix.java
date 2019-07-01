package array;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
//1. What if the matrix is stored on disk,
// and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
//Compare half of 1 row with half of the next/previous row.
//2. What if the matrix is so large that you can only load up a partial row into the memory at once?
//Hash 2 rows (so only 1 element needs to be loaded at a time) and compare the results,
// excluding the appropriate beginning or ending element.