package Tree;
//Given a binary search tree and a node in it,
// find the in-order successor of that node in the BST.
//
//        The successor of a node p is the node with the smallest key greater than p.val.
//
//        You will have direct access to the node but not to the root of the tree.
// Each node will have a reference to its parent node.
//Follow up:
//
//        Could you solve it without looking up any of the node's values?

public class InorderSuccessorInBSTII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        if (x.right != null) {
            return firstNode(x.right);
        }
        while(x.parent != null && x != x.parent.left) {
            x = x.parent;
        }
        // x == x.parent.left
        return x.parent;
    }

    private Node firstNode(Node node) {
        if (node == null) return null;
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
