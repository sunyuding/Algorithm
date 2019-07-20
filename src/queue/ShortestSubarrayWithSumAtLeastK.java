package queue;

import java.util.ArrayDeque;
import java.util.Deque;

//Return the length of the shortest,
// non-empty,
// contiguous subarray of A with sum at least K.
//
//        If there is no non-empty subarray with sum at least K,
// return -1.
//
//
//
//        Example 1:
//
//        Input: A = [1], K = 1
//        Output: 1
//        Example 2:
//
//        Input: A = [1,2], K = 4
//        Output: -1
//        Example 3:
//
//        Input: A = [2,-1,2], K = 3
//        Output: 3
//
//
//        Note:
//
//        1 <= A.length <= 50000
//        -10 ^ 5 <= A[i] <= 10 ^ 5
//        1 <= K <= 10 ^ 9
public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        long[] prefixSum = new long[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        int result = A.length + 1;
        Deque<Integer> monoQ = new ArrayDeque<>();
        for (int i = 0; i < prefixSum.length; i++) {
            // make sure the q is monotonious increasing
            while(!monoQ.isEmpty() && prefixSum[i] <= prefixSum[monoQ.peekLast()]) {
                monoQ.pollLast();
            }
            // shorten the sliding window and make sure window size >= K
            //[monoQ.peekFirst() + 1, i]
            while(!monoQ.isEmpty() && prefixSum[i] - prefixSum[monoQ.peekFirst()] >= K) {
                result = Math.min(result, i - monoQ.pollFirst());
            }
            monoQ.addLast(i);
        }
        return result == A.length + 1? -1 : result;
    }
}
