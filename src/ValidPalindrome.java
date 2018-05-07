import java.util.HashSet;
import java.util.Set;

/**
 * Given a string,
 * determine if it is a palindrome,
 * considering only alphanumeric characters('0'-'9','a'-'z','A'-'Z') and ignoring cases.
 *
 * For example,
 * "an apple, :) elp pana#" is a palindrome.
 *
 * "dia monds dn dia" is not a palindrome.
 *
 * Easy
 * String
 */
public class ValidPalindrome {
    public boolean valid(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <= '9' - '0'; i++) {
            set.add((char)('0' + i));
        }
        for (int i = 0; i <= 'z' - 'a'; i++) {
            set.add((char)('a' + i));
        }
        for (int i = 0; i <= 'Z' - 'A'; i++) {
            set.add((char)('A' + i));
        }
        int l = 0, r = input.length() - 1;
        while(l < r) {
            char left = input.charAt(l);
            char right = input.charAt(r);
            if (set.contains(left) && set.contains(right) && left != right) {
                return false;
            } else if (!set.contains(left)) {
                l++;
            } else if (!set.contains(right)) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
