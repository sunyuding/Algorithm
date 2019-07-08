package breadth_first_search;

import java.util.*;

public class ShortestDistanceOfXAndY {
    private class TreeNode {
        TreeNode left, right;
        String name;
        TreeNode (String name) {
            this.name = name;
        }
    }

    // Note:
    // 0 for X and 1 for Y
    int shortest = Integer.MAX_VALUE;

    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @return
     */
    public int shortestDistance(TreeNode root) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        buildGraph(root, map, q, visited);

        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                List<TreeNode> list = map.get(cur);
                for (TreeNode neigh : list) {
                    if (!visited.contains(neigh)) {
                        if (neigh.name.equals("Y")) {
                            return count + 1;
                        }
                        visited.add(neigh);
                        q.offer(neigh);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param map
     * @param q
     * @param visited
     */
    private void buildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> map, Queue<TreeNode> q, Set<TreeNode> visited) {
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<>());
        }
        if (root.name.equals("X")) {
            visited.add(root);
            q.offer(root);
        }
        if (root.left != null) {
            map.get(root).add(root.left);
            if (!map.containsKey(root.left)) {
                map.put(root.left, new ArrayList<>());
            }
            map.get(root.left).add(root);
            buildGraph(root.left, map, q, visited);
        }
        if (root.right != null) {
            map.get(root).add(root.right);
            if (!map.containsKey(root.right)) {
                map.put(root.right, new ArrayList<>());
            }
            map.get(root.right).add(root);
            buildGraph(root.right, map, q, visited);
        }
    }
}
