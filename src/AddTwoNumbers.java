/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *
 * Output: 7 -> 0 -> 8
 *
 *
 * Medium
 * Linked List
 */
public class AddTwoNumbers {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int sum = l1.value + l2.value;
        ListNode head = new ListNode(sum % 10);
        ListNode cur = head;
        sum /= 10;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            sum += l1.value + l2.value;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        while (l1.next != null) {
            l1 = l1.next;
            sum += l1.value;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        while (l2.next != null) {
            l2 = l2.next;
            sum += l2.value;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        if (sum == 1) {
            cur.next = new ListNode(sum);
        }
        return head;
    }
}
