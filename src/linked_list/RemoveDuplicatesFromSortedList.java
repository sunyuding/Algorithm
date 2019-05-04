package linked_list;
//Given a sorted linked list,
// delete all duplicates such that each element appear only once.
//
//        Example 1:
//
//        Input: 1->1->2
//        dummy   ->1->2
//                     s
//                     f
//        Output: 1->2
//        Example 2:
//
//        Input: 1->1->2->3->3
//        Output: 1->2->3

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        while(slow.next != null) {
            ListNode fast = slow.next;
            while(fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
        return dummy.next;
    }
}