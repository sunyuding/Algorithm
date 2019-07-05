package heap;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        if (stations == null || stations.length < 2) return 0.0;
        // maxHeap contains intervals {distance between adjacent gas stations, new stations + 1}
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0]/o2[1] - o1[0]/o1[1] < 0? -1 : 1);
        for (int i = 1; i < stations.length; i++) {
            maxHeap.offer(new double[] {stations[i] - stations[i - 1], 1.0});
        }
        for (int i = 0; i < K; i++) {
            double[] cur = maxHeap.poll();
            cur[1] += 1.0;
            maxHeap.offer(cur);
        }
        double[] max = maxHeap.peek();
        return max[0]/max[1];
    }
}
