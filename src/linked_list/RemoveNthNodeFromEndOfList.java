package linked_list;
//Given a linked list, remove the n-th node from the end of list and return its head.
//
//        Example:
//
//        Given linked list: 1->2->3->4->5, and n = 2.
//
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        Note:
//
//        Given n will always be valid.
//
//        Follow up:
//
//        Could you do this in one pass?
public class RemoveNthNodeFromEndOfList {
    /**
    * Definition for singly-linked list.
    */
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //        Given linked list: 1->2->3->4->5-null, and n = 2.
                             //           s
                            //                  f

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // fast targeting the tail.next
        while(fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        if (n > 0) {
            return head;
        }
        if (fast == null) {
            return head.next;
        }
        // fast targeting the tail
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // delete slow.next
        if (slow.next != null) {
            slow.next = slow.next.next;
        } else {
            slow.next = null;
        }
        return dummy.next;
    }
}
