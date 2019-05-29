package dynamic_programming;
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//        The robot can only move either down or right at any point in time.
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//        Now consider if some obstacles are added to the grids.
// How many unique paths would there be?
// Example 1:
//
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right

//public class UniquePathsII {
//    /**
//     * Time: O(m * n)
//     * Space: O(m * n)
//     * @param obstacleGrid
//     * @return
//     */
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
//            return 0;
//        }
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int[][] dp = new int[m][n];
//        if (obstacleGrid[0][0] == 0) {
//            dp[0][0] = 1;
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0) {
//                    // upper bound
//                    if (j > 0) {
//                        if (obstacleGrid[i][j] == 0) {
//                            dp[i][j] = dp[i][j - 1];
//                        }
//                    }
//                } else if (j == 0) {
//                    // left bound
//                    if (i > 0) {
//                       if (obstacleGrid[i][j] == 0) {
//                           dp[i][j] = dp[i - 1][j];
//                        }
//                    }
//                } else {
//                    if (obstacleGrid[i][j] == 0) {
//                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                    }
//                }
//            }
//        }
//        return dp[m - 1][n - 1];
//    }
//}

public class UniquePathsII {
    /**
     * Time: O(m * n)
     * Space: O(n)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if (obstacleGrid[0][0] == 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    // upper bound
                    if (j > 0) {
                        if (obstacleGrid[i][j] == 0) {
                            dp[j] = dp[j - 1];
                        }
                    } else if (j == 0) {
                        // left bound
                        if (i > 0) {
                            if (obstacleGrid[i][j] == 0) {
                                dp[j] = dp[j];
                            } else {
                                dp[j] = 0;
                            }
                        }
                    } else if (j > 0) {
                        if (obstacleGrid[i][j] == 0) {
                            dp[j] += dp[j - 1];
                        } else {
                            dp[j] = 0;
                        }
                    }
                }
            }

        }
        return dp[n - 1];
    }
}