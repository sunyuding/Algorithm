package heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    /**
     * Runtime: 54 ms
     * Memory Usage: 58.3 MB
     * Time: O(nlogK)
     * Space: O(K)
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> distanceMaxHeap = new PriorityQueue<>(K, ((o1, o2) -> Integer.compare((o2[0] * o2[0] + o2[1] * o2[1]), (o1[0] * o1[0] + o1[1] * o1[1]))));
        for (int[] point : points) {
            distanceMaxHeap.offer(point);
            while(distanceMaxHeap.size() > K) {
                distanceMaxHeap.poll();
            }
        }
        int[][] result = new int[distanceMaxHeap.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = distanceMaxHeap.poll();
        }
        return result;
    }
}
