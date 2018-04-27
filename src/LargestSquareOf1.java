public class LargestSquareOf1 {
    // state definition
    // dp[i][j] represents the length of largest square with right-bottom point (i, j)

    // base
    // dp[0][0] = matrix[0][0]
    // dp[0][j] = matrix[0][j]
    // dp[i][0] = matrix[i][0]

    // fill in order
    // left -> right top -> bottom

    // induction rule
    // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])

    // result
    // max of dp

    // space optimization

    public static int largest(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }
        int max = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(dp[i - 1][j - 1], min);
                    dp[i][j] = min + 1;

                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1,1},{1,1,1,1},{0,1,1,1},{1,1,1,1}};
        largest(matrix);
    }
}
