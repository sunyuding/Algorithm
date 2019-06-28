package binary_search;

/**
 * On a horizontal number line,
 * we have gas stations at positions stations[0],
 * stations[1], ..., stations[N-1],
 * where N = stations.length.
 *
 * Now,
 * we add K more gas stations so that D,
 * the maximum distance between adjacent gas stations,
 * is minimized.
 *
 * Return the smallest possible value of D.
 *
 * Example:
 *
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
 * K = 9
 * Output: 0.500000
 * Note:
 *
 * stations.length will be an integer in range [10, 2000].
 * stations[i] will be an integer in range [0, 10^8].
 * K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 *
 *
 * Intuition
 *
 * Let's ask possible(D): with K (or less) gas stations,
 * can we make every adjacent distance between gas stations at most D? This function is monotone,
 * so we can apply a binary search to find D*.
 * *
 *  .
 *
 * Algorithm
 *
 * More specifically,
 * there exists some D* (the answer) for which possible(d) = False when d < D* and possible(d) = True when d > D*.
 * Binary searching a monotone function is a typical technique, so let's focus on the function possible(D).
 *
 * When we have some interval like X = stations[i+1] - stations[i],
 * X/D gas stations to ensure every subinterval has size less than D.
 * This is independent of other intervals,
 * so in total we'll need to use sum of (X/D) gas stations.
 * If this is at most K,
 * then it is possible to make every adjacent distance between gas stations at most D.
 *
 * Time Complexity: O(N * logW),
 * where N is the length of stations,
 * and W = 10^14 is the range of possible answers (10^8),
 * divided by the acceptable level of precision (10^{-6}).
 *
 * Space Complexity: O(1)O(1) in additional space complexity.
 */
public class MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        /**
         *  Note:
         *
         *  stations.length will be an integer in range [10, 2000].
         *  stations[i] will be an integer in range [0, 10^8].
         *  K will be an integer in range [1, 10^6].
         *  Answers within 10^-6 of the true value will be accepted as correct.
         *  So, we don't need to give a accurate result
         */
        double lo = 0;
        double hi = 0;
        for (int i = 1; i < stations.length; i++) {
            hi = Math.max(hi, stations[i] - stations[i - 1]);
        }
        while (hi - lo > 1e-6) {
            double mi = lo + (hi - lo) / 2.0;
            if (possible(stations, K, mi)) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return lo;
    }

    public boolean possible(int[] stations, int K, double D) {
        int count = 0;
        for (int i = 1; i < stations.length; ++i) { // O(nlogm)
            count += (int) ((stations[i] - stations[i - 1]) / D);
        }
        return count <= K;
    }

    public static void main(String[] args) {
        MinimizeMaxDistanceToGasStation ins = new MinimizeMaxDistanceToGasStation();
        ins.minmaxGasDist(new int[] {23,24,36,39,46,56,57,65,84,98}, 1);
    }
}
