import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++)
            adj.add(i, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(adj, i, stack, visited))
                return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private boolean topologicalSort(List<List<Integer>> adj, int v,
                                    Stack<Integer> stack, int[] visited) {
        if (visited[v] == 2)
            return true;
        if (visited[v] == 1)
            return false;
        visited[v] = 1;
        for (Integer u : adj.get(v)) {
            if (!topologicalSort(adj, u, stack, visited))
                return false;
        }
        visited[v] = 2;
        stack.push(v);
        return true;
    }
    //4, [[1,0],[2,0],[3,1],[3,2]]
    public static void main(String[] args) {
        Topological ins = new Topological();
        ins.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3,2}});
    }
}
