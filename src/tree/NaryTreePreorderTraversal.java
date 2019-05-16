package tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node n : root.children) {
            traverse(n, result);
        }
    }
}
