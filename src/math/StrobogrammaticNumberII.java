package math;

import java.util.ArrayList;
import java.util.List;
//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//        Find all strobogrammatic numbers that are of length = n.
//
//        Example:
//
//        Input:  n = 2
//        Output: ["11","69","88","96"]

/**
 * 0, 1, 8
 *
 * 0, 1, 6, 8, 9
 *
 * 4/2 = 2
 * 5/2 = 2
 *
 * Time: O(5 ^ n)
 * Space: O(n)
 */
public class StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        backtracking(0, n - 1, new char[n], result);
        return result;
    }

    private void backtracking(int left, int right, char[] path, List<String> result) {
        if (left > right) {
            // n is even
            result.add(new String(path));
            return;
        }

        if (left == right) {
            // n is odd
            path[left] = '0';
            result.add(new String(path));

            path[left] = '1';
            result.add(new String(path));

            path[left] = '8';
            result.add(new String(path));
            return;
        }

        if (left > 0) {
            //'0' could not be the first element unless it is the base case
            path[left] = '0';
            path[right] = '0';
            backtracking(left + 1, right - 1, path, result);
        }

        path[left] = '1';
        path[right] = '1';
        backtracking(left + 1, right - 1, path, result);

        path[left] = '6';
        path[right] = '9';
        backtracking(left + 1, right - 1, path, result);

        path[left] = '8';
        path[right] = '8';
        backtracking(left + 1, right - 1, path, result);

        path[left] = '9';
        path[right] = '6';
        backtracking(left + 1, right - 1, path, result);
    }
}
