public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        // already check the whole word
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        for (int[] d : dir) {
            if (dfs(board, word, visited, i + d[0], j + d[1], index + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch ins = new WordSearch();
        System.out.println(ins.exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));

    }
}
