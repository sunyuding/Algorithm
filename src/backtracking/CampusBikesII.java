package backtracking;
//On a campus represented as a 2D grid,
// there are N workers and M bikes,
// with N <= M.
// Each worker and bike is a 2D coordinate on this grid.
//
//        We assign one unique bike to each worker
// so that the sum of the Manhattan distances between each worker
// and their assigned bike is minimized.
//
//        The Manhattan distance between two points p1 and p2 is
// Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
//
//        Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
//public class CampusBikesII {
//    public int assignBikes(int[][] workers, int[][] bikes) {
//        int n = workers.length;
//        int m = bikes.length;
//        int[] res = new int[] { Integer.MAX_VALUE };
//        backtracking(workers, bikes, n, m, 0, res);
//        return res[0];
//    }
//
//    private void backtracking(int[][] workers, int[][] bikes, int n, int m, int index, int[] res) {
//        if (index == n) {
//            res[0] = Math.min(res[0], getDistances(workers, bikes, n));
//            return;
//        }
//        for (int i = index; i < m; i++) {
//            swap(bikes, index, i);
//            backtracking(workers, bikes, n, m, i + 1, res);
//            swap(bikes, index, i);
//        }
//    }
//
//    private void swap(int[][] bikes, int index, int i) {
//        int tmpX = bikes[index][0];
//        int tmpY = bikes[index][1];
//        bikes[index][0] = bikes[i][0];
//        bikes[index][1] = bikes[i][1];
//        bikes[i][0] = tmpX;
//        bikes[i][1] = tmpY;
//    }
//
//    private int getDistances(int[][] workers, int[][] bikes, int n) {
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            res += Math.abs(workers[i][0] - bikes[i][0]) + Math.abs(workers[i][1] - bikes[i][1]);
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        CampusBikesII ins = new CampusBikesII();
//        int res = ins.assignBikes(new int[][] {{0, 0}, {2, 1}}, new int[][] {{1, 2}, {3, 3}});
//        System.out.println(res);
//    }
//}

public class CampusBikesII {
    // Time: O(m ^ n)
    // Space: O(m) for boolean[m], Call Stack O(n)
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[] { Integer.MAX_VALUE };
        int n = workers.length;
        int m = bikes.length;
        backtracking(workers, bikes, n, m, 0, new boolean[m], 0, res);
        return res[0];
    }

    void backtracking(int[][] workers, int[][] bikes, int n, int m, int i, boolean[] calculated, int sum, int[] res) {
        if (i == n) {
            res[0] = Math.min(res[0], sum);
            return;
        }

        if (sum > res[0]) return;

        for (int j = 0; j < m; j++) {
            if (!calculated[j]) {
                calculated[j] = true;
                backtracking(workers,  bikes, n, m, i + 1, calculated, sum + getDistance(workers[i], bikes[j]), res);
                calculated[j] = false;
            }
        }
    }

    int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
