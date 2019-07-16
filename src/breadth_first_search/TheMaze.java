package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

//There is a ball in a maze with empty spaces and walls.
// The ball can go through empty spaces by rolling up, down, left or right,
// but it won't stop rolling until hitting a wall. When the ball stops,
// it could choose the next direction.
//
//        Given the ball's start position,
// the destination and the maze,
// determine whether the ball could stop at the destination.
//
//        The maze is represented by a binary 2D array.
// 1 means the wall and 0 means the empty space.
// You may assume that the borders of the maze are all walls.
// The start and destination coordinates are represented by row and column indexes.
public class TheMaze {
    private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
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
                        return true;
                    }
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return false;
    }
}
