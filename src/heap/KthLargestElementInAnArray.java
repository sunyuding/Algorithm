package heap;

import java.util.PriorityQueue;

// 215 Kth Largest Element in an Array
// Find the kth largest element in an unsorted array.
// Note that it is the kth largest element in the sorted order,
// not the kth distinct element.
//Example 1:
//
//        Input: [3,2,1,5,6,4] and k = 2
//        Output: 5
//        Example 2:
//
//        Input: [3,2,3,1,2,4,5,5,6] and k = 4
//        Output: 4
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ array's length.
public class KthLargestElementInAnArray {
    /**
     * Time: O(nlogk)
     * Space: O(k)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        for (int num : nums) {
            minHeap.add(num);
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
