package breadth_first_search;

import java.util.*;

/**
 * Time: O(V + E)
 * Space: O(V + E)
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> myGraph = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();

        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];

        for(int i=0; i<n; i++) {
            myGraph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i<edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        Queue<Integer> myQueue = new ArrayDeque<Integer>();

        for(int i = 0; i < n; i++) {
            if (degree[i]==0) {
                // only a single node
                return res;
            } else if (degree[i]==1) {
                // leaf node
                // generate leaf node
                // delete them
                myQueue.offer(i);
                degree[i]--;
            }
        }

        while (!myQueue.isEmpty()) {
            res.clear();
            int count = myQueue.size();

            for(int i=0; i<count; i++){
                int curr = myQueue.poll();// expand current node
                res.add(curr);
                for(int k = 0; k < myGraph.get(curr).size(); k++) {
                    int next = myGraph.get(curr).get(k);
                    // generate connected nodes
                    degree[next]--;
                    if(degree[next] == 1) {
                        // leaf node
                        myQueue.offer(next);
                    }
                }
            }
        }
        return res;
    }
}
