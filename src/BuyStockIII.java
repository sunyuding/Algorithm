import java.util.Arrays;

//Given an array of positive integers representing a stock’s price on each day.
// On each day you can only make one operation:
// either buy or sell one unit of stock,
// at any time you can only hold at most one unit of stock,
// and you can make at most 2 transactions in total.
// Determine the maximum profit you can make.
//
//        Assumptions
//
//        The give array is not null and is length of at least 2
//        Examples
//
//        {2, 3, 2, 1, 4, 5, 2, 11}, the maximum profit you can make is (5 - 1) + (11 - 2) = 13
//        Medium
//        array
public class BuyStockIII {
    public int maxProfit(int[] array) {
        int result = oneTransaction(array);
        for (int i = 2; i < array.length - 2; i++) {
            int left = oneTransaction(Arrays.copyOfRange(array, 0, i));
            int right = oneTransaction(Arrays.copyOfRange(array, i, array.length));
            result = Math.max(left + right, result);
        }
        return result;
    }

    private int oneTransaction(int[] array) {
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    result = Math.max(array[i] - array[j], result);
                }
            }
        }
        return result;
    }
}
