package dynamic_programming;

public class InterleavingString {
    /**
     * Time: O(m * n)
     * Space: O(m * n) -> O(min of (m, n))
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null) {
            return s3 == null;
        } else if (s1 == null) {
            return s2.equals(s3);
        } else if (s2 == null) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // definition
        // dp[i][j] represents s1.substring(0, i), s2.substring(0, j), s3.substring(0, i + j) isInterleave
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // base case
        // dp[0][0] = true
        // dp[0][j] = true if s1.charAt(j - 1) == s3.charAt(j - 1)
        // dp[i][0] = true if s1.charAt(i - 1) == s3.charAt(j - 1)
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        // induction rule
        // dp[i][j] = true if
        // case1 dp[i][j - 1] == true and s2.charAt(j - 1) == s3.charAt(i + j - 1)
        // case2 dp[i - 1][j] == true and s1.charAt(i - 1) == s3.charAt(i + j - 1)
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = ((dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        // result
        // dp[s1.length()][s2.length()]
        return dp[s1.length()][s2.length()];
    }
}
