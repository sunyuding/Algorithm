import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer number,
 * return all possible combinations of the factors that can multiply to the target number.
 *
 * Example
 *
 * Give A = 24
 *
 * since 24 = 2 x 2 x 3
 *
 *               = 2 x 2 x 6
 *
 *               = 2 x 3 x 4
 *
 *               = 2 x 12
 *
 *               = 3 x 8
 *
 *               = 4 x 6
 *
 * your solution should return
 *
 * { { 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }
 *
 * note: duplicate combination is not allowed.
 *
 * Medium
 * Recursion
 */
public class FactorCombinations {
    public int[][] combinations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(target, cur,2, result);
        return listToArray(result);
    }

    private void dfs(int target, List<Integer> cur, int smallest, List<List<Integer>> result) {
        if (target == 1) {
            // base case
            // reach the child node of the dfs tree
            if (cur.size() > 1) {
                //remove target itself
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = smallest; i <= target; i++) {
            if (target % i == 0) {
                // i is factor
                cur.add(i);
                dfs(target / i, cur, i, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private int[][] listToArray(List<List<Integer>> input) {
        int[][] result = new int[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            List<Integer> curList = input.get(i);
            int[] curArray = new int[curList.size()];
            for (int j = 0; j < curList.size(); j++) {
                curArray[j] = curList.get(j);
            }
            result[i] = curArray;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorCombinations fc = new FactorCombinations();
        fc.combinations(32);
    }
}
