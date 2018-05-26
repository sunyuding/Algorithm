/**
 * Given an integer number n,
 * find its integer square root.
 *
 * Assumption:
 *
 * n is guaranteed to be >= 0.
 * Example:
 *
 * Input: 18, Return: 4
 *
 * Input: 4, Return: 2
 *
 *
 *
 * Medium
 * Binary Search
 * Math
 */
public class SquareRootI {
    public int sqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }
        int start = 1, end = x / 2;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == x / mid) {
                // mid
                return mid;
            } else if(mid < x / mid) {
                // right side (may miss mid)
                start = mid + 1;
            } else {
                // left side definitely
                end = mid - 1;
            }
        }
        return start - 1;
    }

    public static void main(String[] args) {
        SquareRootI instance = new SquareRootI();
        instance.sqrt(1);
    }
}
