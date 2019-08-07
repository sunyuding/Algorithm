package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> list = new ArrayList<>();
        int[] cur = null;
        for (int[] interval : intervals) {
            if (cur == null) {
                cur = interval;
                continue;
            }
            if (interval[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], interval[1]);
            } else {
                list.add(cur);
                cur = interval;
            }
        }
        if (cur != null) {
            list.add(cur);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] interval = list.get(i);
            res[i][0] = interval[0];
            res[i][1] = interval[1];
        }
        return res;
    }
}
