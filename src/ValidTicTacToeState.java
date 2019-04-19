public class ValidTicTacToeState {
    private char winner = ' ';
    private int numX = 0;
    private int numO = 0;

    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length != 3) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    numX++;
                } else if (board[i].charAt(j) == 'O') {
                    numO++;
                }
            }
        }
        if (numX != numO && numX != numO + 1) {
            return false;
        }
        if (isWin(board, 'X') && numX != numO + 1) return false;
        if (isWin(board, 'O') && numX != numO) return false;
        return true;
    }

    private boolean isWin(String[] B, char P) {
        // B: board, P: player
        for (int i = 0; i < 3; ++i) {
            if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                return true;
            if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                return true;
        }
        if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
            return true;
        if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
            return true;
        return false;
    }

    public static void main(String[] args) {
        ValidTicTacToeState ins = new ValidTicTacToeState();
        ins.validTicTacToe(new String[] {"XXX","XOO","OO "});
    }
}
