package math;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null) return null;
        int[] result = new int[nums.length];
        if (a == 0) {
            if (b == 0) {

            } else if (b > 0) {

            } else {
                // b < 0
            }
        } else if (a > 0) {

        } else {
            // a < 0

        }
        // case1 : a > 0
        // case2 : a == 0
        // case3 : a < 0
        double mid = -b / (2.0 * a);
        return result;
    }
}
