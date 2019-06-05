package breadth_first_search;

import java.util.*;

// We have a list of bus routes.
// Each routes[i] is a bus route that the i-th bus repeats forever.
// For example if routes[0] = [1, 5, 7],
// this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
//
//        We start at bus stop S (initially not on a bus),
// and we want to go to bus stop T.
// Travelling by buses only,
// what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.
//
//        Example:
//        Input:
//        routes = [[1, 2, 7], [3, 6, 7]]
//        S = 1
//        T = 6
//        Output: 2
//        Explanation:
//        The best strategy is take the first bus to the bus stop 7,
// then take the second bus to the bus stop 6.
//        Note:
//
//        1 <= routes.length <= 500.
//        1 <= routes[i].length <= 500.
//        0 <= routes[i][j] < 10 ^ 6.

/**
 * Runtime: 844 ms
 * Memory Usage: 61.7 MB
 * Time: O(V + E)
 * Space: O(V)
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        List<Set<Integer>> graph = new ArrayList<>();
        for (int[] route : routes) {
            Set<Integer> stopSet = new HashSet<>();
            for (int stop : route) {
                stopSet.add(stop);
            }
            graph.add(stopSet);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Set<Integer> stopSet : graph) {
            if (stopSet.contains(S)) {
                for (int stop : stopSet) {
                    if (!visited.contains(stop)) {
                        q.offer(stop);
                        visited.add(stop);
                    }
                }
            }
        }
        int count = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curStop = q.poll(); // expend cur node
                if (curStop == T) {
                    return count;
                }
                // generate
                for (Set<Integer> stopSet : graph) {
                    if (stopSet.contains(curStop)) {
                        for (int stop : stopSet) {
                            if (!visited.contains(stop)) {
                                q.offer(stop);
                                visited.add(stop);
                            }
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
