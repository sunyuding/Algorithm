package dynamic_programming;

/**
 * Given two integer arrays A and B,
 * return the maximum length of an subarray that appears in both arrays.

 Example 1:

 Input:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 Output: 3
 Explanation:
 The repeated subarray with maximum length is [3, 2, 1].


 Note:

 1 <= len(A), len(B) <= 1000
 0 <= A[i], B[i] < 100
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        //dp[i][j] : findLength(A.subarray[0, i], B.subarray[0, j])

        //A[0] = B[0], dp[0][0] = 1
        //A[0] != B[0], dp[0][0] = 0
        

        //A[i] = B[j], dp[i][j] = dp[i - 1][j - 1]
        //A[i] != B[j], dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])


        //dp[A.length - 1][B.length - 1]
        return 0;
    }
}
