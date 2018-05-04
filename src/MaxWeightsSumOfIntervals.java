import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of intervals,
 * each interval has (start, end, weight).
 * find a subset of the intervals,
 * such that there is no overlap,
 * and the sum of weight is maximized.
 *
 * Return the max weights sum.
 *
 * Assumptions:
 *
 * The given array of intervals is not null and has length of > 0
 * Medium
 * Array
 */

class IntervalW {
    public int start;
    public int end;
    public int weight;

    public IntervalW(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class MaxWeightsSumOfIntervals {
    public int maxWeightSum(IntervalW[] intervals) {
        // The given array of intervals is not null and has length of > 0
        Arrays.sort(intervals, new Comparator<IntervalW>() {
            @Override
            public int compare(IntervalW o1, IntervalW o2) {
                return o1.start - o2.start;
            }
        });
        // state definition
        // dp[i] represent the max weight sum from 0-th element to i-th element, including i-th element in the subset
        int[] dp = new int[intervals.length];
        // base case
        // dp[0] = intervals[0]
        dp[0] = intervals[0].weight;

        // induction rule
        // dp[i] = max(dp[j] + array[i - 1]), 0 <= j < i, array[i - 1].start > array[j]
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            dp[i] = intervals[i].weight;
            for (int j = 0; j < i; j++) {
                if (intervals[j].end < intervals[i].start) {
                    // no overlap
                    dp[i] = Math.max(dp[j] + intervals[i].weight, dp[i]);
                }
            }
            // dp[i] is the max one right now
            result = Math.max(result, dp[i]);
        }
        // result
        // dp[intervals.length]
        return result;
    }

    public static void main(String[] args) {

    }
}
