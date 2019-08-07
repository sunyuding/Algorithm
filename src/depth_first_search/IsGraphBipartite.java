package depth_first_search;

/**
 * Time: O(n)
 * Space: O(1) for extra data structure    O(n) for call stack
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return true;
        int[] mark = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (mark[i] == 0 && !dfs(graph, mark, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] mark, int color, int node) {
        if (mark[node] != 0) {
            return mark[node] == color;
        }
        mark[node] = color;
        for (int neighbor : graph[node]) {
            if (mark[neighbor] == color) {
                return false;
            }
            if (mark[neighbor] == 0 && !dfs(graph, mark, 3 - color, neighbor)) {
                return false;
            }
        }
        return true;
    }
}
