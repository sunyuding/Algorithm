package tree;

//In this problem,
// a tree is an undirected graph that is connected and has no cycles.
//
//        The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
// with one additional edge added.
// The added edge has two different vertices chosen from 1 to N,
// and was not an edge that already existed.
//
//        The resulting graph is given as a 2D-array of edges.
// Each element of edges is a pair [u, v] with u < v,
// that represents an undirected edge connecting nodes u and v.
//
//        Return an edge that can be removed so that the resulting graph is a tree of N nodes.
// If there are multiple answers,
// return the answer that occurs last in the given 2D-array.
// The answer edge [u, v] should be in the same format,
// with u < v.
//Example 1:
//        Input: [[1,2], [1,3], [2,3]]
//        Output: [2,3]
//        Explanation: The given undirected graph will be like this:
//          1
//         / \
//        2 - 3
//        Example 2:
//        Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//        Output: [1,4]
//        Explanation: The given undirected graph will be like this:
//        5 - 1 - 2
//            |   |
//            4 - 3
//        Note:
//        The size of the input 2D-array will be between 3 and 1000.
//        Every integer represented in the 2D-array will be between 1 and N,
// where N is the size of the input array.
//
//        Update (2017-09-26):
//        We have overhauled the problem description + test cases and
// specified clearly the graph is an undirected graph.
// For the directed graph follow up please see Redundant Connection II).
// We apologize for any inconvenience caused.


import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {
    /**
     * For each edge edges[i],
     * if node edges[i][0] and node deges[i][1] could be connected through other edges,
     * then we are able to remove it
     * Time: O(n ^ 2)
     * Space: O(n)
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        Set<int[]> visited = new HashSet<>();
        int[] result = null;
        for (int[] edge : edges) { // O(n)
            visited.add(edge);
            int node1 = edge[0];
            int node2 = edge[1];
            if (traverse(edges, visited, node1, node2)) {
                result = edge;
            }
            visited.remove(edge);
        }
        return result;
    }

    private boolean traverse(int[][] edges, Set<int[]> visited, int start, int end) {
        if (start == end) {
            return true;
        }
        for (int[] edge : edges) {  //O(n)
            if (!visited.contains(edge)) {
                if (edge[0] == start) {
                    visited.add(edge);
                    if (traverse(edges, visited, edge[1], end)) {
                        return true;
                    }
                    visited.remove(edge);
                }
                if (edge[1] == start) {
                    visited.add(edge);
                    if (traverse(edges, visited, edge[0], end)) {
                        return true;
                    }
                    visited.remove(edge);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{1, 2}, {1, 3}, {2, 3}};
        RedundantConnection ins = new RedundantConnection();
        ins.findRedundantConnection(edges);
    }
}
