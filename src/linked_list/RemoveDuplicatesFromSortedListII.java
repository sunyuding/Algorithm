package linked_list;
//Given a sorted linked list,
// delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
//
//        Example 1:
//
//        Input: 1->2->3->3->4->4->5
//        dummy->1->2->5
//                  s
//                     f
//        Output: 1->2->5
//        Example 2:
//
//        Input: 1->1->1->2->3
//        Output: 2->3
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;

        while(slow.next != null) {
            ListNode fast = slow.next;
            while (fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
            }
            // fast.next == null or fast.next.val != fast.val
            if (slow.next == fast) {
                slow = slow.next;
            } else {
                slow.next = fast.next;
            }
        }
        return dummy.next;
    }
}
