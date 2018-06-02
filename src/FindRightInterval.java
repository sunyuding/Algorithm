import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of intervals,
 * for each of the interval i,
 * check if there exists an interval j
 * whose start point is bigger than or equal to the end point of the interval i,
 * which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index,
 * which means that the interval j has the minimum start point to build the "right" relationship for interval i.
 * If the interval j doesn't exist,
 * store -1 for the interval i.
 * Finally,
 * you need output the stored value of each interval as an array.
 *
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * Example 1:
 * Input: [ [1,2] ]
 *
 * Output: [-1]
 *
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 *
 * Output: [-1, 0, 1]
 *
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 *
 * Output: [-1, 2, -1]
 *
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 */
public class FindRightInterval {
    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    /**
     * 1. Brute Force
     * For each interval,
     * compare all the other intervals,
     * find the smaller start larger than target end
     * Time: O(n ^ 2)
     * Space: O(n)
     *
     * 2. Sort + Binary Search
     * Map the previous index: O(n) time and O(n) space
     * Sort the whole array: O(n)
     * run binary search to find the smallest larger than target O(logn)
     * Time: O(nlogn)
     * Space: O(n)
     *
     * @param intervals
     * @return
     */
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];

        // map
        Map<Interval, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        // sort
        // Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start < o2.start ? -1 : 1;
            }
        });

        // binary search for each one
        for (int i = 0; i < intervals.length; i++) {
            Interval cur = binarySearch(intervals[i].end, intervals);
            if (cur == null) {
                result[map.get(intervals[i])] = -1;
            } else {
                result[map.get(intervals[i])] = map.get(cur);
            }
        }
        return result;
    }

    /**
     * binary search the smallest element larger than target
     * @param target
     * @param intervals
     * @return
     */
    private Interval binarySearch(int target, Interval[] intervals) {
        int lo = 0;
        int hi = intervals.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (intervals[mid].start < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (intervals[lo].start < target) {
            return null;
        }
        return intervals[lo];
    }

    public static void main(String[] args) {
        FindRightInterval ins = new FindRightInterval();

        Interval[] intervals = new Interval[]{
                new Interval(1, 2)
        };
        ins.findRightInterval(intervals);
    }
}
