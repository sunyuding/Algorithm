package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: O(m * n)
 * Space: O(m * n)
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[] {i, 0});
            }
            if (board[i][board[0].length - 1] == 'O') {
                q.offer(new int[] {i, board[0].length - 1});
            }
        }
        for (int j = 0; j < board[0].length; j++) {

            if (board[0][j] == 'O') {
                q.offer(new int[] {0, j});
            }
            if (board[board.length - 1][j] == 'O') {
                q.offer(new int[] {board.length - 1, j});
            }
        }

        int[][] move = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // O(m * n)
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            board[cur[0]][cur[1]] = '#';
            for (int i = 0; i < move.length; i++) {
                int newRow = cur[0] + move[i][0];
                int newCol = cur[1] + move[i][1];
                if (isValid(board, newRow, newCol) && board[newRow][newCol] == 'O') {
                    q.offer(new int[] {newRow, newCol});
                }
            }
        }

        //O(m * n)
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return true;
    }

}
