package dynamic_programming;

public class DecodeWays {
    /**
     * Time: O(n)
     * Space: O(n) -> O(1)
     * @param s
     * @return
     */
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//        if (s.length() > 0) {
//            //dp[1] = 1;
//            dp[1] =  s.charAt(0) - '0' == 0? 0 : 1;
//            for (int i = 2; i <= s.length(); i++) {
//                int cur = s.charAt(i - 1) - '0';
//                int prev = s.charAt(i - 2) - '0';
//                int two = prev * 10 + cur;
//                if (cur >= 1 && cur <= 9) {
//                    dp[i] += dp[i - 1];
//                }
//                if (two >= 10 && two <= 26) {
//                    dp[i] += dp[i - 2];
//                }
//            }
//        }
//        return dp[s.length()];
//    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //int[] dp = new int[s.length() + 1];
        int cur = 0;
        int prev = 0;
//        dp[0] = 1;

        if (s.length() > 0) {
            //dp[1] = 1;
//            dp[1] =  s.charAt(0) - '0' == 0? 0 : 1;
            cur =  s.charAt(0) - '0' == 0? 0 : 1;
            for (int i = 2; i <= s.length(); i++) {
                int curNum = s.charAt(i - 1) - '0';
                int prevNum = s.charAt(i - 2) - '0';
                int two = prevNum * 10 + curNum;
                prev = cur;
                if (curNum >= 1 && curNum <= 9) {
//                    dp[i] += dp[i - 1];
                    cur += cur;
                }
                cur -= cur;
                if (prevNum >= 10 && prevNum <= 26) {
//                    dp[i] += dp[i - 2];
                    cur += prev;
                }
            }
        }
//        return dp[s.length()];
        return cur;
    }
}
