package depth_first_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Given a non-empty 2D array grid of 0's and 1's,
// an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
//
//        Count the number of distinct islands.
// An island is considered to be the same as another if and only if one island can be translated
// (and not rotated or reflected) to equal the other.
//
//        Example 1:
//        11000
//        11000
//        00011
//        00011
//        Given the above grid map, return 1.
//        Example 2:
//        11011
//        10000
//        00001
//        11011
//        Given the above grid map, return 3.
//
//        Notice that:
//        11
//        1
//        and
//        1
//        11
//        are considered different island shapes, because we do not consider reflection / rotation.
//        Note: The length of each dimension in the given grid does not exceed 50.

/**
 * Time Complexity: O(R * C),
 * where R is the number of rows in the given grid,
 * and C is the number of columns.
 * We visit every square once.
 *
 * Space complexity: O(R * C),
 * the space used by visited to keep track of visited squares, and shapes.
 */
public class NumberOfDistinctIslands {
    private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, int r, int c, int r0, int c0, Set<Integer> shape, boolean[][] visited) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !visited[r][c]) {
            visited[r][c] = true;
            shape.add((r - r0) * 2 * grid[0].length + (c - c0));
            for (int[] dir : DIRS) {
                dfs(grid, r + dir[0], c + dir[1], r0, c0, shape, visited);
            }
        }
    }

    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<Set<Integer>> shapes = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                Set<Integer> shape = new HashSet<>();
                dfs(grid, r, c, r, c, shape, visited);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }
}

//public class NumberOfDistinctIslands {
//    int[][] grid;
//    boolean[][] visited;
//    ArrayList<Integer> shape;
//
//    private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    public void dfs(int r, int c, int di) {
//        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
//                grid[r][c] == 1 && !visited[r][c]) {
//            visited[r][c] = true;
//            shape.add(di);
//            for (int i = 0; i < DIRS.length; i++) {
//                int newR = r + DIRS[i][0];
//                int newC = c + DIRS[i][1];
//                if (isValid(grid, newR, newC) && grid[newR][newC] == 1 && !visited[newR][newC]) {
//                    dfs(newR, newC, i + 1); // 1, 2, 3, 4
//                }
//            }
//            shape.add(0);
//        }
//    }
//
//    public int numDistinctIslands(int[][] grid) {
//        this.grid = grid;
//        visited = new boolean[grid.length][grid[0].length];
//        Set shapes = new HashSet<ArrayList<Integer>>();
//
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[0].length; c++) {
//                shape = new ArrayList<>();
//                dfs(r, c, 0);
//                if (!shape.isEmpty()) {
//                    shapes.add(shape);
//                }
//            }
//        }
//
//        return shapes.size();
//    }
//
//    private boolean isValid(int[][] grid, int r, int c) {
//        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
//    }
//}
