/**
 * Given two strings A and B,
 * find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution,
 * return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”),
 * B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        // case 1 A = "abcd" B = ""
        if (B.length() == 0) {
            return 1;
        }
        if (A.length() == 0) {
            return -1;
        }
        int count = 0;
        // case 2 A = "abcd" B = "cd"
         //                       i
        // case 3 A = "abcd" B = "cdab"
        //                        i
        // case 4 A = "abcd" B = "cdabcdab"
         //                             i
        // cou = 1

        int i = 0;
        int j = i;
        while (i < B.length()) {
            if (i + A.length() <= B.length() && B.substring(i, i + A.length()).equals(A)) {
                if (count == 0) {
                    // first middle
                    if (!isSubstring(A, B.substring(0, i))) {
                        return -1;
                    }
                    count++;
                }
                i = i + A.length();
                count++;
            } else if (isSubstring(A, B.substring(i, B.length()))) {

            } else {
                i++;
            }
        }
        return count;
    }

    // b is substring of a
    private boolean isSubstring(String a, String b) {
        for (int i = 0; i + b.length() <= a.length(); i++) {
            if (a.substring(i, i + b.length()).equals(b)) {
                return true;
            }
        }
        return false;
    }
}
