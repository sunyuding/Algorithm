package breadth_first_search;
//Given n nodes labeled from 0 to n-1 and a list of undirected edges
// (each edge is a pair of nodes),
// write a function to check whether these edges make up a valid tree.
//
//        Example 1:
//
//        Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//        Output: true
//        Example 2:
//
//        Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//        Output: false
//        Note: you can assume that no duplicate edges will appear in edges.
// Since all edges are undirected,
// [0,1] is the same as [1,0] and thus will not appear together in edges.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Runtime: 35 ms
 * Memory Usage: 80.6 MB
 * Time: O(|V| + |E|)
 * Space: O(|E|)
 * 1) There is no cycle.
 * 2) The graph is connected.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // construct the graph
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        // traverse the graph to check if for each node,
        // 1) There is no cycle.
        // 2) The graph is connected.
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    // cur is the parent of i
                    // which is already polled from the queue
                    // if there is still a neighbor of i in the q
                    // there must be a cycle
                    if (q.contains(i)) {
                        // There is no cycle.
                        return false;
                    }
                    if (!visited.contains(i)) {
                        q.offer(i);
                        visited.add(i);
                    }
                }
            }
        }
        return count == n; //The graph is connected.
    }
}
