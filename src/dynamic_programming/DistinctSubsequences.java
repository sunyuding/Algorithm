package dynamic_programming;
//Given a string S and a string T,
// count the number of distinct subsequences of S which equals T.
//
//        A subsequence of a string is a new string which is formed from the original string
// by deleting some (can be none) of the characters
// without disturbing the relative positions of the remaining characters.
// (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

///**
// * Runtime: 5 ms
// * Memory Usage: 35.2 MB
// * Time: O(m * n)
// * Space: O(m * n) -> O(n)
// */
//public class DistinctSubsequences {
//    public int numDistinct(String s, String t) {
//        if (s == null || t == null) return 0;
////        dp[i][j] stands for how many distinct subsequences in S[0..i-1] that is equal T[0..j-1]
//        int[][] dp = new int[s.length() + 1][t.length() + 1];
//
////        base case:
////        dp[0][0] = 1
////        dp[i][0] = 1
////        dp[0][j] = 0
//        dp[0][0] = 1;
//
//        for (int i = 1; i <= s.length(); i++) {
//            // if target is "",
//            dp[i][0] = 1;
//        }
//
//        for (int j = 1; j <= t.length(); j++) {
//            dp[0][j] = 0;
//        }
//
////        S[i-1] == T[j-1],  dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
////        S[i-1] != T[j-1],   dp[i][j] = dp[i-1][j]
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 1; j <= t.length(); j++) {
//                if (s.charAt(i - 1) == t.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//
//        return dp[s.length()][t.length()];
//    }
//}

/**
 * Time: O(m * n)
 * Space: O(m * n) -> O(n)
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
//        dp[i][j] stands for how many distinct subsequences in S[0..i-1] that is equal T[0..j-1]
        int[][] dp = new int[s.length() + 1][t.length() + 1];

//        base case:
//        dp[0][0] = 1
//        dp[i][0] = 1
//        dp[0][j] = 0
        dp[0][0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            // if target is "",
            dp[i][0] = 1;
        }

        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }

//        S[i-1] == T[j-1],  dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
//        S[i-1] != T[j-1],   dp[i][j] = dp[i-1][j]
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
