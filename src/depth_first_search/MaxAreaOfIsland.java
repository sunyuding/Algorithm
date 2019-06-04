package depth_first_search;
//Given a non-empty 2D array grid of 0's and 1's,
// an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
//
//        Find the maximum area of an island in the given 2D array.
// (If there is no island, the maximum area is 0.)
//
//        Example 1:
//
//       [[0,0,1,0,0,0,0,1,0,0,0,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,1,1,0,1,0,0,0,0,0,0,0,0],
//        [0,1,0,0,1,1,0,0,1,0,1,0,0],
//        [0,1,0,0,1,1,0,0,1,1,1,0,0],
//        [0,0,0,0,0,0,0,0,0,0,1,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//        Given the above grid, return 6.
// Note the answer is not 11,
// because the island must be connected 4-directionally.
//        Example 2:
//
//        [[0,0,0,0,0,0,0,0]]
//        Given the above grid, return 0.
//        Note: The length of each dimension in the given grid does not exceed 50.

/**
 * Runtime: 4 ms
 * Memory Usage: 43.6 MB
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class MaxAreaOfIsland {
    private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] sum = new int[] {0};
        int[] res = new int[] {0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    // a new island
                    visited[i][j] = true;
                    sum[0] = 1; // for a new island, reset the current sum to 1
//                    res[0] = Math.max(res[0], sum[0]);
                    dfs(grid, m, n, visited, i, j,sum, res);
                }
            }
        }
        return res[0];
    }

    private void dfs(int[][] grid, int m, int n, boolean[][] visited, int i, int j, int[] sum, int[] res) {
        res[0] = Math.max(res[0], sum[0]);
        for (int[] dir : DIRS) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(m, n, newI, newJ) && !visited[newI][newJ] && grid[newI][newJ] == 1) {
                visited[newI][newJ] = true;
                sum[0]++;
//                res[0] = Math.max(res[0], sum[0]);
                dfs(grid, m, n, visited, newI, newJ, sum, res);
            }
        }
    }

    private boolean isValid(int m, int n, int newI, int newJ) {
        if (newI < 0 || newJ < 0 || newI >= m || newJ >= n) {
            return false;
        }
        return true;
    }
}
