//Given an array of positive integers representing a stock’s price on each day.
// On each day you can only make one operation:
// either buy or sell one unit of stock and you can make at most 1 transaction.
// Determine the maximum profit you can make.
//
//        Assumptions
//
//        The given array is not null and is length of at least 2.
//        Examples
//
//        {2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
//
//        Easy
//        Array
public class BuyStock1 {
    public int maxProfit(int[] array) {
        // dp
        // state definitino
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    result = Math.max(array[i] - array[j], result);
                }
            }
        }
        return result;
    }
}
