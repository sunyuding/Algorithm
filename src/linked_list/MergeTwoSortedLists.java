package linked_list;
//Merge two sorted linked lists and return it as a new list.
// The new list should be made by splicing together the nodes of the first two lists.
//
//        Example:
//
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4

public class MergeTwoSortedLists {
    /**
    * Definition for singly-linked list.
    */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return dummy.next;
    }
}
