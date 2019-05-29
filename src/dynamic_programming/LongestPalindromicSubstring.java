package dynamic_programming;
//Given a string s,
// find the longest palindromic substring in s.
// You may assume that the maximum length of s is 1000.
//
//        Example 1:
//
//        Input: "babad"
//        Output: "bab"
//        Note: "aba" is also a valid answer.
//
//        Example 2:
//
//        Input: "cbbd"
//        Output: "bb"

/**
 * Time: O(n ^ 2)
 * Space: O(n ^ 2)
 */
//public class LongestPalindromicSubstring {
//    public String longestPalindrome(String s) {
//        String res = "";
//        if (s == null || s.length() == 0) return res;
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//
//        for (int i = n - 1; i >= 0; i--) {
//            // for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//
//                if (dp[i][j] && (j - i + 1 > res.length())) {
//                    res = s.substring(i, j + 1);
//                }
//            }
//        }
//
//        return res;
//    }
//
//    public static void main(String[] args) {
//        LongestPalindromicSubstring ins = new LongestPalindromicSubstring();
//        ins.longestPalindrome("AAAA");
//    }
//}

/**
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";

        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j - 1) && (j - i < 4 || dp[i + 1][j - 1]);

                if (dp[i][j] && (j - i > res.length())) {
                    res = s.substring(i, j);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring ins = new LongestPalindromicSubstring();
        ins.longestPalindrome("AAAA");
    }
}
