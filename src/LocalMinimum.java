/**
 * Given an unsorted integer matrix, return the position of any local minimum.
 */
public class LocalMinimum {
    public int localMinimum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        // run binary search on row
        int start = 0;
        int end = matrix.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // find the global min on row matrix[mid]
            int minIndex = 0;
            for (int i = 0; i < matrix[mid].length; i++) {
                if (matrix[mid][i] < matrix[mid][minIndex]) {
                    minIndex = i;
                }
            }
            // minIndex found and check whether it is the local min
            if (matrix[mid - 1][minIndex] >= matrix[mid][minIndex]
                    && matrix[mid + 1][minIndex] >= matrix[mid][minIndex]) {
                return matrix[mid][minIndex];
            } else if (matrix[mid - 1][minIndex] < matrix[mid][minIndex]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
