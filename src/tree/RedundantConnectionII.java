package tree;
//In this problem,
// a rooted tree is a directed graph such that,
// there is exactly one node (the root) for which all other nodes are descendants of this node,
// plus every node has exactly one parent,
// except for the root node which has no parents.
//
//        The given input is a directed graph that started as a rooted tree with N nodes
// (with distinct values 1, 2, ..., N),
// with one additional directed edge added.
// The added edge has two different vertices chosen from 1 to N,
// and was not an edge that already existed.
//
//        The resulting graph is given as a 2D-array of edges.
// Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v,
// where u is a parent of child v.
//
//        Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes.
// If there are multiple answers,
// return the answer that occurs last in the given 2D-array.
//
//        Example 1:
//        Input: [[1,2], [1,3], [2,3]]
//        Output: [2,3]
//        Explanation: The given directed graph will be like this:
//          1
//         / \
//        v   v
//        2-->3
//        Example 2:
//        Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//        Output: [4,1]
//        Explanation: The given directed graph will be like this:
//        5 <- 1 -> 2
//             ^    |
//             |    v
//             4 <- 3
//        Note:
//        The size of the input 2D-array will be between 3 and 1000.
//        Every integer represented in the 2D-array will be between 1 and N,
// where N is the size of the input array.

import java.util.*;

public class RedundantConnectionII {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        // traverse the graph to check if for each node,
        // 1) There is no cycle.
        // 2) The graph is connected.
        for (int i = edges.length - 1; i >= 0; i--) {
            if (validTree(0, edges)) {
                return edges[i];
            }
        }
        return null;
    }

    private boolean validTree(int n, int[][] edges) {
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

    public static void main(String[] args) {
//        int[][] edges = new int[][] {{1, 2}, {1, 3}, {2, 3}};
        int[][] edges = new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        RedundantConnectionII ins = new RedundantConnectionII();
        ins.findRedundantDirectedConnection(edges);
    }

}
