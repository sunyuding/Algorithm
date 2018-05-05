/**
 * Determine if two given Strings are one edit distance.
 *
 * One edit distance means you can only
 * insert one character/delete one character/replace one characternto another character in one of the two given Strings
 * and they will become identical.
 *
 * Assumptions:
 *
 * The two given Strings are not null
 * Examples:
 *
 * s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical
 *
 * s = "abc", t = "bcd" are not one edit distance
 *
 * Medium
 * String
 */
public class OneEditDistance {
    public boolean oneEditDistance(String s, String t) {
        // if s == t, return false;
        if (s == null || t == null) {
            return false;
        }

        if (s.length() == 0) {
            return t.length() == 1;
        }
        if (t.length() == 0) {
            return s.length() == 1;
        }
        if (s.charAt(s.length() - 1) == t.charAt(t.length() - 1)) {
            return oneEditDistance(s.substring(0, s.length() - 1), t.substring(0, t.length() - 1));
        } else {
            // insert last character of t to s
            // oneEditDistance(s, t.substring(0, t.length() - 1))
            if (s.equals(t.substring(0, t.length() - 1))) {
                return true;
            } else if (s.substring(0, s.length() - 1).equals(t)) {
                // delete last character of s, s substring = t
                return true;
            } else if (s.substring(0, s.length() - 1).equals(t.substring(0, t.length() - 1))) {
                // replace
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("".equals(""));
    }
}
