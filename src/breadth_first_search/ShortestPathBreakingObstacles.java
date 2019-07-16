package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBreakingObstacles {
    private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathBreakingObstacles(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                count++;
                int[] cur = q.poll();
                for (int[] dir : DIRS) {
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];
                    if (newRow >= 0
                            && newRow < maze.length
                            && newCol >= 0
                            && newCol < maze[0].length
                            && maze[newRow][newCol] == 0
                            && !visited[newRow][newCol]) {
                        if (newRow == destination[0] && newCol == destination[1]) {
                            return count;
                        }
                        q.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
        return 0;
    }
}
