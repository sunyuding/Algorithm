import java.util.Stack;

/**
 * Given an unsorted integer array,
 * remove adjacent duplicate elements repeatedly,
 * from left to right.
 * For each group of elements with the same value do not keep any of them.
 *
 * Do this in-place, using the left side of the original array.
 * Return the array after deduplication.
 *
 * Assumptions
 *
 * The given array is not null
 * Examples
 *
 * {1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
 *
 * Hard
 * array
 * Stack
 */
public class ArrayDeduplicationIV {
    public int[] dedup(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || stack.peek() != array[i]) {
                // empty or not duplicate
                stack.push(array[i]);
            } else if (stack.peek() == array[i] && ( i == array.length - 1 || stack.peek() != array[i + 1])) {
                // duplicate && (last element of the duplication)
                stack.pop();
            }
        }
        return stackToArray(stack);
    }

    private int[] stackToArray(Stack<Integer> stack) {
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
