package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Return the max sliding window.

 Example:

 Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 Output: [3,3,5,5,6,7]
 Explanation:

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Note:
 You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.


 Follow up:
 Could you solve it in linear time?

 *
 * Runtime: 36 ms
 * Memory Usage: 40 MB
 * Time: O(nlogk)
 * Space: O(n)
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[] {};
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            maxHeap.offer(nums[i]);
            result[0] = maxHeap.peek();
        }
        for (int i = 0; i + k < nums.length; i++) {
            // i is the start end going to remove
            maxHeap.remove(nums[i]);
            // i + k is the coming one
            maxHeap.add(nums[i + k]);
            result[i + 1] = maxHeap.peek();
        }
        return result;
    }
}
