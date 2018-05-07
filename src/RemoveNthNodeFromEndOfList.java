/**
 * Given a linked list,
 * remove the nth node from the end of list and return its head.
 *
 * Assumptions
 * If n is not valid,
 * you do not need to do anything to the original list.
 * Try to do this in one pass.
 *
 * Examples
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end,
 * the linked list becomes 1->2->3->5.
 * Medium
 * Linked List
 */
public class RemoveNthNodeFromEndOfList {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode f = head;
        for (int i = 1; i < n; i++) {
            f = f.next;
            if (f == null) {
                return head;
            }
        }
        ListNode s = head;
        ListNode sPrev = null;
        while(f.next != null) {
            f = f.next;
            sPrev = s;
            s = s.next;
        }
        // now s is the node to be removed
        if(s == head) {
            return head.next;
        }
        ListNode sNext = s.next;
        sPrev.next = sNext;
        return head;
    }
}
