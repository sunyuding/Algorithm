/**
 * Given a set of time intervals in any order,
 * return the total length of the area covered by those intervals.
 *
 * Assumptions:
 *
 * The given array of intervals is not null.
 * None of the intervals in the array is null.
 * Examples:
 *
 * {<1,3>, <2,4>, <5,7>, <6,8> }. The total length returned is 6(<1,4> is covered and <5,8> is covered).
 * Easy
 * array
 * Interval
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * class Interval {
 *   public int start;
 *   public int end;
 *   public Interval(int start, int end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */
public class MergeIntervals {
    class Interval {
        public int start;
        public int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int length(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        // Sort
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.size(), new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < intervals.size(); i++) {
            minHeap.offer(intervals.get(i));
        }
        List<Interval> list = new ArrayList<>();
        int result = 0;
        while (!minHeap.isEmpty()) {
            Interval smaller = minHeap.poll();
            if (!minHeap.isEmpty() && smaller.end > minHeap.peek().start) {
                // overlap
                Interval bigger = minHeap.poll();
                minHeap.offer(new Interval(smaller.start, Math.max(smaller.end, bigger.end)));
            } else {
                // no overlap
                result += smaller.end - smaller.start;
            }
        }
        return result;
    }
}
