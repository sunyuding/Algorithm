package breadth_first_search;

//There are a total of n courses you have to take,
// labeled from 0 to n-1.
//
//        Some courses may have prerequisites,
// for example to take course 0 you have to first take course 1,
// which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs,
// is it possible for you to finish all courses?
//
//        Example 1:
//
//        Input: 2, [[1,0]]
//        Output: true
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0.
// So it is possible.
//
//        Example 2:
//
//        Input: 2, [[1,0],[0,1]]
//        Output: false
//        Explanation: There are a total of 2 courses to take.
//        To take course 1 you should have finished course 0,
// and to take course 0 you should
//        also have finished course 1. So it is impossible.
//        Note:
//
//        The input prerequisites is a graph represented by a list of edges,
// not adjacency matrices.
// Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.

import java.util.*;

/**
 * Runtime: 30 ms
 * Memory Usage: 80.6 MB
 * Time: O(|V| + |E|)
 * Space: O(|V|)
 */
//public class CourseSchedule {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[][] graph = new int[numCourses][numCourses];
//        int[] indegree = new int[numCourses];
//        // construct the graph
//        for(int i = 0; i < prerequisites.length; i++) {
//            int cur = prerequisites[i][0];
//            int pre = prerequisites[i][1];
//            if (graph[pre][cur] == 0) {
//                indegree[cur]++; // new edge
//            }
//            graph[pre][cur] = 1;
//        }
//        // BFS
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegree[i] == 0) {
//                q.offer(i);
//            }
//        }
//        int count = 0;
//        while(!q.isEmpty()) {
//            int cur = q.poll();
//            count++;
//            for (int i = 0; i < numCourses; i++) {
//                if (graph[cur][i] == 1) {
//                    indegree[i]--;
//                    if (indegree[i] == 0) {
//                        q.offer(i);
//                    }
//                }
//            }
//        }
//        return count == numCourses;
//    }
//}

/**
 * Runtime: 6 ms
 * Memory Usage: 44.5 MB
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (!graph.containsKey(pre)) {
                graph.put(pre, new ArrayList<>());
            }
            indegree[cur]++;
            graph.get(pre).add(cur);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            count++;
            if (graph.containsKey(cur)) {
                for (int i : graph.get(cur)) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}