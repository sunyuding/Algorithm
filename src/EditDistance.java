public class EditDistance {
    // state definition
    // dp[i][j] represents the minimum number of editing to transform s1.substring(0, i) to s2.substring(0, j)

    // base case
    // dp[0][0] = 0, dp[i][0] = i, dp[0][j] = j

    // induction rule
    // do nothing: dp[i][j] = dp[i - 1][j - 1]
    // replace: dp[i][j] = dp[i - 1][j - 1] + 1
    // delete insert : dp[i][j] = dp[i - 1][j] + 1, dp[i][j] = dp[i][j - 1] + 1

    // fill in order
    // left to right, top to bottom

    // result
    // dp[one.length()][two.length()]

    // space optimization

    public static int editDistance(String one, String two) {
        int[][] dp = new int[one.length() + 1][two.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i <= one.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= two.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= one.length(); i++) {
            for (int j = 1; j <= two.length(); j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[one.length()][two.length()];
    }

    public static void main(String[] args) {
        editDistance("abcdef","bbccf");
    }
}
