package hash_table;

//Given a string, find the length of the longest substring without repeating characters.

import java.util.HashSet;
import java.util.Set;

/**
 * Time: O(n)
 * Space: O(n)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = slow;
        int result = 0;
        while(slow < s.length() && fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow++));
            } else {
                set.add(s.charAt(fast++));
                result = Math.max(result, fast - slow);
            }
        }
        return result;
    }
}
