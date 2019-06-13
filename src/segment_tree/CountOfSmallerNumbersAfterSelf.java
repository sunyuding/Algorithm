package segment_tree;

import java.util.LinkedList;
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
 * Time: O(nlog(n))
 * Space: O()
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
////        List<Integer> res = new ArrayList<>(nums.length);
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
////            res.add(i, getCount(root, nums2[i]));
//        }
//
//        return Arrays.asList(count);
////        return res;
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

    static class SegmentTreeNode {
        int min, max;	// 记录范围 interval [min, max]
        int count;	//落在这个区间的个数
        SegmentTreeNode left, right;

        public SegmentTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            this.count = 0;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();
        // get the range
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        SegmentTreeNode root = new SegmentTreeNode(min, max);
        // traverse from right to left
        for(int i = nums.length - 1; i >= 0; i--) {
            list.add(0, query(root, nums[i]));
            update(root, nums[i]);
        }
        return list;
    }

    private int query(SegmentTreeNode root, int num) {
        if(root == null) {
            return 0;
        }
        //我们只需要查找比当前数i小的所有数，count正好保存这个信息
        if(num > root.max) {
            return root.count;
        }
        //开始log(n)查找
        int mid = root.min + (root.max - root.min) / 2;
        if(num <= mid) {
            // left
            return query(root.left, num);
        } else {
            //如果当前数>=mid,则需要找左右两个子树
            return query(root.left, num) + query(root.right, num);
        }
    }

    private void update(SegmentTreeNode root, int num) {
        //如果不在这个有效范围，直接退出, min & max 是提前设置好的
        if(root == null || num < root.min || num > root.max) {
            return;
        }
        //小于等于root.max的count++
        root.count++;
        //左右值相等，区间内只有一个值，到达叶子节点，直接退出
        if(root.min == root.max) {
            root.count = 1;
            return;
        }
        int mid = root.min + (root.max - root.min) / 2;
        if(num <= mid) {
            if(root.left == null) {
                root.left = new SegmentTreeNode(root.min, mid);
            }
            //转移到左子树进行更新
            update(root.left, num);
        } else {
            if(root.right == null) {
                root.right = new SegmentTreeNode(mid + 1, root.max);
            }
            //转移到右子树进行更新
            update(root.right, num);
        }
    }
}
