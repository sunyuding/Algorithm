package dynamic_programming;
//Given a m x n grid filled with non-negative numbers,
// find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//        Note: You can only move either down or right at any point in time.
//
//        Example:
//
//        Input:
//        [
//        [1,3,1],
//        [1,5,1],
//        [4,2,1]
//        ]
//        Output: 7
//        Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//public class MinimumPathSum {
//    /**
//     * Time: O(m * n)
//     * Space: O(m * n)
//     * @param grid
//     * @return
//     */
//    public int minPathSum(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[grid.length][grid[0].length];
//        dp[0][0] = grid[0][0];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0) {
//                    if (j > 0) {
//                        dp[i][j] = dp[i][j - 1] + grid[i][j];
//                    }
//                } else if (j == 0) {
//                    if (i > 0) {
//                        dp[i][j] = dp[i - 1][j] + grid[i][j];
//                    }
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//                }
//            }
//        }
//        return dp[m - 1][n - 1];
//    }
//}

public class MinimumPathSum {
    /**
     * Time: O(m * n)
     * Space: O(n)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j > 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    }
                } else if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
