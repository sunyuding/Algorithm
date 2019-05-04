package linked_list;
//Given a linked list,
// reverse the nodes of a linked list k at a time and return its modified list.
//
//        k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//        Example:
//
//        Given this linked list: 1->2->3->4->5
//                                      f
//
//        For k = 2, you should return: 2->1->4->3->5
//
//        For k = 3, you should return: 3->2->1->4->5
//                                      3  2  1  0
//        Note:
//
//        Only constant extra memory is allowed.
//        You may not alter the values in the list's nodes,
//        only nodes itself may be changed.
public class ReverseNodesInKGroup {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        //targeting to the tail of the first k
        int n = k;
        while(fast.next != null && n > 1) {
            fast = fast.next;
            n--;
        }
        if (n > 1) {
            return head;
        }
        ListNode next = fast.next;
        fast.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(next, k);
        return newHead;
    }
}
