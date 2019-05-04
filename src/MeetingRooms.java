import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 *
 * Easy
 * Sort
 * array
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            minHeap.offer(intervals[i]);
        }

        for (int i = 0; i < intervals.length; i++) {
            int[] smaller = minHeap.poll();
            if (!minHeap.isEmpty() && smaller[1] > minHeap.peek()[0]) {
                // right bound of smaller one > left bound of bigger one
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();
        int[][] intervals = new int[][]{{15, 20}, {0, 30},{5, 10}};
        mr.canAttendMeetings(intervals);
    }
}
