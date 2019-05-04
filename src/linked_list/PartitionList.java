package linked_list;
//Given a linked list and a value x,
// partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//        You should preserve the original relative order of the nodes in each of the two partitions.
//
//        Example:
//
//        Input: head = 1->4->3->2->5->2, x = 3
//        Output: 1->2->2->4->3->5

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode leftDummy  = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode rightDummy = new ListNode(-1);
        ListNode right = rightDummy;
        while(head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = rightDummy.next;
        right.next = null;
        return leftDummy.next;
    }
}
