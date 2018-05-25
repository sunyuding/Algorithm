import java.util.Stack;

public class BSTIterator {
    // in order traverse
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        inOrderTraverse(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        inOrderTraverse(cur.right);
        return cur.key;
    }

    private void inOrderTraverse(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
