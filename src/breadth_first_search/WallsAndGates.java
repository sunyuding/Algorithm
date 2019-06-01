package breadth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//You are given a m x n 2D grid initialized with these three possible values.
//
//        -1 - A wall or an obstacle.
//        0 - A gate.
//        INF - Infinity means an empty room.
// We use the value 2^31 - 1 = 2147483647 to represent INF
// as you may assume that the distance to a gate is less than 2147483647.
//
//        Fill each empty room with the distance to its nearest gate.
// If it is impossible to reach a gate,
// it should be filled with INF.
//
//        Example:
//
//        Given the 2D grid:
//
//        INF  -1  0  INF
//        INF INF INF  -1
//        INF  -1 INF  -1
//        0  -1 INF INF
//        After running your function, the 2D grid should be:
//
//        3  -1   0   1
//        2   2   1  -1
//        1  -1   2  -1
//        0  -1   3   4

/**
 * Runtime: 17 ms
 * Memory Usage: 46.7 MB
 * Time: O(|V| + |E|) = O(m * n)
 * Space: O(|V|) = O(m * n)
 */
public class WallsAndGates {
    private static final int[][] DIR = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    visited.add(i * n + j);
                }
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < DIR.length; j++) {
                    int newRow = cur[0] + DIR[j][0];
                    int newCol = cur[1] + DIR[j][1];
                    if (isValid(rooms, m, n, newRow, newCol) && !visited.contains(newRow * n + newCol)) {
                        rooms[newRow][newCol] = Math.min(rooms[newRow][newCol], count);
                        visited.add(newRow * n + newCol);
                        q.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
    }

    private boolean isValid(int[][] rooms, int rows, int cols, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return false;
        }
        if (rooms[row][col] < 0) {
            return false;
        }
        return true;
    }
}
