/**
 * There are in total n steps to climb until you can reach the top.
 * You can climb 1 or 2 steps a time.
 * Determine the number of ways you can do that.
 *
 * Example:
 *
 * Input: n = 4, Return 5.
 *
 *
 * Easy
 * Array
 */
public class ClimbingStairs {
    public int stairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return stairs(n - 1) + stairs(n - 2);
    }
}
