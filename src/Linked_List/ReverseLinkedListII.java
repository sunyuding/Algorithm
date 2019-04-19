package Linked_List;
//Reverse a linked list from position m to n.
// Do it in one-pass.
//
//        Note: 1 ≤ m ≤ n ≤ length of list.
//
//        Example:
//               1  2  3  4  5
//        Input: 1->2->3->4->5->NULL, m = 2, n = 4
//        dummy->
//                        f
//            n= 3  2  1  0
//        Output: 1->4->3->2->5->NULL
//          head->...->p1-|>p2->....-> p3-|>p4->....
public class ReverseLinkedListII {
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverse(next);
        next.next = head;
        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m > n) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        while(fast != null && m > 1) {
            fast = fast.next;
            m--;
            n--;
        }
        ListNode p1 = fast;
        if (fast == null) {
            return dummy.next;
        }
        ListNode p2 = fast.next;
        while(fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode p3 = fast;
        if (fast == null) {
            p1.next = null;
            p1.next = reverse(p2);
            return dummy.next;
        }
        ListNode p4 = fast.next;
        p1.next = null;
        p3.next = null;
        p1.next = reverse(p2);
        p2.next = p4;
        return dummy.next;
    }
}
