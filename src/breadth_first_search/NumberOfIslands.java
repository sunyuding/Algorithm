package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime: 10 ms
 * Memory Usage: 40.4 MB
 * Time: O(m * n)
 * Space: O(min(m, n))
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;

        int count = 0;
        for(int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int[][] move = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                        for (int k = 0;  k < 4; k++) {
                            int newRow = cur[0] + move[k][0];
                            int newCol = cur[1] + move[k][1];
                            if (isValid(grid, newRow, newCol) && grid[newRow][newCol] == '1') {
                                q.offer(new int[] {newRow, newCol});
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(char[][] grid, int newRow, int newCol) {
        if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
            return false;
        }
        return true;
    }
}