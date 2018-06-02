//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
// * write a function to check whether these edges make up a valid tree.
// *
// * For example:
// *
// * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
// *
// * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
// *
// * Note: you can assume that no duplicate edges will appear in edges.
// * Since all edges are undirected,
// * [0, 1] is the same as [1, 0]and thus will not appear together in edges.
// *
// * Medium
// * Breadth First Search
// * Depth First Search
// * Graph
// */
//public class GraphValidTree {
//    public boolean validTree(int n, int[][] edges) {
//        // valid tree:
//        // all nodes should be visited
//        // no circle: will only be visited once in a dfs branch
//        if (n < 2) {
//            return true;
//        }
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i, new ArrayList<>());
//        }
//        for (int[] edge: edges) {
//            map.get(edge[0]).add(edge[1]);
//            map.get(edge[1]).add(edge[0]);
//        }
//
//        boolean[] visited = new boolean[n];
//        // no circle: will only be visited once in a dfs branch
//        if (!dfs(0, -1, map, visited)) {
//            return false;
//        }
//        // all nodes should be visited
//        for (boolean b : visited) {
//            if (!b) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private boolean dfs(int cur, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
//        if (visited[cur]) {
//            return false;
//        }
//        visited[cur] = true;
//        for (int child : map.get(cur)) {
//            if (child != parent && !dfs(child, cur, map, visited)) {
//                 return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
//        GraphValidTree gvt = new GraphValidTree();
//        gvt.validTree(n, edges);
//    }
//}