/**
 * Given an array of integers representing a stock’s price on each day.
 * On each day you can only make one operation:
 * either buy or sell one unit of stock,
 * and at any time you can only hold at most one unit of stock,
 * and you can make at most K transactions in total.
 * Determine the maximum profit you can make.
 *
 * Assumptions
 *
 * The give array is not null and is length of at least 2
 * Examples
 *
 * {2, 3, 2, 1, 4, 5, 2, 11}, K = 3, the maximum profit you can make is (3 - 2) + (5 - 1) + (11 - 2)= 14
 *
 * Hard
 * Array
 */

import java.util.Arrays;
public class BuyStockIV {
    public int maxProfit(int[] array, int k) {
        if (k == 0) {
            return 0;
        }
        int result = oneTransaction(array);
        for (int i = 2; i < array.length - 2; i++) {
            int left = oneTransaction(Arrays.copyOfRange(array, 0, i));
            int right;
            if (left == 0) {
                // left no transaction
                right = maxProfit(Arrays.copyOfRange(array, i, array.length), k);
            } else {
                // left one transaction
                right = maxProfit(Arrays.copyOfRange(array, i, array.length), k - 1);
            }
            result = Math.max(left + right, result);
        }
        return result;
    }

    // at most oneTransaction
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

    public static void main(String[] args) {
        BuyStockIV bs4 = new BuyStockIV();
        bs4.maxProfit(new int[]{3,4,1,2,6,2,3,5,1,7,3,8},3);
    }
}

// 0  1  2  3  4  5  6  7
// 2, 3, 2, 1, 4, 5, 2, 11
//