package segment_tree;
//Given an integer array nums,
// find the sum of the elements between indices i and j (i ≤ j),
// inclusive.
//
//        The update(i, val) function modifies nums by updating the element at index i to val.
//
//        Example:
//
//        Given nums = [1, 3, 5]
//
//        sumRange(0, 2) -> 9
//        update(1, 2)
//        sumRange(0, 2) -> 8
//        Note:
//
//        The array is only modifiable by the update function.
//        You may assume the number of calls to update and sumRange function is distributed evenly.

/**
 * Runtime: 55 ms
 * Memory Usage: 46.1 MB
 */
public class NumArray {
    private class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        SegmentTreeNode(int min, int max) {
            this.start = min;
            this.end = max;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root;

    public NumArray(int[] nums) {
        // use the index as range
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            // base case1: null node
            return null;
        }

        SegmentTreeNode ret = new SegmentTreeNode(start, end);
        if (start == end) {
            // base case2: leaf node
            ret.sum = nums[start];
            return ret;
        }

        // post order traverse
        int mid = start  + (end - start) / 2;
        ret.left = buildTree(nums, start, mid);
        ret.right = buildTree(nums, mid + 1, end);
        ret.sum = ret.left.sum + ret.right.sum;
        return ret;
    }

    private void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            // leaf node
            root.sum = val;
            return;
        }
        // post order traverse
        int mid = root.start + (root.end - root.start) / 2;
        if (pos <= mid) {
            update(root.left, pos, val);
        } else {
            update(root.right, pos, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            // leaf node
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return sumRange(root.left, start, end);
        } else if (start >= mid + 1) {
            return sumRange(root.right, start, end);
        }  else {
            return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5};
        NumArray obj = new NumArray(nums);
//        obj.update(i,val);
        int param_2 = obj.sumRange(0,2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
