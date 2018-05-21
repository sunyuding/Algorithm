import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.
 *
 * E.g.    Input: n = 4, k = 2
 *
 *     Output: [
 *
 *                      [2,4],
 *
 *                      [3,4],
 *
 *                      [2,3],
 *
 *                      [1,2],
 *
 *                      [1,3],
 *
 *                      [1,4]
 *
 *         ]
 *
 *
 *
 *
 *
 * Medium
 * Depth First Search
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, k, 1, cur, result);
        return result;
    }

    private void dfs(int n, int k, int index, List<Integer> cur, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i <= n - k + 1; i++) {
            cur.add(i);
            dfs(n, k - 1, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations ins = new Combinations();
        ins.combine(4, 2);
    }
}
