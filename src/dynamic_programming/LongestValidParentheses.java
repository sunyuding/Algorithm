package dynamic_programming;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    /**
     * Time: O(n)
     * Space: O(n)
     * Runtime: 1 ms
     * Memory Usage: 36 MB
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        if (s == null || s.length() == 0) {
            return max;
        }
        //dp[i] represents the length of longest parentheses substring ending at i-th element
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // case1:
                // *******()
                //         i
                // s.charAt(i) == ')' && s.charAt(i - 1) == '('
                // dp[i] = dp[i - 2] + 2
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                }
                // case2:
                // *****(*****))
                //             i
                // s.charAt(i) == ')' && s.charAt(i - dp[i - 1] - 1) == '('
                // dp[i] = dp[i - dp[i - 1] - 2] + 1 + dp[i - 1] + 1
                else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i - dp[i - 1] - 2] + 1 + dp[i - 1] + 1;
                    } else {
                        dp[i] = 1 + dp[i - 1] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
