//Description
//Check if a given linked list has a cycle.
// Return the node where the cycle starts.
// Return null if there is no cycle.
//
//Medium
//Linked List
//Two Pointers

class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class CycleNodeInLinkedList {
    public ListNode cycleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // cycle exist
                // a = (n-1) * loop + c
                while(head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }


}
