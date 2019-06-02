package breadth_first_search;
//Given a positive integer n,
// find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
//        Example 1:
//
//        Input: n = 12
//        Output: 3
//        Explanation: 12 = 4 + 4 + 4.
//        Example 2:
//
//        Input: n = 13
//        Output: 2
//        Explanation: 13 = 4 + 9.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Runtime: 164 ms
 * Memory Usage: 37.3 MB
 * Time: O(|V| + |E|)
 * Space: O(|V|)
 */
public class PerfectSquares {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(n);
        set.add(n);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == 0) return count;
                for (int j = 1; j * j <= cur; j++) {
                    if (set.add(cur - j * j)) { // avoid duplicate calculation
                        q.offer(cur - j * j);
                    }
                }
            }
            count++;
        }
        return count;
    }
}
