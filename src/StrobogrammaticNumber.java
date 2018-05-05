import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 *
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 * Easy
 * Hashtable
 * Math
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        if (num == null || num.length() == 0) {
            return false;
        } else if (num.length() <= 2) {
            return map.containsKey(num.charAt(0)) && map.get(num.charAt(0)) == num.charAt(num.length() - 1);
        } else {
            return map.containsKey(num.charAt(0)) && map.get(num.charAt(0)) == num.charAt(num.length() - 1) &&
                    isStrobogrammatic(num.substring(1, num.length() - 1));
        }
    }
}
