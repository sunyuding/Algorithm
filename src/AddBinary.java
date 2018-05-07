/**
 * Given two binary strings,
 * return their sum (also a binary string).
 *
 * Input: a = “11”
 *
 *            b = “1”
 *
 * Output: “100”
 *
 *
 *
 * Medium
 * Math
 * String
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String result = "";
        int sum = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0 || sum > 0) {
            sum += (i >= 0)? a.charAt(i) - '0' : 0;
            sum += (j >= 0)? b.charAt(j) - '0' : 0;
            result = (char)('0' + sum % 2) + result;
            sum /= 2;
            i--;
            j--;
        }
        return result;
    }
}
