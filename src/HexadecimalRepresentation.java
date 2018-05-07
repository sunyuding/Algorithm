import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Generate the hexadecimal representation for a given non-negative integer number as a string.
 * The hex representation should start with "0x".
 *
 * There should not be extra zeros on the left side.
 *
 * Examples
 *
 * 0's hex representation is "0x0"
 * 255's hex representation is "0xFF"
 * Easy
 * Bit Operations
 */
public class HexadecimalRepresentation {
    public String hex(int number) {
        if (number == 0) {
            return "0x0";
        }
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, (char) i);
        }
        for (int i = 10; i < 16; i++) {
            map.put(i, (char)('A' + i - 10));
        }
        Stack<Integer> stack = new Stack<>();
        while(number > 0) {
            stack.push(number % 16);
            number = number / 16;
        }
        // number == 0
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        while(!stack.isEmpty()) {
            sb.append(map.get(stack.pop()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HexadecimalRepresentation hr = new HexadecimalRepresentation();
        hr.hex(2147483647);
    }
}
