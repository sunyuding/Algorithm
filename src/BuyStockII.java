//Given an array of positive integers representing a stock’s price on each day.
// On each day you can only make one operation:
// either buy or sell one unit of stock,
// you can make as many transactions you want,
// but at any time you can only hold at most one unit of stock.
// Determine the maximum profit you can make.
//
//        Assumptions
//
//        The give array is not null and is length of at least 2
//        Examples
//
//        {2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
//
//        Easy
//        array

public class BuyStockII {
    public int maxProfit(int[] array) {
        // state definition
        // dp[i] represents the max profit from 0-th element to i-th element, including i-th element
//        int[] dp = new int[array.length];
        int cur = 0;
        // base case
        // dp[1] = array[1] > array[0] ? array[1] - array[0] : 0
//        dp[1] = array[1] > array[0] ? array[1] - array[0] : 0;
        cur = array[1] > array[0] ? array[1] - array[0] : 0;
        // induction rule
        // if array[i] > array[i - 1], dp[i] = dp[i - 1] + array[i] - array[i - 1]
        // else, dp[i] = do[i - 1]
        for (int i = 2; i < array.length; i++) {
//            dp[i] = array[i] > array[i - 1]? dp[i - 1] + array[i] - array[i - 1] : dp[i - 1];
            cur = array[i] > array[i - 1]? cur + array[i] - array[i - 1] : cur;
        }

        // result
        // dp[array.length - 1]
//        return dp[array.length - 1];
        return cur;
    }
}
