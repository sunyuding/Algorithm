package greedy;

import java.util.Arrays;

/**
 * Time: O(n)
 * Space: O(1)
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) { // O(n)
            freq[task - 'A'] += 1;
        }
        Arrays.sort(freq); // O(1)
        // use the most frequent element as pivot, get the number of intervals
        int interval = freq[25] - 1;
        // calculate the number of idles
        int idle = interval * n;
        // each element can only be inserted into one interval once
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {  // O(1)
            idle -= Math.min(freq[i], interval);
        }
        return idle > 0? idle + tasks.length : tasks.length;
    }
}
