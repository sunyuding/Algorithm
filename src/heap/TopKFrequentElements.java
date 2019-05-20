package heap;

import java.util.*;

public class TopKFrequentElements {
    /**
     * Runtime: 41 ms
     * Memory Usage: 39.6 MB
     * Time: O(nlogn)
     * Space: O(n)
     * @param nums
     * @param k
     * @return
     */
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {       O(n)/O(n)
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
    // O(nlogn)/O(n)
//        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2) ->  o2.getValue() - o1.getValue());
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            maxHeap.add(entry);
//        }
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            result.add(maxHeap.poll().getKey());
//        }
//        return result;
//    }

    /**
     * Runtime: 43 ms
     * Memory Usage: 41 MB
     * Time: O(n + nlogk + klogk) = O(nlogk)
     * Space: O(n)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // O(n)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) ->  map.get(o1) - map.get(o2));
        //O(nlogk)
        for (int key : map.keySet()) {
//            if (minHeap.size() < k) {
//                minHeap.add(entry.getKey());
//                continue;
//            }
//            if (entry.getValue() > minHeap.peek()) {
//                minHeap.poll();
//                minHeap.add(entry.getKey());
//            }
            minHeap.add(key);
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> result = new LinkedList<>();
        //O(klogk)
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
