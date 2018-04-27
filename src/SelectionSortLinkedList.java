//Description
//        Given a singly-linked list,
// where each node contains an integer value,
// sort it in ascending order.
// The selectoin sort algorithm should be used to solve this problem.
//
//        Examples
//
//        null, is sorted to null
//        1 -> null, is sorted to 1 -> null
//        1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
//        4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to 2 -> 3 -> 4 -> 5 -> 6
//        Hard
//        Linked List
//        Sort

public class SelectionSortLinkedList {

    class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode selectionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
            if (cur.value < head.value) {
                swap(head, cur);
            }
        }
        head.next = selectionSort(head.next);
        return head;
    }

    private void swap(ListNode left, ListNode right) {
        int tmp = left.value;
        left.value = right.value;
        right.value = tmp;
    }
}
