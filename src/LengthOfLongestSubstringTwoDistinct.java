import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * Given a string, find the the longest substring T that contains at most 2 distinct characters.
 *
 * For example, Given s = “eceba”, T is "ece"
 *
 * Hard
 * Hashtable
 * String
 */
public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String cur = s.substring(j, i);
                if (containsAtMostTwoDistinct(cur)) {
                    result = Math.max(result, cur.length());
                }
            }
        }
        return result;
    }

    private boolean containsAtMostTwoDistinct(String cur) {
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (!set.contains(cur.charAt(i))) {
                set.add(cur.charAt(i));
                count++;
            }
            if (count > 2) {
                return false;

            }
        }
        return true;
    }
}
