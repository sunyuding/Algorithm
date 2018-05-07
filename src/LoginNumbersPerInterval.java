import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of login sessions with start and end timestamps.
 *
 * Get the list of intervals with number of users logged in.
 *
 * Examples:
 *
 * login sessions: [[1, 2], [0, 4], [5, 6]]
 *
 * return [[0, 1, 1], [1, 2, 2], [2, 4, 1], [4, 5, 0], [5, 6, 1]]
 *
 * at (0, 1) there is 1 user logged in.
 *
 * at (1, 2) there is 2 user logged in.
 *
 * at (2, 4) there is 1 user logged in (one user logged out at 2).
 *
 * at (4, 5) there is no user logged in.
 *
 * at (5, 6) there is 1 user logged in.
 *
 * Medium
 * Array
 * Sort
 */
public class LoginNumbersPerInterval {
    public int[][] sessionNum(int[][] logins) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(logins, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0]? -1 : 1;
            }
        });
        int start = logins[0][0];// start index of array
        int end = logins[logins.length - 1][1];//end index of array, included
        int[] array = new int[end - start];
        for (int i = 0; i < logins.length; i++) {
            int left = logins[i][0];
            int right = logins[i][1];
            for (int j = left; j < right; j++) {
                array[j - start]++;
            }
        }
        // now we have an array of weights
        int startOffset = -1;
        int endOffset = -1;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[i - 1]) {
                startOffset = i;
            }
            if (i == array.length - 1 || array[i] != array[i + 1]) {
                endOffset = i + 1;
                // every time endOffset updates, there is a new result
                if (startOffset != -1) {
                    list.add(new int[]{start + startOffset, start + endOffset, array[startOffset]});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        LoginNumbersPerInterval lnpi = new LoginNumbersPerInterval();
        lnpi.sessionNum(new int[][]{{1,6},{2,3},{10,11},{7,11},{3,4}});
    }
}
