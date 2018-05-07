/**
 * Given a non-empty string s,
 * you may delete at most one character.
 * Judge whether you can make it a palindrome.
 *
 *
 * Example 1:
 *
 * Input: "aba"
 * Output: True
 * Example 2:
 *
 * Input: "ababca"
 *
 *
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 *
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * Easy
 * String
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean deleted = false;
        while(i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (!deleted && s.charAt(i + 1) == s.charAt(j)) {
                    // delete j
                    deleted = true;
                    i++;
                } else if (!deleted && s.charAt(i) == s.charAt(j - 1)) {
                    //delete j
                    deleted = true;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
