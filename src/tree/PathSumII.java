package tree;

import javafx.util.Pair;

import java.util.*;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given the below binary tree and sum = 22,
//
//             5(5)
//          /          \
//         4(9)        8(13)
//        /            /          \
//        11(20)      13(26)      4(17)
//       /     \               /       \
//      7(27)    2(22)        5(22)    1(18)
//        Return:
//
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
public class PathSumII {
    //Time: O(2 ^ height)
    //Space: O(branches * height)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (root == null) return result;
        cur.add(root.val);
        dfs(root, sum, result, cur, root.val);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> cur, int curSum) {
        if (root.left == null && root.right == null) {
            if (curSum == sum) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        if (root.left != null) {
            cur.add(root.left.val);
            dfs(root.left, sum, result, cur, curSum + root.left.val);
            cur.remove(cur.size() - 1);
        }
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(root.right, sum, result, cur, curSum + root.right.val);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * Time: O(n) + (nheight)
     * Space: O(n)
     */
    public List<List<Integer>> pathSumIterative(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Set<TreeNode> set = new HashSet<>();
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, root.val));
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        childToParent.put(root, null);
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            if (cur.getKey().left == null && cur.getKey().right == null) {
                //leaf node
                if (cur.getValue() == sum) {
                    set.add(cur.getKey());
                }
            }
            if (cur.getKey().left != null) {
                stack.push(new Pair<>(cur.getKey().left, cur.getValue() + cur.getKey().left.val) );
                childToParent.put(cur.getKey().left, cur.getKey());
            }
            if (cur.getKey().right != null) {
                stack.push(new Pair<>(cur.getKey().right, cur.getValue() + cur.getKey().right.val));
                childToParent.put(cur.getKey().right, cur.getKey());
            }
        }
        for (TreeNode node : set) {
            List<Integer> list = new LinkedList<>();
            while(node != null) {
                ((LinkedList<Integer>) list).addFirst(node.val);
                node = childToParent.get(node);
            }
            result.add(list);
        }
        return result;
    }
}
