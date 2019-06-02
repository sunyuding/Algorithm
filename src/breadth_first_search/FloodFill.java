package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //O(v+e)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 2 2 2
        // 2 2 0
        // 2 0 1
        // BFS
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        if (image[sr][sc] == newColor) return image;

        int prevColor = image[sr][sc];

        Queue<Integer> q = new LinkedList<>();  // id: row * n + col
        q.offer(sr * n + sc);
        image[sr][sc] = newColor;
        while(!q.isEmpty()) {
            int cur = q.poll();
            int row = cur / n;
            int col = cur % n;

            // image[row][col] = newColor;
            for (int[] dir : DIRS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isValid(m, n, newRow, newCol) && image[newRow][newCol] == prevColor) {
                    q.offer(newRow * n + newCol);
                    image[newRow][newCol] = newColor;
                }
            }
        }
        return image;
    }

    private boolean isValid(int rows, int cols, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return false;
        }
        return true;
    }
}
