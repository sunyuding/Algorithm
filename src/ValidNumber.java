import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Validate if a given string is numeric.
 *
 * Input:  “0”    Output: true
 *
 * Input:  “ 0.1 ” Output: true
 *
 * Input:  “abc”   Output: false
 *
 * Input:  “1 a”   Output: false
 *
 * Input:  “2e10”    Output: true
 *
 * Hard
 * String
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.toLowerCase().trim();
        if (s == "e" || s == "." || s == "/") {
            return false;
        }
        Set<Character> set = new HashSet<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9','.','/','e'));
        char[] myChar = s.toCharArray();
        for (int i = 0; i < myChar.length; i++) {
            if (!set.contains(myChar[i])) {
                return false;
            }
        }
        return false;
    }
}
