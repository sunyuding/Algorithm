import java.util.Deque;
import java.util.LinkedList;

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
        public int val;
        public ListNode next;
        public ListNode(int value) {
            this.val = value;
            this.next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int sum = l1.val + l2.val;
        ListNode head = new ListNode(sum % 10);
        ListNode cur = head;
        sum /= 10;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            sum += l1.val + l2.val;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        while (l1.next != null) {
            l1 = l1.next;
            sum += l1.val;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        while (l2.next != null) {
            l2 = l2.next;
            sum += l2.val;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        if (sum == 1) {
            cur.next = new ListNode(sum);
        }
        return head;
    }

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while(l1 != null) {
            stack1.offerFirst(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.offerFirst(l2.val);
            l2 = l2.next;
        }
        int add = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            int num = stack1.pollFirst() + stack2.pollFirst() + add;
            int digit = num % 10;
            add = num / 10;

            ListNode node = new ListNode(digit);
            node.next = dummy.next;
            dummy.next = node;
        }
        while(!stack1.isEmpty()) {
            int num = stack1.pollFirst() + add;
            int digit = num % 10;
            add = num / 10;

            ListNode node = new ListNode(digit);
            node.next = dummy.next;
            dummy.next = node;
        }
        while(!stack2.isEmpty()) {
            int num = stack2.pollFirst() + add;
            int digit = num % 10;
            add = num / 10;

            ListNode node = new ListNode(digit);
            node.next = dummy.next;
            dummy.next = node;
        }
        if (add == 1) {
            ListNode node = new ListNode(add);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers ins = new AddTwoNumbers();
    }
}
