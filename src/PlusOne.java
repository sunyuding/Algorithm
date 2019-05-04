import java.util.Stack;

/**
 * Given a non-negative number represented as an array of digits,
 * plus one to the number.
 *
 * Input: [2, 5, 9]
 *
 * Output: [2, 6, 0]
 *
 * Easy
 * array
 * Math
 */
public class PlusOne {
    public int[] plus(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            stack.add((digits[i] + add) % 10);// 5 + 1 % 10 = 6
            add = (digits[i] + add) / 10;// 6 /10 = 0
        }
        if (add == 1) {
            stack.add(add);
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
