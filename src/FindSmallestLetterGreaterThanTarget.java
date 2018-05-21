import java.util.Arrays;

/**
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 *
 * Letters also wrap around. For example,
 * if the target is target = 'z' and letters = ['a', 'b'],
 * the answer is 'a'.
 *
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        // run binary search to find smallest larger than
        int start = 0;
        int end = letters.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (letters[start] <= target) {
            // wrap around
            return letters[0];
        }
        return letters[start];
    }
}
