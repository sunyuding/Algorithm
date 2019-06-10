package segment_tree;

import java.util.Arrays;
import java.util.List;

//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property
// where counts[i] is the number of smaller elements to the right of nums[i].
//
//        Example:
//
//        Input: [5,2,6,1]
//        Output: [2,1,1,0]
//        Explanation:
//        To the right of 5 there are 2 smaller elements (2 and 1).
//        To the right of 2 there is only 1 smaller element (1).
//        To the right of 6 there is 1 smaller element (1).
//        To the right of 1 there is 0 smaller element.

/**
 * Segment Tree
 *
 */
//public class CountOfSmallerNumbersAfterSelf {
//
//    private class Node {
//        int start, end;
//        int count;
//        Node left, right;
//        Node(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//    }
//
//    private Node buildTree(int start, int end) {
//        if (start > end) return null;
//        if (start == end) return new Node(start, end);
//        int mid = start + (end - start) / 2;
//        Node node = new Node(start, end);
//        node.left = new Node(start, mid);
//        node.right = new Node(mid + 1, end);
//        return node;
//    }
//
////    Input: [5,2,6,1]
////    Output: [2,1,1,0]
//
//    public List<Integer> countSmaller(int[] nums) {
//        Integer[] count = new Integer[nums.length];
//
//        int[] converts = nums.clone();
//        Arrays.sort(converts);
//        // 1, 2, 5, 6
//
//        int[] nums2 = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            nums2[i] = Arrays.binarySearch(converts, nums[i]);
//        }
//        // nums2
//        // 2, 1, 3, 0
//        Node root = buildTree(0, nums2.length - 1);
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            count[i] = getCount(root, nums2[i]);
//            update(root, nums2[i]);
//        }
//
//        return Arrays.asList(count);
//    }
//
//    private void update(Node root, int pos) {
//        if (root.start == root.end) {
//            root.count++;
//            return;
//        }
//        int mid = root.start + (root.end - root.start) / 2;
//        if (pos <= mid) {
//            update(root.left, pos);
//        } else {
//            update(root.right, pos);
//        }
//        root.count = root.left.count + root.right.count;
//    }
//
//    private Integer getCount(Node root, int pos) {
//        if (root.start == root.end) return 0;
//        int mid = root.start + (root.end - root.start) / 2;
//        int left = 0, right = 0;
//        if (pos > mid) {
//            right = getCount(root.right, pos);
//            left = root.left.count;
//        } else {
//            left = getCount(root.left, pos);
//        }
//        return left + right;
//    }
//}

public class CountOfSmallerNumbersAfterSelf {


//    Input: [5,2,6,1]
//    Output: [2,1,1,0]

    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

        }

        return Arrays.asList(count);
    }


}
