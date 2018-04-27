//Given two sorted arrays A and B, of sizes m and n respectively.
// Define s = a + b, where a is one element from A and b is one element from B.
// Find the Kth smallest s out of all possible s'.
//
//        Assumptions
//
//        A is not null and A is not of zero length, so as B
//        K > 0 and K <= m * n
//        Examples
//
//        A = {1, 3, 5}, B = {4, 8}
//
//        1st smallest s is 1 + 4 = 5
//        2nd smallest s is 3 + 4 = 7
//        3rd, 4th smallest s are 9 (1 + 8, 4 + 5)
//        5th smallest s is 3 + 8 = 11
//        Medium
//        Breadth First Search
//        Heap

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSumInTwoSortedArrays {
    public int kthSum(int[] A, int[] B, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // extra O(k) space
        // O(nlogk)
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int s = A[i] + B[j];
                if (maxHeap.size() != k) {
                    maxHeap.add(s);
                } else if (s < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(s);

                }
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        KthSmallestSumInTwoSortedArrays KS = new KthSmallestSumInTwoSortedArrays();
        int[] A = new int[]{1, 3, 5};
        int[] B = new int[]{4, 8};
        KS.kthSum(A, B, 5);
    }
}
