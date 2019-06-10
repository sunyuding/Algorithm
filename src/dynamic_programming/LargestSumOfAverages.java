package dynamic_programming;
// We partition a row of numbers A into at most K adjacent (non-empty) groups,
// then our score is the sum of the average of each group.
// What is the largest score we can achieve?
//
//        Note that our partition must use every number in A,
// and that scores are not necessarily integers.
//
//        Example:
//        Input:
//        A = [9,1,2,3,9]
//        K = 3
//        Output: 20
//        Explanation:
//        The best choice is to partition A into [9], [1, 2, 3], [9].
// The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
//        We could have also partitioned A into [9, 1], [2], [3, 9], for example.
//        That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
//
//
//        Note:
//
//        1 <= A.length <= 100.
//        1 <= A[i] <= 10000.
//        1 <= K <= A.length.
//        Answers within 10^-6 of the correct answer will be accepted as correct.
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        // definition dp[i][j]
        // the largest sum of the average of each group
        // for sub array [0, i) of A into
        // j adjacent (non-empty) groups
        double[][] dp = new double[A.length][K + 1];

        // base case
        // dp[i][1] = (A[0] + ... + A[i]) / (i + 1)
        double[] s = new double[A.length + 1];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += A[i];
            s[i] = cur;
            dp[i][1] = cur / (i + 1);
        }

        // induction rule
        // traverse order
        // dp[i][j] = max(dp[k][j - 1] + (A[k + 1] + ... + A[i]) / (i - k)), j - 1 <= k <= i - 1
        for (int i = 0; i < A.length; i++) {
            for (int j = 2; j <= K; j++) {
                for (int k = j - 1; k <= i - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + (s[i] - s[k]) / (i - k));
                }
            }
        }
        // result
        // max of (dp[n - 1][0], dp[n - 1][1], ..., dp[n - 1][k])
        double largest = Integer.MIN_VALUE;
        for (int i = 0; i <= K; i++) {
            largest = Math.max(largest, dp[n - 1][i]);
        }
        return largest;
    }
}
