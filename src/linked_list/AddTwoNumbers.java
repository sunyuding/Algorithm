package linked_list;
//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//
//        You may assume the two numbers do not contain any leading zero,
// except the number 0 itself.
//
//        Example:
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.

public class AddTwoNumbers {
    /**
    * Definition for singly-linked list.
    */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //        Input: (2 -> 4 -> 3) +
    //                          l1
    //               (5 -> 6 -> 4)
    //                         l2
    //
    //        dummy->7->0->8
    //                 cur
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int add = 0;
        ListNode cur = dummy;
        int sum = 0;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + add;
            cur.next = new ListNode(sum % 10);
            add = sum / 10;

            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode res = l1 != null? l1 : l2;
        while(res != null) {
            sum = res.val + add;
            cur.next = new ListNode(sum % 10);
            add = sum / 10;
            cur = cur.next;
            res = res.next;
        }
        if (add != 0) {
            cur.next = new ListNode(add);
        }
        return dummy.next;
    }
}
