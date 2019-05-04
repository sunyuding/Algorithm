/**
 * Merge two sorted arrays.
 *
 * Input: [1, 2, 3], [2, 4, 6]
 *
 * Output: [1,2, 2, 3, 4, 6]
 *
 *
 *
 * Easy
 * array
 */
public class MergeTwoSortedArray {
    public int[] merge(int[] A, int m, int[] B, int n) {
        int i = 0, j = 0;
        int[] result = new int[m + n];
        while(i < m && j < n) {
            if (A[i] < B[j]) {
                result[i + j] = A[i];
                i++;
            } else if (A[i] > B[j]) {
                result[i + j] = B[j];
                j++;
            } else {
                result[i + j] = A[i];
                i++;
                result[i + j] = B[j];
                j++;
            }
        }
        // now i == m || j == n
        while(i < m) {
            result[i + j] = A[i];
            i++;
        }
        while(j < n) {
            result[i + j] = B[j];
            j++;
        }
        return result;
    }
}
