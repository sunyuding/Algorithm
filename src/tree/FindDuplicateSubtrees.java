package tree;

import java.util.*;

//Given a binary tree,
// return all duplicate subtrees.
// For each kind of duplicate subtrees,
// you only need to return the root node of any one of them.
//
//        Two trees are duplicate if they have the same structure with same node values.
//
//        Example 1:
//
//             1
//            / \
//           2   3
//          /   / \
//         4   2   4
//            /
//           4
//        The following are two duplicate subtrees:
//
//          2
//         /
//        4
//        and
//
//        4
//        Therefore, you need to return above trees' root in the form of a list.
public class FindDuplicateSubtrees {
//    Set<String> duplicate;
    HashMap<String, TreeNode> strToTreeNode;

    /**
     * Time: O(n)
     * Space: O(n)
     * Runtime: 18 ms
     * Memory Usage: 68.4 MB
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        duplicate = new HashSet<>();
        strToTreeNode  = new HashMap<>();
        //O(n)
        tree2str(root);
        List<TreeNode> result = new ArrayList<>();
        //O(n)
        for (Map.Entry entry : strToTreeNode.entrySet()) {
            if (entry.getValue() != null) {
                result.add((TreeNode) entry.getValue());
            }
        }
        return result;
    }
    //O(n)
    private String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        String left = tree2str(t.left);
        if (t.left != null) {
//            if (duplicate.contains(left)) {
//                strToTreeNode.put(left, t.left);
//            }
//            duplicate.add(left);
            if (strToTreeNode.containsKey(left)) {
                strToTreeNode.put(left, t.left);
            } else {
                strToTreeNode.put(left, null);
            }
        }
        String right = tree2str(t.right);
        if (t.right != null) {
//            if (duplicate.contains(right)) {
//                strToTreeNode.put(right, t.right);
//            }
//            duplicate.add(right);
            if (strToTreeNode.containsKey(right)) {
                strToTreeNode.put(right, t.right);
            } else {
                strToTreeNode.put(right, null);
            }
        }
        //case1: left  , right is null
        //     don't append
        //case2: left has child, right not
        //     (left)
        //case3: right has child, left not
        // (left) (right)
        //case4: right has, left has
        // (left)(right)
        if (right.length() != 0) {
            sb.append("(").append(left).append(")").append("(").append(right).append(")");
        } else if (left.length() != 0) {
            sb.append("(").append(left).append(")");
        }
        return sb.toString();
    }
}
