package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time: O(n)
 * Space:O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() &&
                    (stack.peek() == '(' && ch == ')'
                    || stack.peek() == '[' && ch == ']'
                    || stack.peek() == '{' && ch == '}')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
