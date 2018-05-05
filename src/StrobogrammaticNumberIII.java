import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 *
 * For example,
 * Given low = "50", high = "100", return 3.
 * Because 69, 88, and 96 are three strobogrammatic numbers.
 *
 * Note:
 * Because the range might be a large number, the low and high numbers are represented as string.
 *
 * Hard
 * Recursion
 * Math
 */
public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int result = 0;
        for (int i = Integer.parseInt(low); i <= Integer.parseInt(high); i++) {
            if (isStrobogrammatic(Integer.toString(i))) {
                result++;
            }
        }
        return result;
    }

    private boolean isStrobogrammatic(String num) {
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
