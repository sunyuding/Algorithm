import java.util.Arrays;
import java.util.Comparator;

public class LoginNumbersPerInterval {
    public int[][] sessionNum(int[][] logins) {
        Arrays.sort(logins, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return null;
    }
}
