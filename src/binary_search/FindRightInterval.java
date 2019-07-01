package binary_search;

import java.util.TreeMap;
//Given a set of intervals,
// for each of the interval i,
// check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i,
// which can be called that j is on the "right" of i.

/**
 * Time: O(nlogn)
 * Space: O(n)
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> indexMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            indexMap.put(intervals[i][0], i);
        }

        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            Integer startPoint = indexMap.ceilingKey(intervals[i][1]);
            if (startPoint == null) {
                result[i] = -1;
            } else {
                result[i] = indexMap.get(startPoint);
            }
        }

        return result;
    }
}
