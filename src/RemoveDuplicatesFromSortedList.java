/**
 * Given a sorted linked list,
 * delete all duplicates such that each element appear only once.
 *
 * Input: 1->1->2
 *
 * Output: 1->2
 *
 *
 *
 * Easy
 * Linked List
 */



public class RemoveDuplicatesFromSortedList {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode removeDup(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = removeDup(head.next);
        if (head.value == next.value) {
            head.next = next.next;
        }
        return head;
    }
}
