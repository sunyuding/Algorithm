/**
 * Given two integers dividend and divisor,
 * divide two integers without using multiplication,
 * division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment
 * which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1].
 * For the purpose of this problem,
 * assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1;
        }
        long lo = 0, hi = Math.abs((long)dividend); // in order for the case that dividend is the Integer.MIN_VALUE
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * Math.abs((long)divisor) < Math.abs((long)dividend)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (lo * Math.abs((long)divisor) == Math.abs((long)dividend)) {
            if (sign * lo > Integer.MAX_VALUE) {
                // -1 * Integer.MIN_VALUE
                return Integer.MAX_VALUE;
            }
            return (int) (sign * lo);
        }
        return (int) (sign * (lo - 1));
    }

    public static void main(String[] args) {
        DivideTwoIntegers ins = new DivideTwoIntegers();
        ins.divide(-2147483648, -1);
        System.out.println(Math.abs(-2147483648));//
    }
}
