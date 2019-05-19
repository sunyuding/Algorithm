package tree;

import java.util.*;

// Given a binary tree where every node has a unique value,
// and a target key k,
// find the value of the nearest leaf node to target k in the tree.
//
//        Here,
// nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree.
// Also,
// a node is called a leaf if it has no children.
//
//        In the following examples,
// the input tree is represented in flattened form row by row.
// The actual root tree given will be a TreeNode object.
//Example 1:
//
//        Input:
//        root = [1, 3, 2], k = 1
//        Diagram of binary tree:
//           1
//          / \
//         3   2
//
//        Output: 2 (or 3)
//
//        Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
//        Example 2:
//
//        Input:
//        root = [1], k = 1
//        Output: 1
//
//        Explanation: The nearest leaf node is the root node itself.
//        Example 3:
//
//        Input:
//        root = [1,2,3,4,null,null,null,5,null,6], k = 2
//        Diagram of binary tree:
//               1
//              / \
//             2   3
//            /
//           4
//          /
//         5
//        /
//       6
//
//        Output: 3
//        Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
//        Note:
//        root represents a binary tree with at least 1 node and at most 1000 nodes.
//        Every node has a unique node.val in range [1, 1000].
//        There exists some node in the given binary tree for which node.val == k.
public class ClosestLeafInABinaryTree {
    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
        convertGraph(root, graph);

        TreeNode kNode = getTarget(root, k);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> isVisited = new HashSet<>();
        isVisited.add(kNode);
        q.offer(kNode);

        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                //base case: leaf node
                if (cur.left == null && cur.right == null) {
                    return cur.val;
                }
                for (TreeNode node : graph.get(cur)) {
                    if (!isVisited.contains(node)) {
                        isVisited.add(node);
                        q.offer(node);
                    }
                }
            }
        }
        return -1;
    }

    private TreeNode getTarget(TreeNode root, int k) {
        if (root == null) return null;
        if (root.val == k) return root;
        TreeNode left = getTarget(root.left, k);
        TreeNode right = getTarget(root.right, k);
        return left != null? left : right;
    }

    private void convertGraph(TreeNode node, Map<TreeNode, Set<TreeNode>> graph) {
        if (node == null) {
            return;
        }
        if (!graph.containsKey(node)) {
            graph.put(node, new HashSet<>());
        }
        if (node.left != null) {
            graph.get(node).add(node.left);
            if (!graph.containsKey(node.left)) {
                graph.put(node.left, new HashSet<>());
            }
            graph.get(node.left).add(node);
            convertGraph(node.left, graph);
        }
        if (node.right != null) {
            graph.get(node).add(node.right);
            if (!graph.containsKey(node.right)) {
                graph.put(node.right, new HashSet<>());
            }
            graph.get(node.right).add(node);
            convertGraph(node.right, graph);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n5.left = n6;
        ClosestLeafInABinaryTree ins = new ClosestLeafInABinaryTree();
        ins.findClosestLeaf(n1, 2);
    }
}
