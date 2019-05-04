package linked_list;

//Given a singly linked list where elements are sorted in ascending order,
// convert it to a height balanced BST.
//
//        For this problem,
// a height-balanced binary tree is defined as a binary tree
// in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example:
//
//        Given the sorted linked list: [-10,-3,0,5,9],
//
//        One possible answer is: [0,-3,9,-10,null,5],
// which represents the following height balanced BST:
//
//         0
//        / \
//      -3   9
//      /   /
//    -10  5
//      1   2   3  4
//          s
//                 f
//       1   2  3  4  5
//              s
//                      f
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
            root.left = sortedListToBST(head);
        }
        ListNode next = slow.next;
        slow.next = null;
        root.right= sortedListToBST(next);
        return root;
    }
}
