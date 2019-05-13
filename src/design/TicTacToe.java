package design;

import java.util.Arrays;

//Design a Tic-tac-toe game that is played between two players on a n x n grid.
//
//        You may assume the following rules:
//
//        A move is guaranteed to be valid and is placed on an empty block.
//        Once a winning condition is reached, no more moves is allowed.
//        A player who succeeds in placing n of their marks in a horizontal,
//        vertical,
//        or diagonal row wins the game.
//
//        Example:
//        Given n = 3,
//        assume that player 1 is "X" and player 2 is "O" in the board.
//
//        game.TicTacToe toe = new game.TicTacToe(3);
//
//        toe.move(0, 0, 1); -> Returns 0 (no one wins)
//        |X| | |
//        | | | |    // Player 1 makes a move at (0, 0).
//        | | | |
//
//        toe.move(0, 2, 2); -> Returns 0 (no one wins)
//        |X| |O|
//        | | | |    // Player 2 makes a move at (0, 2).
//        | | | |
//
//        toe.move(2, 2, 1); -> Returns 0 (no one wins)
//        |X| |O|
//        | | | |    // Player 1 makes a move at (2, 2).
//        | | |X|
//
//        toe.move(1, 1, 2); -> Returns 0 (no one wins)
//        |X| |O|
//        | |O| |    // Player 2 makes a move at (1, 1).
//        | | |X|
//
//        toe.move(2, 0, 1); -> Returns 0 (no one wins)
//        |X| |O|
//        | |O| |    // Player 1 makes a move at (2, 0).
//        |X| |X|
//
//        toe.move(1, 0, 2); -> Returns 0 (no one wins)
//        |X| |O|
//        |O|O| |    // Player 2 makes a move at (1, 0).
//        |X| |X|
//
//        toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
//        |X| |O|
//        |O|O| |    // Player 1 makes a move at (2, 1).
//        |X|X|X|
//        Follow up:
//        Could you do better than O(n2) per move() operation?
public class TicTacToe {
    int[][] board;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (board[row][col] != 0) {
            throw new IllegalArgumentException();
        }
        board[row][col] = player;
        if (hasWinner(row, col, player)) {
            return player == 1? 1 : 2;
        }
        return 0;
    }

    private boolean hasWinner(int row, int col, int player) {
        //O(n)
        boolean sameRow = true;
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) {
                sameRow = false;
                break;
            }
        }
        if (sameRow) return true;
        //O(n)
        boolean sameCol = true;
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player) {
                sameCol = false;
                break;
            }
        }
        if (sameCol) return true;
        //(n)

        if (row == col) {
            boolean sameLeftTopToRightBottom = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != player) {
                    sameLeftTopToRightBottom = false;
                    break;
                }
            }
            if (sameLeftTopToRightBottom) return true;
        }
        //O(n)
        if (row + col == n - 1) {
            boolean sameRightTopToLeftBottom = true;
            for (int i = 0; i < n; i++) {
                if (board[i][n - i - 1] != player) {
                    sameRightTopToLeftBottom = false;
                }
            }
            if (sameRightTopToLeftBottom) return true;
        }
        return false;
    }
}
/**
 * Your game.TicTacToe object will be instantiated and called as such:
 * game.TicTacToe obj = new game.TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */