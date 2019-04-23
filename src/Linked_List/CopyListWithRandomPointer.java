package Linked_List;
//138. Copy List with Random Pointer
//A linked list is given such that each node contains an additional random pointer
// which could point to any node in the list or null.
//
//        Return a deep copy of the list.
//
//
//
//        Example 1:
//
//
//
//        Input:
//        {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
//
//        Explanation:
//        Node 1's value is 1, both of its next and random pointer points to Node 2.
//        Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
//
//
//        Note:
//
//        You must return the copy of the given head as a reference to the cloned list.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CopyListWithRandomPointer {
    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    Map<Node, Node> dict = new HashMap<>();

    //Recursive
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if (dict.containsKey(head)) {
            return dict.get(head);
        }
        Node newHead = new Node(head.val, null, null);
        dict.put(head, newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);
        return newHead;
    }
}
