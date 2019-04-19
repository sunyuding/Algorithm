package Linked_List;

//Given a linked list,
// rotate the list to the right by k places,
// where k is non-negative.
//
//        Example 1:
//
//        Input: 1->2->3->|4->5->NULL, k = 2
//        Output: 4->5->1->2->3->NULL
//        Explanation:
//        rotate 1 steps to the right: 5->1->2->3->4->NULL
//        rotate 2 steps to the right: 4->5->1->2->3->NULL
//        Example 2:
//
//        Input: 0->1->2->NULL, k = 4
//        Output: 2->0->1->NULL
//        Explanation:
//        rotate 1 steps to the right: 2->0->1->NULL
//        rotate 2 steps to the right: 1->2->0->NULL
//        rotate 3 steps to the right: 0->1->2->NULL
//        rotate 4 steps to the right: 2->0->1->NULL
public class RotateList {
    private int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverse(next);
        next.next = head;
        return newHead;
    }

    //        Input: 1->2->3->|4->5->NULL, k = 2
    //               5->4->|3->2->1->NULL
    //               2  1   0
    //        Output: 4->5->1->2->3->NULL
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = getLength(head);
        k = k % length;
        if (k < 1) return head;
        ListNode newHead = reverse(head);
        //targeting to the tail of the first k
        ListNode cur = newHead;
        while(k > 1) {
            if (cur.next == null) {
                cur = newHead;
            } else {
                cur = cur.next;
            }
            k--;
        }
        // k == 1
        // newHead -> ... -> tailLeft | headRight -> ... ->
        ListNode headRight = cur.next;
        cur.next = null;
        ListNode result = reverse(newHead);
        newHead.next = reverse(headRight);
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        for (int i = 2; i < 6; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        RotateList ins = new RotateList();
        ListNode newNode = ins.rotateRight(head, 2);
        while(newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}
