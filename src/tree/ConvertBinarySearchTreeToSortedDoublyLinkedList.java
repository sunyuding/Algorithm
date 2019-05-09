package tree;
//Convert a BST to a sorted circular doubly-linked list in-place.
// Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
//
//        Let's take the following BST as an example,
// it may help you understand the problem better:
//Specifically,
// we want to do the transformation in place.
// After the transformation,
// the left pointer of the tree node should point to its predecessor,
// and the right pointer should point to its successor.
// We should return the pointer to the first element of the linked list.

import java.util.ArrayDeque;
import java.util.Deque;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /**
     * Time: O(n)
     * Space: O(height)
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        //in-order traverse
        if (root == null) return null;
        Deque<Node> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        Node head = null;
        Node tail = null;
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            if (head == null) {
                head = cur;
            }
            if (tail != null) {
                tail.right = cur;
            }
            cur.left = tail;
            tail = cur;
            pushLeft(cur.right, stack);
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void pushLeft(Node node, Deque<Node> stack) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        Node n4 = new Node();
        Node n2 = new Node();
        Node n5 = new Node();
        Node n1 = new Node();
        Node n3 = new Node();
        n4.val = 4;
        n4.left = n2;
        n4.right = n5;
        n2.val = 2;
        n2.left = n1;
        n2.right = n3;
        n1.val = 1;
        n3.val = 3;
        n5.val = 5;
        ConvertBinarySearchTreeToSortedDoublyLinkedList ins = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
        Node cur = ins.treeToDoublyList(n4);
    }
}
