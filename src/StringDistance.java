/**
 * Given an array of strings,
 * and two different string s and t.
 * We need to return the smallest indices difference between the two given strings.
 *
 * Return -1 if we can not find s or t in the array.
 *
 * Assumptions:
 *
 * The given array is not null, none of the strings in the array is null.
 * s and t are different and they are not null.
 * Examples:
 *
 * array =  {"this", "is", "a", "is", "fox", "happy"},
 * the distance of "fox" and "is" is 1.
 *
 *
 * Easy
 * array
 * String
 */
public class StringDistance {
    public int distance(String[] array, String s, String t) {
        int sIndex = -1, tIndex = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(s)) {
                sIndex = i;
                if (tIndex != -1) {
                    result = Math.min(result, sIndex - tIndex);
                }
            }
            if (array[i].equals(t)) {
                tIndex = i;
                if (sIndex != -1) {
                    result = Math.min(result, tIndex - sIndex);
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            // Return -1 if we can not find s or t in the array.
            return -1;
        }
        return result;
    }
}
