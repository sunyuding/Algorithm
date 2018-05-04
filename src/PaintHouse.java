/**
 * Description
 * There are a row of n houses,
 * each house can be painted with one of the three colors:
 * red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example,
 * costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green,
 * and so on...
 * Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Medium
 * Dynamic Programming
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length != 3) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        // dp
        // state definition
        // dp[i][j] represents from 0-th elements to i-th elements, the minimum cost
        // the color of i-th element is j
        int[][] dp = new int[costs.length][3];
        // base case
        // dp[0][j] = costs[0][j]
        // at least one row
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }
        // induction rule
        // dp[i][j] = cost[i][j] + min(dp[i - 1][not j], dp[i - 1][not j]), cannot have the same color
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = costs[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }
        // result
        // min(dp[costs.length - 1][j])
        for (int j = 0; j < 3; j++) {
            result = Math.min(result, dp[costs.length - 1][j]);
        }
        return result;
    }

    public static void main(String[] args) {
        PaintHouse ph = new PaintHouse();
        int[][] costs = new int[][]{{}};
        ph.minCost(costs);
    }
}


