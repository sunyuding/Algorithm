package tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    /**
     * Time: O(n)
     * Space: O(height)
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node n : root.children) {
            traverse(n, result);
        }
        result.add(root.val);
    }
}
