package tree;
// 222. Count Complete tree Nodes
// Given a complete binary tree,
// count the number of nodes.
//
//        Note:
//
//        Definition of a complete binary tree from Wikipedia:
//        In a complete binary tree every level,
// except possibly the last,
// is completely filled,
// and all nodes in the last level are as far left as possible.
// It can have between 1 and 2h nodes inclusive at the last level h.
//              1
//            /   \
//           2     3
//          / \   /
//         4   5  6
public class CountCompleteTreeNodes {
    /**
     * Time: O(logn * logn)
     * Space: O(logn)
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        int leftHeight = getHeight(root.left); // 2      O(logn)
        int rightHeight = getHeight(root.right); // 2    O(height)
        int count = 1;
        if (leftHeight == rightHeight) {
            // left subtree is a perfect tree
            count += perfectTreeCount(leftHeight);    //   3  (2)
            count += countNodes(root.right);  //   2 {2}
        } else {
            // right subtree is a perfect tree
            count += perfectTreeCount(rightHeight);
            count += countNodes(root.left);
        }
        return count;
    }

    // O(logn)
    private int perfectTreeCount(int height) {   //2
        int count = 0;
        for (int i = 0; i < height; i++) {
            count += Math.pow(2, i);        //  2 ^ 0 + 2 ^ 1
        }
        return count;   // 3
    }

    // O(logn)
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + getHeight(node.left);   //
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        CountCompleteTreeNodes ins = new CountCompleteTreeNodes();
        int result = ins.countNodes(node1);

        System.out.println(result);
    }
}
